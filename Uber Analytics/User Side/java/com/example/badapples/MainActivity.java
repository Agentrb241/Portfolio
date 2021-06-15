package com.example.badapples;

import android.content.Intent;
import android.os.Bundle;;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrieve id's from layout
        final Button file0 = findViewById(R.id.File_0);
        final Button file1 = findViewById(R.id.File_1);
        final Button file2 = findViewById(R.id.File_2);
        final Button file3 = findViewById(R.id.File_3);

        
        // create an intent to open the FileActivity and then create bundle pass File argument inside intent
        Intent openFileActivity = new Intent(MainActivity.this, ImportActivity.class);
        Bundle bundle = new Bundle();

        // listener for file0 button
        file0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("File", 0);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });

        // listener for file1 button
        file1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 1 to the intent and start the FileActivity
                bundle.putInt("File", 1);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });

        // listener for file2 button
        file2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 2 to the intent and start the FileActivity
                bundle.putInt("File", 2);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });

        // listener for file3 button
        file3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // add the File argument 3 to the intent and start the FileActivity
                bundle.putInt("File", 3);
                openFileActivity.putExtras(bundle);
                startActivity(openFileActivity);
            }
        });



    }

}
