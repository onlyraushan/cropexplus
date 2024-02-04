package com.theakj.cropexplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;

public class Login extends AppCompatActivity {

    MediaPlayer mp=new MediaPlayer();
    Button magicloginBtn;
    TextView signupBtn;
    FirebaseFirestore database;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        database= FirebaseFirestore.getInstance();
        mauth=FirebaseAuth.getInstance();

        magicloginBtn=findViewById(R.id.magicLoginBtn);
        magicloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        });

        mauth.signInWithEmailAndPassword("farmer@gmail.com","farmer1").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(Login.this, "Account created and login successfully", Toast.LENGTH_SHORT).show();
            }
        });

        signupBtn=findViewById(R.id.signUp);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                startActivity(new Intent(Login.this,signup.class));
            }
        });
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
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mauth.getCurrentUser();
        if(user != null){
            startActivity(new Intent(Login.this,MainActivity.class));
            finish();
        }
        findbhasa();
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
                            String apath1 = "android.resource://" + getPackageName() + "/raw/ea1";
                            startAudio(apath1);
                        } else if (x.equals("2")) {
                            String apath1 = "android.resource://" + getPackageName() + "/raw/ha1";
                            startAudio(apath1);
                        } else if (x.equals("3")) {
                            String apath1 = "android.resource://" + getPackageName() + "/raw/ba1";
                            startAudio(apath1);
                        }
                    } else {
                        Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}