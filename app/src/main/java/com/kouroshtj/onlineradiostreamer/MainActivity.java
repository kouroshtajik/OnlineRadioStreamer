package com.kouroshtj.onlineradiostreamer;
import androidx.appcompat.app.AppCompatActivity;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    String stream1 = "https://radio1.guaracast.com:8427/stream";
    String stream2 = "https://wpr-ice.streamguys1.com/wpr-music-mp3-96";
    String stream3 = "https://stream.wqxr.org/wqxr-web?nyprBrowserId=2fae6ba98c53a80";
    String stream4 = "https://worldwidefm.out.airtime.pro/worldwidefm_b";
    String stream5 = "https://usa7.fastcast4u.com/proxy/pghola05?mp=/1";
    String stream6 = "";
    String stream7 = "";
    String stream8 = "";
    String stream9 = "";
    String stream10 = "";
    String stream11 = "";
    String stream12 = "";
    String stream13 = "";
    String stream14 = "";
    String stream15 = "";
    int channelNumber;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay1 = findViewById(R.id.btnPlay1);
        Button btnPause1 = findViewById(R.id.btnPause1);

        Button btnPlay2 = findViewById(R.id.btnPlay2);
        Button btnPause2 = findViewById(R.id.btnPause2);

        Button btnPlay3 = findViewById(R.id.btnPlay3);
        Button btnPause3 = findViewById(R.id.btnPause3);

        TextView txtStatus = findViewById(R.id.txtStatus);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);






        //play and pause button CH 1-------1--------1------1-------1--------1---------1------1------1--------1
        btnPlay1.setOnClickListener(view -> {
            txtStatus.setText("Buffering");
            if (channelNumber == 1) {
                txtStatus.setText("channelNumber: " + channelNumber);
                mediaPlayer.start();
            }else {

                mediaPlayer.pause();
                mediaPlayer.reset();
                try {
                    mediaPlayer.setDataSource(stream1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                channelNumber = 1;
                txtStatus.setText("channelNumber: " + channelNumber);
            }
        });


        btnPause1.setOnClickListener(view -> {
            channelNumber = 1;
            mediaPlayer.pause();

        });


        //play and pause button CH 2------2------2--------2-------2-------2---------2--------2-------2-------2------2

        btnPlay2.setOnClickListener(view -> {
            if (channelNumber == 2) {
                txtStatus.setText("channelNumber: " + channelNumber);
                mediaPlayer.start();
            }else {
                mediaPlayer.pause();
                mediaPlayer.reset();
                try {
                    mediaPlayer.setDataSource(stream2);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                channelNumber = 2;
                txtStatus.setText("channelNumber: " + channelNumber);
            }
        });


        btnPause2.setOnClickListener(view -> {
            channelNumber = 2;
            mediaPlayer.pause();

        });

        //play and pause button CH 3----3----3-----3-----3-----3-----3----3----3-----3-----3

        btnPlay3.setOnClickListener(view -> {
            if (channelNumber == 3) {
                txtStatus.setText("channelNumber: " + channelNumber);
                mediaPlayer.start();
            }else {
                mediaPlayer.pause();
                mediaPlayer.reset();
                try {
                    mediaPlayer.setDataSource(stream3);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                channelNumber = 3;
                txtStatus.setText("channelNumber: " + channelNumber);

            }
        });

        btnPause3.setOnClickListener(view -> {
            channelNumber = 3;
            mediaPlayer.pause();


        });






    }

}