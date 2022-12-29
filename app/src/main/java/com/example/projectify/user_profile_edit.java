package com.example.projectify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class user_profile_edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_edit);

        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setSelectedItemId(R.id.nav_profile);

        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                         startActivity(new Intent(getApplicationContext(),tasks_view.class));
                         overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_profile:
//                        startActivity(new Intent(getApplicationContext(),user_profile_edit.class));
//                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_calendar:
                        startActivity(new Intent(getApplicationContext(),calendar.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_message:
                        startActivity(new Intent(getApplicationContext(),ChatsList.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}