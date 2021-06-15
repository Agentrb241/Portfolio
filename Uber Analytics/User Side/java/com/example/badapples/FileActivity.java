package com.example.badapples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.badapples.Server.post;

public class FileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        // get arguments
        Bundle arguments = getIntent().getExtras(); //gets arg
        final int File = arguments.getInt("File"); //retrieves arg

        // retrieve id's from layout
        final TextView filename = findViewById(R.id.tV_FileName);
        final Button fileupdate = findViewById(R.id.File_Update);
        final Button fileinsert = findViewById(R.id.File_Insert);
        final Button filedelete = findViewById(R.id.File_Delete);
        final Button filesearch = findViewById(R.id.File_Search);
        final Button filebackup = findViewById(R.id.File_Backup);

        // arrays to help with dynamically setting which files
        String[] fileNames = {"UberJan-Feb-FOIL", "Other-Dial7-B0087", "Other-Firstclass-B01578", "Uber-raw-data-apr14"};

        // set file name on screen
        filename.setText(fileNames[File]);

        // listener for Search
        filesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent openSearchActivity = new Intent(FileActivity.this, SearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("File", File);
                openSearchActivity.putExtras(bundle);
                startActivity(openSearchActivity);
            }
        });

        // listener for update button
        fileupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openUpdateActivity = new Intent(FileActivity.this, UpdateActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("File", File);
                openUpdateActivity.putExtras(bundle);
                startActivity(openUpdateActivity);
            }
        });

        // listener for insert button
        fileinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openInsertActivity = new Intent(FileActivity.this, InsertActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("File", File);
                openInsertActivity.putExtras(bundle);
                startActivity(openInsertActivity);
            }
        });

        // listener for delete button
        filedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent openDeleteActivity = new Intent(FileActivity.this, DeleteActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("File", File);
                openDeleteActivity.putExtras(bundle);
                startActivity(openDeleteActivity);
            }
        });

        // listener for backup button
        filebackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* send file number to servlet that moves temp to /back-UpFileNum*/
                String servlet = String.format("http://10.0.2.2:8080/BadAPPles/BackUp?param1=%1$s", Integer.toString(File));
                post(getApplicationContext(), servlet);
            }
        });


    }

}
