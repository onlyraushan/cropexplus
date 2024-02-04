package com.theakj.cropexplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bnv);
        frameLayout=findViewById(R.id.fl);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId==R.id.settingss){
                    loadFragment(new SettingsFragment(),false);
                }else if(itemId==R.id.shop){
                    loadFragment(new ShopFragment(),false);
//                }else if(itemId==R.id.learn){
//                    loadFragment(new LearnFragment(),false);
                }else{
                    loadFragment(new HomeFragment(),false);
                }
                return true;
            }
        });

        loadFragment(new HomeFragment(),true);
    }
    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(isAppInitialized){
            fragmentTransaction.add(R.id.fl,fragment);
        }else{
            fragmentTransaction.replace(R.id.fl,fragment);
        }
        fragmentTransaction.commit();
    }
}