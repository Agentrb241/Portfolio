package com.example.badapples;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.badapples.Server.search;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // get arguments
        //Bundle arguments = getIntent().getExtras(); //gets arg
        //final int File = arguments.getInt("File"); //retrieves arg

        // retrieve id's from layout
        final TextView filename = findViewById(R.id.tVSearch_filename);
        final Button searchquery1 = findViewById(R.id.tVSearch_Query1);
        final Button searchquery2 = findViewById(R.id.tVSearch_Query2);
        final Button searchquery3 = findViewById(R.id.tVSearch_Query3);
        final Button searchquery4 = findViewById(R.id.tVSearch_Query4);
        final Button searchquery5 = findViewById(R.id.tVSearch_Query5);
        final Button searchquery6 = findViewById(R.id.tVSearch_Query6);
        final TextView result = findViewById(R.id.tVSearch_Result);

        // arrays to help with dynamically setting which files
        //String[] fileNames = {"UberJan-Feb-FOIL", "Other-Dial7-B0087", "Other-Firstclass-B01578", "Uber-raw-data-apr14"};

        //String[] searches = {"# of times 1/1/2015 was searched", "# of times Manhattan is used",
          //                   "# of time firstclass vehicles are used", "# of rides 10:00Am - 11:59AM",
            //                 "# of active vehicles over 1000", "# of times Park AVE is used"};

        String[] servlets = {"http://10.0.2.2:8080/BadAPPles/RidesOnDate", "http://10.0.2.2:8080/BadAPPles/RidesInBurrough",
                             "http://10.0.2.2:8080//BadAPPles/FirstClassServlet", "http://10.0.2.2:8080/BadAPPles/HowManyPast10Servlet",
                              "http://10.0.2.2:8080/BadAPPles/ActiveVehiclesOver1000Servlet", "http://10.0.2.2:8080/BadAPPles/StreetServlet"};

        // set file name on screen
        //filename.setText(fileNames[File]);

        // set text inside button 1
        //searchquery1.setText(searches[File]);

        // listener for search1 button
        searchquery1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                search(getApplicationContext(), result, servlets[0]);
            }
        });
        searchquery2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                search(getApplicationContext(), result, servlets[1]);
            }
        });
        searchquery3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                search(getApplicationContext(), result, servlets[2]);
            }
        });
        searchquery4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                search(getApplicationContext(), result, servlets[3]);
            }
        });
        searchquery5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                search(getApplicationContext(), result, servlets[4]);
            }
        });
        searchquery6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                search(getApplicationContext(), result, servlets[5]);
            }
        });
/*
        // set listener for search2 button only if file is 0 or 1
        if (File == 0 || File == 1) {
            // set text inside button 2
            searchquery2.setText(searches[File + 4]);
            // listener for search2
            searchquery2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    search(getApplicationContext(), result, servlets[File + 4]); // 5 & 6 are for the files that have 2 searches
                }
            });
        }
        else {
            ViewGroup.LayoutParams param = searchquery2.getLayoutParams();
            param.height = 0;
            searchquery2.setLayoutParams(param);
            searchquery2.setVisibility(View.GONE);
        }
*/
    }
}
