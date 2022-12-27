package com.example.projectify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectify.Adapters.ProjectsAdapter;
import com.example.projectify.Models.Projects;

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