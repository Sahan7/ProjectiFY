package com.example.projectify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class calendar extends AppCompatActivity {

    // Calendar
    EditText title,location,description;
    Button addEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

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
                        startActivity(new Intent(getApplicationContext(),user_profile_edit.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_calendar:
//                        startActivity(new Intent(getApplicationContext(),calendar.class));
//                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_message:
                        startActivity(new Intent(getApplicationContext(),ChatsList.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

                title = findViewById(R.id.etTitle);
        location = findViewById(R.id.etLocation);
        description = findViewById(R.id.etDescription);
        addEvent = findViewById(R.id.btnAdd);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!title.getText().toString().isEmpty() && !location.getText().toString().isEmpty() && !description.getText().toString().isEmpty()){

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE,title.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION,description.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION,location.getText().toString());
                    // This allows to change the time of the event - set to "true"
                    intent.putExtra(CalendarContract.Events.ALL_DAY,true);
                    // This allows to add people by email
                    intent.putExtra(Intent.EXTRA_EMAIL,"test@yahoo.com,test2@yahoo.com");

                    // Check if the event can be handled by a Calendar event in the packet manager
                    if(intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }else{
                        Toast.makeText(calendar.this,"No Calendar App",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(calendar.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}