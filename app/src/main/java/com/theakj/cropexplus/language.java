package com.theakj.cropexplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.ActivityCompat;
import android.content.res.Configuration;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class language extends AppCompatActivity {

    Button continueBtn,cl;
    int bhasa;
    TextView english,hindi,bengali;
    LinearLayout ll1,ll2,ll3;
    FirebaseFirestore database;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_activity);
        loadLocale();
        database= FirebaseFirestore.getInstance();
        mauth=FirebaseAuth.getInstance();
        english=findViewById(R.id.english);
        hindi=findViewById(R.id.hindi);
        bengali=findViewById(R.id.bengali);

        ll1=findViewById(R.id.ll1);
        ll2=findViewById(R.id.ll2);
        ll3=findViewById(R.id.ll3);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bhasa=1;
                changeColour(bhasa);
            }
        });
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bhasa=2;
                changeColour(bhasa);
            }
        });
        bengali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bhasa=3;
                changeColour(bhasa);
            }
        });




        continueBtn=findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bhasa!=1){
                    uploadData(bhasa);
                    startActivity(new Intent(language.this,Login.class));
                }
            }
        });
        cl=findViewById(R.id.cl);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseLanguage();
            }
        });
    }

    private void changeColour(int bhasa) {
        if(bhasa==1) {
            ll3.setBackgroundColor(Color.WHITE);
            ll2.setBackgroundColor(Color.WHITE);
            ll1.setBackgroundColor(Color.GREEN);
        }
        else if(bhasa==2) {
            ll3.setBackgroundColor(Color.WHITE);
            ll2.setBackgroundColor(Color.GREEN);
            ll1.setBackgroundColor(Color.WHITE);
        }
        else if(bhasa==3) {
            ll3.setBackgroundColor(Color.GREEN);
            ll2.setBackgroundColor(Color.WHITE);
            ll1.setBackgroundColor(Color.WHITE);
        };
        continueBtn.setBackgroundColor(Color.RED);
    }

    private void chooseLanguage() {
        final String languages[]= {"English" , "Hindi", "Bengali"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Choose Languages");
        mBuilder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    setLocale("");
                    recreate();
                }
                else if(which==1){
                    setLocale("hi");
                    recreate();
                }
                else if(which==2){
                    setLocale("bn");
                    recreate();
                }

            }
        });
        mBuilder.create();
        mBuilder.show();
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("app_lang",language);
        editor.apply();
    }
    private void loadLocale(){
        SharedPreferences preferences = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = preferences.getString("app_lang","");
        setLocale(language);
    }
    public void uploadData(int bhasa){
        HashMap<String,String> hm=new HashMap<>();
        hm.put("bhasa", String.valueOf(bhasa));
        database.collection("settings")
                .document("farmer").set(hm).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(language.this, "Language Uploaded Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(language.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mauth.getCurrentUser();
        if(user != null){
            startActivity(new Intent(language.this,MainActivity.class));
            finish();
        }
    }
}