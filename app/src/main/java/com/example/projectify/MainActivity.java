package com.example.projectify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectify.Adapters.ProjectsAdapter;
import com.example.projectify.Models.Projects;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText title,location,description;
    Button addEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


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
                        Toast.makeText(MainActivity.this,"No Calendar App",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}