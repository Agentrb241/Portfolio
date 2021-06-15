import java.io.*;
import java.util.*;

import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LatLong extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LatLong() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        //parsing a CSV file into Scanner class constructor
        String line = "";

        PrintWriter out = response.getWriter();
        //int increment = 0;

        //int index = 0;

        //ArrayList<String>  Lat1 = new ArrayList<String>();
        //ArrayList<String>  Long1 = new ArrayList<String>();
        Map<String, Integer> LatLong1 = new HashMap<String, Integer>();
        //ArrayList<Integer> fin1 = new ArrayList<Integer>();
        ArrayList<String> time1 = new ArrayList<String>();

        Map<String, Integer> LatLong2 = new HashMap<String, Integer>();
        //ArrayList<String>  Lat2 = new ArrayList<String>();
        //ArrayList<String>  Long2 = new ArrayList<String>();
        ArrayList<String> time2 = new ArrayList<String>();
        //ArrayList<Integer> fin2 = new ArrayList<Integer>();

        Map<String, Integer> LatLong3 = new HashMap<String, Integer>();
        //ArrayList<String>  Lat3 = new ArrayList<String>();
        //ArrayList<String>  Long3 = new ArrayList<String>();
        ArrayList<String> time3 = new ArrayList<String>();
        //ArrayList<Integer> fin3 = new ArrayList<Integer>();

        List<String[]> cachedResults = new ArrayList();
        File file = new File("/Library/apache-tomcat-10.0.5/webapps/BadAPPles/Cache/uber-raw-data-apr14.csv");

        try
        {
           if (file.exists()){

                BufferedReader br = new BufferedReader(new FileReader(file));
               br.readLine();
                while ((line = br.readLine()) != null)   //returns a Boolean value
               {
                   String[] employee = line.split(",");
                   int i=Integer.parseInt(employee[2]);

                   if ((employee[0].contains(" 0:")) || employee[0].contains(" 1:") || employee[0].contains(" 2:") || employee[0].contains(" 3:") || employee[0].contains(" 4:")) {
                       LatLong1.put(employee[1] , i);

                   }
                   if ((employee[0].contains(" 5:")) || employee[0].contains(" 6:") || employee[0].contains(" 7:") || employee[0].contains(" 8:") || employee[0].contains(" 9:")) {
                       LatLong2.put(employee[1] , i);

                   }
                   if ((employee[0].contains(" 10:")) || employee[0].contains(" 11:") || employee[0].contains(" 12:") || employee[0].contains(" 13:") || employee[0].contains(" 14:")) {
                       LatLong3.put(employee[1] , i);
                   }


               }

               List<String> key1 = LatLong1.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
               int maxValueIntMap1 = (Collections.max(LatLong1.values()));
               LatLong1.replace(key1.get(0), 1);

               List<String> key2 = LatLong2.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
               int maxValueIntMap2 = (Collections.max(LatLong1.values()));
               LatLong2.replace(key2.get(0), 1);

               List<String> key3 = LatLong3.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
               int maxValueIntMap3 = (Collections.max(LatLong1.values()));
               LatLong3.replace(key3.get(0), 1);

               String[] stringArray = new String[3];
               stringArray[0] = key1.get(0) + ": " + String.valueOf(maxValueIntMap1);
               stringArray[1] = key2.get(0) + ": " + String.valueOf(maxValueIntMap2);
               stringArray[2] = key3.get(0) + ": " + String.valueOf(maxValueIntMap3);

               JSONstring parser = new JSONstring();
               String result = parser.toJSON(stringArray);
               out.println(result);


           }

            else {
                File file1 = new File("/Library/apache-tomcat-10.0.5/webapps/BadAPPles/Data/uber-raw-data-apr14.csv");
                InputStream inputStream = new FileInputStream(file1);
                CSVFile csvFile = new CSVFile(inputStream);
                List<String[]> csvList = csvFile.read();
                DataList data = new DataList(csvList);

                file.createNewFile();
                //parsing a CSV file into BufferedReader class constructor
                BufferedReader br = new BufferedReader(new FileReader("/Library/apache-tomcat-10.0.5/webapps/BadAPPles/Data/uber-raw-data-apr14.csv"));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] employee = line.split(",");    // use comma as separator

                    if ((employee[0].contains(" 0:")) || employee[0].contains(" 1:") || employee[0].contains(" 2:") || employee[0].contains(" 3:") || employee[0].contains(" 4:")) {
                        String temp = employee[1] + " " + employee[2]; // Lat + Long
                        if (LatLong1.containsKey(temp)) { //true or false
                            LatLong1.replace(temp, LatLong1.get(temp) + 1);
                        } else {
                            LatLong1.put(temp, 1);
                            time1.add(employee[0]);

                        }
                    }

                    if ((employee[0].contains(" 5:")) || employee[0].contains(" 6:") || employee[0].contains(" 7:") || employee[0].contains(" 8:") || employee[0].contains(" 9:")) {
                        String temp = employee[1] + " " + employee[2]; // Lat + Long
                        if (LatLong2.containsKey(temp)) { //true or false
                            LatLong2.replace(temp, LatLong2.get(temp) + 1);
                        } else {
                            LatLong2.put(temp, 1);
                            time2.add(employee[0]);

                        }

                    }
                    if ((employee[0].contains(" 10:")) || employee[0].contains(" 11:") || employee[0].contains(" 12:") || employee[0].contains(" 13:") || employee[0].contains(" 14:")) {
                        String temp = employee[1] + " " + employee[2]; // Lat + Long
                        if (LatLong3.containsKey(temp)) { //true or false
                            LatLong3.replace(temp, LatLong3.get(temp) + 1);
                        } else {
                            LatLong3.put(temp, 1);
                            time3.add(employee[0]);
                        }
                    }


                }
                br.close();

               String[] columns = {"Time","Lat Long", "Count"};
                cachedResults.add(columns);

                for (Map.Entry<String, Integer> pair : LatLong1.entrySet()) {
                    int i = 0;
                    String temp = pair.getKey();
                    String t = time1.get(i);
                    i++;
                    String[] values = {t,temp, String.valueOf(pair.getValue())};
                    cachedResults.add(values);
                }

               for (Map.Entry<String, Integer> pair : LatLong2.entrySet()) {
                   int i = 0;
                   String temp = pair.getKey();
                   String t = time2.get(i);
                   i++;
                   String[] values = {t,temp, String.valueOf(pair.getValue())};
                   cachedResults.add(values);
               }

               for (Map.Entry<String, Integer> pair : LatLong3.entrySet()) {
                   int i = 0;
                   String temp = pair.getKey();
                   String t = time3.get(i);
                   i++;
                   String[] values = {t,temp, String.valueOf(pair.getValue())};
                   cachedResults.add(values);
               }

                DataList dataCache = new DataList(cachedResults);
                csvFile.write(dataCache.getData(), "/Library/apache-tomcat-10.0.5/webapps/BadAPPles/Cache/uber-raw-data-apr14.csv");

                List<String> key1 = LatLong1.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
                int maxValueIntMap1 = (Collections.max(LatLong1.values()));
                LatLong1.replace(key1.get(0), 1);

                List<String> key2 = LatLong2.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
                int maxValueIntMap2 = (Collections.max(LatLong1.values()));
                LatLong2.replace(key2.get(0), 1);

                List<String> key3 = LatLong3.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
                int maxValueIntMap3 = (Collections.max(LatLong1.values()));
                LatLong3.replace(key3.get(0), 1);

                String[] stringArray = new String[3];
                stringArray[0] = key1.get(0) + ": " + String.valueOf(maxValueIntMap1);
                stringArray[1] = key2.get(0) + ": " + String.valueOf(maxValueIntMap2);
                stringArray[2] = key3.get(0) + ": " + String.valueOf(maxValueIntMap3);

                JSONstring parser = new JSONstring();
                String result = parser.toJSON(stringArray);
                out.println(result);
                //write to file



                }

            }
        catch (IOException e)
            {
                e.printStackTrace();
            }


        }
    }
