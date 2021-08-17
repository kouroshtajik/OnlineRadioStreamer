package com.kouroshtj.onlineradiostreamer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class ThreadClass extends AppCompatActivity implements Runnable {

    MediaPlayer mediaPlayer = new MediaPlayer();


    @Override
    public  void run() {

        if (MainActivity.status == "n") {

            switch (MainActivity.btn) {
                case "btnPlay1":
                    MainActivity.status = "CH 1";
                break;
                case "btnPlay2":
                    MainActivity.status = "CH 2";
                break;
                case "btnPlay3":
                    MainActivity.status = "CH 3";
                break;
                default:
            }

            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            try {
                mediaPlayer.setDataSource(MainActivity.stream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();

            MainActivity.txtStatus.setText("Playing " + MainActivity.status);


        }else if (MainActivity.status == "CH 1" || MainActivity.status == "CH 2" || MainActivity.status == "CH 3") {

            mediaPlayer.pause();
            MainActivity.txtStatus.setText("Paused");
            MainActivity.status = "pause";
        }else if (MainActivity.status == "pause") {
            mediaPlayer.start();
        }

    }


}
