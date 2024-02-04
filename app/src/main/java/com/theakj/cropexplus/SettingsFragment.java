package com.theakj.cropexplus;


import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;
import java.util.Objects;

public class SettingsFragment extends Fragment {

/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    } */

    Button changeLanguageBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_settings, container, false);
        loadLocale();
        changeLanguageBtn=view.findViewById(R.id.changeLanguage);
        changeLanguageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseLanguage();
            }
        });
        return view;
    }
    private void chooseLanguage() {
        final String languages[]= {"English" , "Hindi", "Bengali"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        mBuilder.setTitle("Choose Languages");
        mBuilder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    setLocale("");
                    ActivityCompat.recreate(requireActivity());
                }
                else if(which==1){
                    setLocale("hi");
                    ActivityCompat.recreate(requireActivity());
                }
                else if(which==2){
                    setLocale("bn");
                    ActivityCompat.recreate(requireActivity());
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
        getContext().getResources().updateConfiguration(configuration,getContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = requireContext().getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("app_lang",language);
        editor.apply();
    }
    private void loadLocale(){
        SharedPreferences preferences = requireContext().getSharedPreferences("Settings", MODE_PRIVATE);
        String language = preferences.getString("app_lang","");
        setLocale(language);
    }
}