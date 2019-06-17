package com.example.zeroc.fitness;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import Database.DatabaseExView;

public class ExViewActivity extends AppCompatActivity {
    private static final int STATE_PAUSED = 0;
    private static final int STATE_PLAYING = 1;
    private int currentState;
    private MediaBrowserCompat mediaBrowserCompat;
    int image_id;
    String name;
    TextView timer, title;
    ImageView detail_image;
    Button btnStart;
    // check btnStart's state
    boolean isRunning = false;

    DatabaseExView workoutDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ex_view );
        workoutDB = new DatabaseExView( this );

        timer = findViewById( R.id.timer );
        title = findViewById( R.id.titleEx );
        detail_image = findViewById( R.id.detail_image );
        mediaBrowserCompat = new MediaBrowserCompat(this, new ComponentName(this, BackgroundAudioService.class),
                connectionCallback, getIntent().getExtras());
        mediaBrowserCompat.connect();

        btnStart = findViewById( R.id.btnStart );
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( currentState == STATE_PAUSED ) {
                    MediaControllerCompat.getMediaController(ExViewActivity.this).getTransportControls().play();
                    currentState = STATE_PLAYING;
                } else {
                    if( MediaControllerCompat.getMediaController(ExViewActivity.this).getPlaybackState().getState() == PlaybackStateCompat.STATE_PLAYING ) {
                        MediaControllerCompat.getMediaController(ExViewActivity.this).getTransportControls().pause();
                    }

                    currentState = STATE_PAUSED;
                }
            }
        });
//        btnStart.setOnClickListener( new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // Timer
//                if (!isRunning) {
//                    btnStart.setText( "DONE" );
//
//                    int timeLimit = 0;
//                    // set TimeLimit
//                    if (workoutDB.getSettingMode() == 0) {
//                        timeLimit = Common.TIME_LIMIT_EASY;
//                    } else if (workoutDB.getSettingMode() == 1) {
//                        timeLimit = Common.TIME_LIMIT_MEDIUM;
//                    } else if (workoutDB.getSettingMode() == 2) {
//                        timeLimit = Common.TIME_LIMIT_HARD;
//                    }
//
//                    new CountDownTimer( timeLimit, 1000 ) {
//                        @Override
//                        public void onTick(long millisUntilFinished) {
//                            timer.setText( "" + millisUntilFinished / 1000 );
//                        }
//
//                        @Override
//                        public void onFinish() {
//                            Toast.makeText( ExViewActivity.this, "Finish!!", Toast.LENGTH_SHORT ).show();
//                            finish();
//                        }
//                    }.start();
//                } else {
//                    Toast.makeText( ExViewActivity.this, "Finish!!", Toast.LENGTH_SHORT ).show();
//                    finish();
//                }
//                isRunning = !isRunning;
//            }
//        } );

        timer.setText( "" );
        // get intent from ListExercise
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
            super.onPlaybackStateChanged(state);
            if( state == null ) {
                return;
            }

            switch( state.getState() ) {
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
                MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(ExViewActivity.this, mediaBrowserCompat.getSessionToken());
                mediaControllerCompat.registerCallback(mediaControllerCompatCallback);
                MediaControllerCompat.setMediaController(ExViewActivity.this,mediaControllerCompat);
                MediaControllerCompat.getMediaController(ExViewActivity.this).getTransportControls().playFromMediaId(String.valueOf(R.raw.dau_de_truong_thanh_onlyc),null);

            } catch( RemoteException e ) {
                e.printStackTrace();
            }
        }
    };

}

