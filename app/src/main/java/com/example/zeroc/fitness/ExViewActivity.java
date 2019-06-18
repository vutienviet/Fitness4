package com.example.zeroc.fitness;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import Database.DatabaseExView;

public class ExViewActivity extends AppCompatActivity {
    private static final int STATE_PAUSED = 0;
    private static final int STATE_PLAYING = 1;
    private int currentState;
    boolean stop = false;
    Thread t;
    final Handler handle = new Handler(  );
    private MediaBrowserCompat mediaBrowserCompat;
    int image_id;
    String name;
    TextView timer, title;
    ImageView detail_image;
    Button btnStart, btnStop;
    // check btnStart's state
    boolean isRunning = false;

    DatabaseExView workoutDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ex_view );
        workoutDB = new DatabaseExView( this );

        timer = findViewById( R.id.timer );
        btnStop = findViewById( R.id.btnStop );
        title = findViewById( R.id.titleEx );
        detail_image = findViewById( R.id.detail_image );
        mediaBrowserCompat = new MediaBrowserCompat( this, new ComponentName( this, BackgroundAudioService.class ),
                connectionCallback, getIntent().getExtras() );
        mediaBrowserCompat.connect();

        btnStart = findViewById( R.id.btnStart );
        btnStart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (timer.getText().toString() == null) {
                    timer.setText( "30" );
                }
                String countDown = timer.getText().toString();
                final int[] countDownInt = {Integer.parseInt( countDown )};

                t = new Thread(  ){
                    @Override
                    public void run(){
                        while(!isInterrupted()){
                            try {
                                Thread.sleep( 1000 );
                                runOnUiThread( new Runnable() {
                                    @Override
                                    public void run() {
                                        countDownInt[0]--;
                                        timer.setText( String.valueOf( countDownInt[0] ) );
                                        if (countDownInt[0] == 0){
                                            timer.setText( "0" );
                                            handle.postDelayed( t , 1000000 );
                                            t.interrupt();
                                        }
                                    }
                                } );
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                };

                t.start();
//                String countDownText = String.valueOf( countDownInt[0] );
                Toast.makeText( ExViewActivity.this, countDown, Toast.LENGTH_LONG ).show();
                if (currentState == STATE_PAUSED) {
                    MediaControllerCompat.getMediaController( ExViewActivity.this ).getTransportControls().play();
                    currentState = STATE_PLAYING;
                }
//                else {
//                    if( MediaControllerCompat.getMediaController(ExViewActivity.this).getPlaybackState().getState() == PlaybackStateCompat.STATE_PLAYING ) {
//                        MediaControllerCompat.getMediaController(ExViewActivity.this).getTransportControls().pause();
//                    }
//
//                    currentState = STATE_PAUSED;
//                }
            }
        } );

        btnStop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MediaControllerCompat.getMediaController( ExViewActivity.this ).getPlaybackState().getState() == PlaybackStateCompat.STATE_PLAYING) {
                    MediaControllerCompat.getMediaController( ExViewActivity.this ).getTransportControls().pause();
                }

                currentState = STATE_PAUSED;

            }
        } );


//

//        timer.setText( "" );
//        // get intent from ListExercise
        if (getIntent() != null) {
            image_id = getIntent().getIntExtra( "image_id", -1 );
            name = getIntent().getStringExtra( "name" );

            //  detail_image.setImageResource(image_id);
            Glide.with( this ).load( image_id ).into( detail_image );
            title.setText( name );

        }
    }


    private MediaControllerCompat.Callback mediaControllerCompatCallback = new MediaControllerCompat.Callback() {

        @Override
        public void onPlaybackStateChanged(PlaybackStateCompat state) {
            super.onPlaybackStateChanged( state );
            if (state == null) {
                return;
            }

            switch (state.getState()) {
                case PlaybackStateCompat.STATE_PLAYING: {
                    currentState = STATE_PLAYING;
                    break;
                }
                case PlaybackStateCompat.STATE_PAUSED: {
                    currentState = STATE_PAUSED;
                    break;
                }
            }
        }
    };
    private MediaBrowserCompat.ConnectionCallback connectionCallback = new MediaBrowserCompat.ConnectionCallback() {

        @Override
        public void onConnected() {
            super.onConnected();
            try {
                MediaControllerCompat mediaControllerCompat = new MediaControllerCompat( ExViewActivity.this, mediaBrowserCompat.getSessionToken() );
                mediaControllerCompat.registerCallback( mediaControllerCompatCallback );
                MediaControllerCompat.setMediaController( ExViewActivity.this, mediaControllerCompat );
                MediaControllerCompat.getMediaController( ExViewActivity.this ).getTransportControls().playFromMediaId( String.valueOf( R.raw.dau_de_truong_thanh_onlyc ), null );

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
}