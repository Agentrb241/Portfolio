package com.example.badapples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalyticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytic);

        final Button activity1 = findViewById(R.id.activity1button);
        final Button activity2 = findViewById(R.id.activity2button);
        final Button activity3 = findViewById(R.id.activity3button);
        final Button activity4 = findViewById(R.id.activity4button);
        final Button activity5 = findViewById(R.id.activity5button);
        final Button activity6 = findViewById(R.id.activity6button);
        final Button activity7 = findViewById(R.id.activity7button);

        Intent openFileActivity = new Intent(AnalyticActivity.this, GraphActivity.class);
        Bundle bundle = new Bundle();

        activity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("activity", 0);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("activity", 1);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });

        activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("activity", 2);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });

        activity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("activity", 3);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });

        activity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("activity", 4);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });

        activity6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("activity", 5);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });
        activity7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("activity", 6);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });



    }
}