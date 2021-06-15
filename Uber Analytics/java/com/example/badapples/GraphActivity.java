package com.example.badapples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
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
        final int Analytics = arguments.getInt("Analytics"); //retrieves arg

        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> number = new ArrayList<Integer>();


        String url1 = "http://10.0.2.2:8080/BadAPPles/Top3Hours";
        String url2 = "http://10.0.2.2:8080/BadAPPles/Top3Streets";
        String url3 = "http://10.0.2.2:8080/BadAPPles/TopStreetsTime";
        String url4 = "http://10.0.2.2:8080/BadAPPles/NumPeopleArrived";
        String url5 = "http://10.0.2.2:8080/BadAPPles/LatLong";
        String url6 = "http://10.0.2.2:8080/BadAPPles/TopVehicleAM";
        String url7 = "http://10.0.2.2:8080/BadAPPles/TopVehiclePM";

        RequestQueue requestQueue;
        StringRequest stringRequest;
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        if (Analytics == 0) {
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
                                barChart.animateY(2500);
                                barChart.setDescription("");

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

        } else if (Analytics == 1) {
            stringRequest = new StringRequest(Request.Method.GET, url2,
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
                                barChart.animateY(2500);
                                barChart.setDescription("");

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

        } else if(Analytics == 2) {
            stringRequest = new StringRequest(Request.Method.GET, url3,
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
                                barChart.animateY(2500);
                                barChart.setDescription("");

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

        } else if(Analytics == 3) {
            stringRequest = new StringRequest(Request.Method.GET, url4,
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
                                barChart.animateY(2500);
                                barChart.setDescription("");

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

        } else if(Analytics == 4) {
            stringRequest = new StringRequest(Request.Method.GET, url5,
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

                                String[] latLong = {"40.74-74.00", "40.74-74.01", "40.77-73.96"};
                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");
                                    ;
                                    String line[] = temp.split(splitBy);
                                    labels.add(latLong[i]);
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(2500);
                                barChart.setDescription("");

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

        } else if(Analytics == 5) {
            stringRequest = new StringRequest(Request.Method.GET, url6,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject responseJSON = new JSONObject(response);
                                JSONArray valuesJSON = responseJSON.getJSONArray("JSON_Objects");

                                BarChart barChart = (BarChart) findViewById(R.id.barchart);
                                ArrayList<BarEntry> entries = new ArrayList<>();
                                ArrayList<String> labels = new ArrayList<String>();
                                BarDataSet bardataset = new BarDataSet(entries, "Cells");

                                String splitBy = ":";
                                for (int i = 0; i < valuesJSON.length(); i++) {
                                    String temp = valuesJSON.getJSONObject(i).toString();
                                    temp = temp.replace("{", "");
                                    temp = temp.replace("}", "");
                                    temp = temp.replace("\"", "");

                                    String line[] = temp.split(splitBy);

                                    if(i < 2){
                                        labels.add("0-6AM FC/HC");
                                    }
                                    else {
                                        labels.add("6-12AM FC/HC");
                                    }
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(2500);
                                barChart.setDescription("");


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

        } else if(Analytics == 6) {
            stringRequest = new StringRequest(Request.Method.GET, url7,
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
                                    if(i < 2){
                                        labels.add("12-6PM FC/HC");
                                    }
                                    else {
                                        labels.add("6-12PM FC/HC");
                                    }
                                    entries.add(new BarEntry(Integer.parseInt(line[1]), i));
                                }

                                BarData data = new BarData(labels, bardataset);
                                barChart.setData(data); // set the data and list of labels into chart
                                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                barChart.animateY(2500);
                                barChart.setDescription("");

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
        }
    }
}