package com.example.badapples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.badapples.Server.getFiles;

public class ImportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        // get arguments
        Bundle arguments = getIntent().getExtras(); //gets arg
        final int File = arguments.getInt("File"); //retrieves arg

        final TextView importname = findViewById(R.id.tvImport_Name);
        final RecyclerView rvImport = findViewById(R.id.rvImport_Recycyler);

        // arrays to help with dynamically setting which files
        String[] fileNames = {"UberJan-Feb-FOIL", "Other-Dial7-B0087", "Other-Firstclass-B01578", "Uber-raw-data-apr14"};
        String[] servlets = {"http://10.0.2.2:8080/BadAPPles/ImportUberJanFebFOIL", "http://10.0.2.2:8080/BadAPPles/ImportOtherDial7",
                             "http://10.0.2.2:8080/BadAPPles/ImportOtherFirstClass", "http://10.0.2.2:8080/BadAPPles/ImportUberRawData"};

        // set file name on screen
        importname.setText(fileNames[File]);

        // getFiles function call to server, also display file names inside adapter
        getFiles(getApplicationContext(), servlets[File], File, rvImport);

    }

}

