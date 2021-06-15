package com.example.badapples;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.badapples.Helpers.Server.post;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        // get arguments
        Bundle arguments = getIntent().getExtras(); //gets arg
        final int File = arguments.getInt("File"); //retrieves arg

        // retrieve id's from layout
        final TextView insertname = findViewById(R.id.tV_InsertName);
        final EditText insertcolumn1 = findViewById(R.id.eT_InsertColumn1);
        final EditText insertcolumn2 = findViewById(R.id.eT_InsertColumn2);
        final EditText insertcolumn3 = findViewById(R.id.eT_InsertColumn3);
        final EditText insertcolumn4 = findViewById(R.id.eT_InsertColumn4);
        final EditText insertcolumn5 = findViewById(R.id.eT_InsertColumn5);
        final EditText insertcolumn6  = findViewById(R.id.eT_InsertColumn6);
        final TextView tvInsertColumn1 = findViewById(R.id.tvInsert_Column1);
        final TextView tvInsertColumn2 = findViewById(R.id.tvInsert_Column2);
        final TextView tvInsertColumn3 = findViewById(R.id.tvInsert_Column3);
        final TextView tvInsertColumn4 = findViewById(R.id.tvInsert_Column4);
        final TextView tvInsertColumn5 = findViewById(R.id.tvInsert_Column5);
        final TextView tvInsertColumn6 = findViewById(R.id.tvInsert_Column6);
        final Button insert = findViewById(R.id.bt_Insert);

        // dial = 6, firstClass = 3, jan-feb = 4, april = 4

        // arrays to help with dynamically setting which files
        String[] fileNames = {"UberJan-Feb-FOIL", "Other-Dial7-B0087", "Other-Firstclass-B01578",
                              "Uber-raw-data-apr14","other-Federal_02216", "other-Highclass_B01717"};


        // set file name on screen
        insertname.setText(fileNames[File]);
        if (File == 0) {
            tvInsertColumn1.setText("Dispatch Base Num:");
            tvInsertColumn2.setText("Date:");
            tvInsertColumn3.setText("Active Vehicles:");
            tvInsertColumn4.setText("Trips:");
        } else if (File == 1){
            tvInsertColumn1.setText("Date:");
            tvInsertColumn2.setText("Time:");
            tvInsertColumn3.setText("State:");
            tvInsertColumn4.setText("PuFrom:");
            tvInsertColumn5.setText("Address:");
            tvInsertColumn6.setText("Street:");
        } else if (File == 2){
            tvInsertColumn1.setText("Date:");
            tvInsertColumn2.setText("Time:");
            tvInsertColumn3.setText("Pickup Address:");
        } else if (File == 3){
            tvInsertColumn1.setText("Date/Time");
            tvInsertColumn2.setText("Lat:");
            tvInsertColumn3.setText("Lon:");
            tvInsertColumn4.setText("Base:");
        }

        // hide columns for files that don't need them
        if (File == 2){ // file 2 only has 3 columns, therefore hide the rest of the views
            ViewGroup.LayoutParams param4 = insertcolumn4.getLayoutParams();
            param4.height = 0;
            insertcolumn4.setLayoutParams(param4);
            insertcolumn4.setVisibility(View.GONE);

            ViewGroup.LayoutParams paramTV4 = tvInsertColumn4.getLayoutParams();
            paramTV4.height = 0;
            tvInsertColumn4.setLayoutParams(paramTV4);
            tvInsertColumn4.setVisibility(View.GONE);

            ViewGroup.LayoutParams param5 = insertcolumn5.getLayoutParams();
            param5.height = 0;
            insertcolumn5.setLayoutParams(param5);
            insertcolumn5.setVisibility(View.GONE);

            ViewGroup.LayoutParams paramTV5 = tvInsertColumn5.getLayoutParams();
            paramTV5.height = 0;
            tvInsertColumn5.setLayoutParams(paramTV5);
            tvInsertColumn5.setVisibility(View.GONE);

            ViewGroup.LayoutParams param6 = insertcolumn6.getLayoutParams();
            param6.height = 0;
            insertcolumn6.setLayoutParams(param6);
            insertcolumn6.setVisibility(View.GONE);

            ViewGroup.LayoutParams paramTV6 = tvInsertColumn6.getLayoutParams();
            paramTV6.height = 0;
            tvInsertColumn6.setLayoutParams(paramTV6);
            tvInsertColumn6.setVisibility(View.GONE);
        }
        else if (File == 0 || File == 3){ // file 0 & 3 only have 4 columns, therefore hide the rest of the views

            ViewGroup.LayoutParams param5 = insertcolumn5.getLayoutParams();
            param5.height = 0;
            insertcolumn5.setLayoutParams(param5);
            insertcolumn5.setVisibility(View.GONE);

            ViewGroup.LayoutParams paramTV5 = tvInsertColumn5.getLayoutParams();
            paramTV5.height = 0;
            tvInsertColumn5.setLayoutParams(paramTV5);
            tvInsertColumn5.setVisibility(View.GONE);

            ViewGroup.LayoutParams param6 = insertcolumn6.getLayoutParams();
            param6.height = 0;
            insertcolumn6.setLayoutParams(param6);
            insertcolumn6.setVisibility(View.GONE);

            ViewGroup.LayoutParams paramTV6 = tvInsertColumn6.getLayoutParams();
            paramTV6.height = 0;
            tvInsertColumn6.setLayoutParams(paramTV6);
            tvInsertColumn6.setVisibility(View.GONE);
        }



        // listener for insert button
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initiate send string with file
                String send = "";

                // all files have 3 columns, therefore concatenate them to send
                final String column1 = insertcolumn1.getText().toString();
                final String column2 = insertcolumn2.getText().toString();
                final String column3 = insertcolumn3.getText().toString();
                send += column1 + "," + column2 + "," + column3;

                if (File == 0 || File == 3){
                    // concatenate column 4 to send
                    final String column4 = insertcolumn4.getText().toString();
                    send += "," + column4;
                }
                else if (File == 2){
                    // concatenate column 4,5,6 to send
                    final String column4 = insertcolumn4.getText().toString();
                    final String column5 = insertcolumn5.getText().toString();
                    final String column6 = insertcolumn6.getText().toString();
                    send += "," + column4 + "," + column5 + "," + column6;
                }

                String servlet = String.format("http://10.0.2.2:8080/BadAPPles/Insert?param1=%1$s&param2=%2$s",
                        Integer.toString(File), send);

                post(getApplicationContext(), servlet);
            }
        });


    }
}
