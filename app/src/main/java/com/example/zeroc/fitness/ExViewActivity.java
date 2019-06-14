package com.example.zeroc.fitness;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zeroc.fitness.model.Common;

import Database.DatabaseExView;

public class ExViewActivity extends AppCompatActivity {

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

        btnStart = findViewById( R.id.btnStart );
        btnStart.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Timer
                if (!isRunning) {
                    btnStart.setText( "DONE" );

                    int timeLimit = 0;
                    // set TimeLimit
                    if (workoutDB.getSettingMode() == 0) {
                        timeLimit = Common.TIME_LIMIT_EASY;
                    } else if (workoutDB.getSettingMode() == 1) {
                        timeLimit = Common.TIME_LIMIT_MEDIUM;
                    } else if (workoutDB.getSettingMode() == 2) {
                        timeLimit = Common.TIME_LIMIT_HARD;
                    }

                    new CountDownTimer( timeLimit, 1000 ) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            timer.setText( "" + millisUntilFinished / 1000 );
                        }

                        @Override
                        public void onFinish() {
                            Toast.makeText( ExViewActivity.this, "Finish!!", Toast.LENGTH_SHORT ).show();
                            finish();
                        }
                    }.start();
                } else {
                    Toast.makeText( ExViewActivity.this, "Finish!!", Toast.LENGTH_SHORT ).show();
                    finish();
                }
                isRunning = !isRunning;
            }
        } );

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
}
