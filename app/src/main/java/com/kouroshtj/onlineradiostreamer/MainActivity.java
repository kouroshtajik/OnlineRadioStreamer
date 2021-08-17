package com.kouroshtj.onlineradiostreamer;
import androidx.appcompat.app.AppCompatActivity;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stream1 = "https://radio1.guaracast.com:8427/stream";
        stream2 ="https://wpr-ice.streamguys1.com/wpr-music-mp3-96";
        stream3 ="https://stream.wqxr.org/wqxr-web?nyprBrowserId=2fae6ba98c53a80";
        stream4 ="https://worldwidefm.out.airtime.pro/worldwidefm_b";
        stream5 ="https://usa7.fastcast4u.com/proxy/pghola05?mp=/1";

        btnPlay1 = findViewById(R.id.btnPlay1);
        btnPause1 = findViewById(R.id.btnPause1);

        btnPlay2 = findViewById(R.id.btnPlay2);
        btnPause2 = findViewById(R.id.btnPause2);

        btnPlay3 = findViewById(R.id.btnPlay3);
        btnPause3 = findViewById(R.id.btnPause3);
        txtStatus = findViewById(R.id.txtStatus);


        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        ThreadClass threadClass = new ThreadClass();
        Thread thread = new Thread(threadClass);
        status = "n";
        btn = "n";





        //play and pause button CH 1-------1--------1------1-------1--------1---------1------1------1--------1
        btnPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn = "btnPlay1";
                if (status == "n" ) {
                    stream = stream1;
                    thread.start();
                    txtStatus.setText("Buffering");
                }else if (status == "pause") {
                    threadClass.run();
                }
            }
        });




        btnPause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn != "n") {
                    btn = "btnPause1";
                    threadClass.run();
                }else {
                    txtStatus.setText("Please Play a Channel First!");
                }

            }
        });


        //play and pause button CH 2------2------2--------2-------2-------2---------2--------2-------2-------2------2
        btnPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn = "btnPlay2";
                if (status == "n" ) {
                    stream = stream2;
                    thread.start();
                    txtStatus.setText("Buffering");
                }else if (status == "pause") {
                    threadClass.run();
                }

            }
        });

        btnPause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn != "n") {
                    btn = "btnPause2";
                    threadClass.run();
                }else {
                    txtStatus.setText("Please Play a Channel First!");
                }

            }
        });
        //play and pause button CH 3----3----3-----3-----3-----3-----3----3----3-----3-----3
        btnPlay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn = "btnPlay3";
                if (status == "n" ) {
                    stream = stream3;
                    thread.start();
                    txtStatus.setText("Buffering");
                }else if (status == "CH 3") {
                    threadClass.run();
                }

            }
        });
        btnPause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn != "n") {
                    btn = "btnPause2";
                    threadClass.run();
                }else {
                    txtStatus.setText("Please Play a Channel First!");
                }
            }
        });


    }


    public  static String stream;
    public  static String stream1;
    public  static String stream2;
    public  static String stream3;
    public  static String stream4;
    public  static String stream5;



    public static String btn;
    public static String status;
    public static TextView txtStatus;
    public static Button btnPlay1;
    public static Button btnPause1;
    public static Button btnPlay2;
    public static Button btnPause2;
    public static Button btnPlay3;
    public static Button btnPause3;
}