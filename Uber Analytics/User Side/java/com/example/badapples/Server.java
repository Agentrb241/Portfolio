package com.example.badapples;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Server extends AppCompatActivity  {

    public static void search(Context context, TextView result, String url) { // GET
        RequestQueue requestQueue;
        StringRequest stringRequest;
        requestQueue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the response
                        result.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
    }

    public static void getRow(Context context, TextView DisplayRow, String File, String row){
        RequestQueue requestQueue;
        StringRequest stringRequest;
        requestQueue = Volley.newRequestQueue(context);

        String url = String.format("http://10.0.2.2:8080/BadAPPles/SendRow?param1=%1$s&param2=%2$s", File, row);

        // Request a string response from the provided URL.
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the response
                        DisplayRow.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                DisplayRow.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
    }

    public static void post(Context context, String url) { // POST
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VOLLEY", response);
                System.out.println(" ================== SUCCESS");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
                System.out.println(" ================== ERROR");
            }
        }); /* {

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return sendString == null ? null : sendString.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", sendString, "utf-8");
                    return null;
                }
            }

        };*/
        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
    }

    public static void getFiles(Context context, String url, int File, RecyclerView rvImport) { // GET
        RequestQueue requestQueue;
        StringRequest stringRequest;
        requestQueue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String results = response;
                        String[] files = results.split(",");

                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
                        RecyclerView.Adapter mAdapter = new FilesAdapter(files, context, File);
                        rvImport.setHasFixedSize(true);
                        rvImport.setLayoutManager(mLayoutManager);
                        rvImport.setAdapter(mAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Error
            }
        });
        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
    }


}


