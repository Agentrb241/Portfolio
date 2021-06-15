package com.example.badapples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Bundle arguments = getIntent().getExtras(); //gets arg
        final int activity = arguments.getInt("activity"); //retrieves arg

        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> number = new ArrayList<Integer>();


        String url1 = "http://10.0.2.2:8080/BadAPPles/Top3Hours";
        String url2 = "http://10.0.2.2:8080/BadAPPles/Top3Streets";
        String url3 = "http://10.0.2.2:8080/BadAPPles/Feature3";
        String url4 = "http://10.0.2.2:8080/BadAPPles/Feature4";
        String url5 = "http://10.0.2.2:8080/BadAPPles/Feature5";
        String url6 = "http://10.0.2.2:8080/BadAPPles/Feature6";
        String url7 = "http://10.0.2.2:8080/BadAPPles/Feature7";

        RequestQueue requestQueue;
        StringRequest stringRequest;
        StringRequest stringRequest2;
        StringRequest stringRequest3;
        StringRequest stringRequest4;
        StringRequest stringRequest5;
        StringRequest stringRequest6;
        StringRequest stringRequest7;
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        if ( activity == 0) {
            stringRequest = new StringRequest(Request.Method.GET, url1,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject responseJSON = new JSONObject(response);

                                JSONArray valuesJSON = responseJSON.getJSONArray("JSON_Objects");

                                BarChart barChart = (BarChart) findViewById(R.id.barchart);

                                ArrayList<BarEntry> entries = new ArrayList<>();

                                BarDataSet bardataset = new BarDataSet(entries, "Cells");

                                ArrayList<String> labels = new ArrayList<String>();

                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");
                                    
                                    String line[] = temp.split(splitBy);
                                    labels.add(line[0]);
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(5000);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    name.add("That didn't work!");
                    number.add(0);
                }
            });

            requestQueue.add(stringRequest);
        } else if (activity == 1) {
            stringRequest2 = new StringRequest(Request.Method.GET, url2,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject responseJSON = new JSONObject(response);

                                JSONArray valuesJSON = responseJSON.getJSONArray("JSON_Objects");

                                BarChart barChart = (BarChart) findViewById(R.id.barchart);

                                ArrayList<BarEntry> entries = new ArrayList<>();

                                BarDataSet bardataset = new BarDataSet(entries, "Cells");

                                ArrayList<String> labels = new ArrayList<String>();

                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");
                                    ;
                                    String line[] = temp.split(splitBy);
                                    labels.add(line[0]);
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(5000);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    name.add("That didn't work!");
                    number.add(0);
                }
            });

            requestQueue.add(stringRequest2);
        } else if(activity == 2) {
            stringRequest3 = new StringRequest(Request.Method.GET, url3,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject responseJSON = new JSONObject(response);

                                JSONArray valuesJSON = responseJSON.getJSONArray("JSON_Objects");

                                BarChart barChart = (BarChart) findViewById(R.id.barchart);

                                ArrayList<BarEntry> entries = new ArrayList<>();

                                BarDataSet bardataset = new BarDataSet(entries, "Cells");

                                ArrayList<String> labels = new ArrayList<String>();

                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");
                                    ;
                                    String line[] = temp.split(splitBy);
                                    labels.add(line[0]);
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(5000);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    name.add("That didn't work!");
                    number.add(0);
                }
            });

            requestQueue.add(stringRequest3);
        } else if(activity == 3) {
            stringRequest4 = new StringRequest(Request.Method.GET, url4,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject responseJSON = new JSONObject(response);

                                JSONArray valuesJSON = responseJSON.getJSONArray("JSON_Objects");

                                BarChart barChart = (BarChart) findViewById(R.id.barchart);

                                ArrayList<BarEntry> entries = new ArrayList<>();

                                BarDataSet bardataset = new BarDataSet(entries, "Cells");

                                ArrayList<String> labels = new ArrayList<String>();

                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");
                                    ;
                                    String line[] = temp.split(splitBy);
                                    labels.add(line[0]);
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(5000);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    name.add("That didn't work!");
                    number.add(0);
                }
            });

            requestQueue.add(stringRequest4);
        } else if(activity == 4) {
            stringRequest5 = new StringRequest(Request.Method.GET, url5,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject responseJSON = new JSONObject(response);

                                JSONArray valuesJSON = responseJSON.getJSONArray("JSON_Objects");

                                BarChart barChart = (BarChart) findViewById(R.id.barchart);

                                ArrayList<BarEntry> entries = new ArrayList<>();

                                BarDataSet bardataset = new BarDataSet(entries, "Cells");

                                ArrayList<String> labels = new ArrayList<String>();

                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");
                                    ;
                                    String line[] = temp.split(splitBy);
                                    labels.add(line[0]);
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(5000);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    name.add("That didn't work!");
                    number.add(0);
                }
            });

            requestQueue.add(stringRequest5);
        } else if(activity == 5) {
            stringRequest6 = new StringRequest(Request.Method.GET, url6,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject responseJSON = new JSONObject(response);

                                JSONArray valuesJSON = responseJSON.getJSONArray("JSON_Objects");

                                BarChart barChart = (BarChart) findViewById(R.id.barchart);

                                ArrayList<BarEntry> entries = new ArrayList<>();

                                BarDataSet bardataset = new BarDataSet(entries, "Cells");

                                ArrayList<String> labels = new ArrayList<String>();

                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");
                                    ;
                                    String line[] = temp.split(splitBy);
                                    labels.add(line[0]);
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(5000);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    name.add("That didn't work!");
                    number.add(0);
                }
            });

            requestQueue.add(stringRequest6);
        } else if(activity == 6) {
            stringRequest7 = new StringRequest(Request.Method.GET, url7,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject responseJSON = new JSONObject(response);

                                JSONArray valuesJSON = responseJSON.getJSONArray("JSON_Objects");

                                BarChart barChart = (BarChart) findViewById(R.id.barchart);

                                ArrayList<BarEntry> entries = new ArrayList<>();

                                BarDataSet bardataset = new BarDataSet(entries, "Cells");

                                ArrayList<String> labels = new ArrayList<String>();

                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");
                                    ;
                                    String line[] = temp.split(splitBy);
                                    labels.add(line[0]);
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(5000);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    name.add("That didn't work!");
                    number.add(0);
                }
            });

            requestQueue.add(stringRequest7);
        }
    }
}