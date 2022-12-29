package com.example.projectify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.projectify.Adapters.ProjectsAdapter;
import com.example.projectify.Models.Projects;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class user_view_tasks extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Projects> projectsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_tasks);
        recyclerView = findViewById(R.id.recycler_homeview);

        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setSelectedItemId(R.id.nav_profile);

        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        //startActivity(new Intent(getApplicationContext(),tasks_view.class));
                        //overridePendingTransition(0,0);
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
                        //startActivity(new Intent(getApplicationContext(),ChatsList.class));
                        //overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        initData();
        setRecyclerView();
    }



    private void setRecyclerView() {
        ProjectsAdapter projectsAdapter = new ProjectsAdapter(projectsList);
        recyclerView.setAdapter(projectsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        projectsList = new ArrayList<>();
        // Get these from database and remove these
        projectsList.add(new Projects("Project 01", "Task 1"));
        projectsList.add(new Projects("Project 02", "Task 2"));
        projectsList.add(new Projects("Project 03", "Task 3"));
        projectsList.add(new Projects("Project 04", "Task 4"));
        projectsList.add(new Projects("Project 05", "Task 5"));
        projectsList.add(new Projects("Project 06", "Task 6"));
        projectsList.add(new Projects("Project 07", "Task 7"));
        projectsList.add(new Projects("Project 08", "Task 8"));
    }
}