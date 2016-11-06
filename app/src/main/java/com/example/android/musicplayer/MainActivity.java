package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
   // private int forwardTime = 5000;
    private double startTime = 0;
    private double finalTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.sample01);


        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
               mediaPlayer.start();
            }

        });
        Button pauseButton = (Button) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }

        });
        Button forwardButton = (Button) findViewById(R.id.forward_button);
        forwardButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;
                int forwardTime = 5000;

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button stopButton = (Button) findViewById(R.id.stop_button);
        stopButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }

        });

        }


}
