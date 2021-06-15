package com.example.badapples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button user = findViewById(R.id.User_Button);
        final Button files = findViewById(R.id.File_Button);

        Intent openFileActivity = new Intent(HomeActivity.this, UserActivity.class);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(openFileActivity);
            }
        });

        Intent openFileActivity2 = new Intent(HomeActivity.this, MainActivity.class);

        files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(openFileActivity2);
            }
        });
    }
}