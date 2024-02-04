package com.theakj.cropexplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;

public class signup extends AppCompatActivity {

    MediaPlayer mp=new MediaPlayer();
    FirebaseFirestore database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        database= FirebaseFirestore.getInstance();

    }
    public void startAudio(String apath){
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        Uri audiouri= Uri.parse(apath);
        try {
            mp.setDataSource(this,audiouri);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onBackPressed() {
        mp.pause();
        super.onBackPressed();
    }


    @Override
    protected void onStart() {
        findbhasa();
        super.onStart();
    }

    private void findbhasa() {
        DocumentReference document=database.collection("settings").document("farmer");
        document.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String x = document.getString("bhasa");
                        if (x.equals("1")) {
                            String apath1 = "android.resource://" + getPackageName() + "/raw/ea2";
                            startAudio(apath1);
                        } else if (x.equals("2")) {
                            String apath1 = "android.resource://" + getPackageName() + "/raw/ha2";
                            startAudio(apath1);
                        } else if (x.equals("3")) {
                            String apath1 = "android.resource://" + getPackageName() + "/raw/ba2";
                            startAudio(apath1);
                        }
                    } else {
                        Toast.makeText(signup.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}