package com.theakj.cropexplus;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;

public class HomeFragment extends Fragment {

  /*  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    } */

    Button askExpert,viewSolution;
    FirebaseFirestore database;
    MediaPlayer mp=new MediaPlayer();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);

        askExpert=view.findViewById(R.id.askExpert);
        viewSolution=view.findViewById(R.id.viewSolution);
        database= FirebaseFirestore.getInstance();

        askExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                startActivity(new Intent(getContext(),UploadActivity.class));
            }
        });
        viewSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                startActivity(new Intent(getContext(),SolutionActivity.class));
            }
        });

        return view;
    }
    @Override
    public void onStart() {
        mp.pause();
        findbhasa();
        super.onStart();
    }
    public void startAudio(String apath){
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        Uri audiouri= Uri.parse(apath);
        try {
            mp.setDataSource(getContext(),audiouri);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void findbhasa() {
        DocumentReference document = database.collection("settings").document("farmer");
        document.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String x = document.getString("bhasa");
                        if (x.equals("1")) {
                            String apath1 = "android.resource://" + getActivity().getPackageName() + "/raw/ea3";
                            startAudio(apath1);
                        } else if (x.equals("2")) {
                            String apath1 = "android.resource://" + getActivity().getPackageName() + "/raw/ha3";
                            startAudio(apath1);
                        } else if (x.equals("3")) {
                            String apath1 = "android.resource://" + getActivity().getPackageName() + "/raw/ba3";
                            startAudio(apath1);
                        }
                    } else {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}