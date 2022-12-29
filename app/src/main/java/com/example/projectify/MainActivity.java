package com.example.projectify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectify.Adapters.ProjectsAdapter;
import com.example.projectify.Models.Projects;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<setOnItemSelectedListener> extends AppCompatActivity {

    // Recycler
    RecyclerView recyclerView;
    List<Projects> eventsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
//
      //  recyclerView = findViewById(R.id.recycler_homeview);

        initData();
        setRecyclerView();


//       TextView username =(TextView) findViewById(R.id.username);
//       TextView password =(TextView) findViewById(R.id.password);
//
//       MaterialButton loginbutton = (MaterialButton) findViewById(R.id.loginbutton);
//
//
//      loginbutton.setOnClickListener(new View.OnClickListener() {
//          @Override
//           public void onClick(View view) {
//              if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//                   Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
//              }else{
//                   Toast.makeText(MainActivity.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();
//               }
//           }
//       });

         @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
         bottomnav.setSelectedItemId(R.id.nav_home);

         bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch(item.getItemId()){
                     case R.id.nav_home:
//                         startActivity(new Intent(getApplicationContext(),tasks_view.class));
//                         overridePendingTransition(0,0);
                         return true;
                     case R.id.nav_profile:
                         startActivity(new Intent(getApplicationContext(),user_profile_edit.class));
                         overridePendingTransition(0,0);
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





// For Recycler View
    private void setRecyclerView() {
        ProjectsAdapter projectsAdapter = new ProjectsAdapter(eventsList);
        recyclerView.setAdapter(projectsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        eventsList  = new ArrayList<>();
        // Get these from database and remove these
        eventsList.add(new Projects("Project 01","Task 1"));
        eventsList.add(new Projects("Project 02","Task 2"));
        eventsList.add(new Projects("Project 03","Task 3"));
        eventsList.add(new Projects("Project 04","Task 4"));
        eventsList.add(new Projects("Project 05","Task 5"));
        eventsList.add(new Projects("Project 06","Task 6"));
        eventsList.add(new Projects("Project 07","Task 7"));
        eventsList.add(new Projects("Project 08","Task 8"));
        eventsList.add(new Projects("Project 09","Task 9"));

    }
}