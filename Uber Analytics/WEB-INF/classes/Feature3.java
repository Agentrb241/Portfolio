import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



//0-8, 9-16,17-24
//street, count

//How popularity of streets change through out the day


public class Feature3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Feature3() {
        super();
    }

    private static final String col_separator = " , ";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String pathToCache = "../webapps/BadAPPles/Cache/Feature3.csv";
        String pathToTemp = "../webapps/BadAPPles/temp/other-Dial7_B00887.csv";
        Map.Entry<String, Integer> maxEntry = null;
        Map<String, Integer> interval = new HashMap<String, Integer>();
        Map<String, Integer> interval1 = new HashMap<String, Integer>(); //0-6
        Map<String, Integer> interval2 = new HashMap<String, Integer>(); //0-6
        Map<String, Integer> interval3 = new HashMap<String, Integer>(); //0-6

        ///*
        File tempFile = new File(pathToCache);
        boolean exists = tempFile.exists();
        if (exists){
            //get results from cache
            BufferedReader br = new BufferedReader(new FileReader(pathToCache));
            String line = null;
            while ((line = br.readLine()) != null) {
                // read into map
                String[] col = line.split(",");
                String street = col[1].trim();
                String count = col[2].trim();
                boolean notFirstLine = !col[2].equals("Count");
                if(notFirstLine) {
                    Integer cnt = Integer.parseInt(count);
                    if(col[0].equals("1")) {
                        interval1.put(street, cnt);
                    }
                    else if(col[0].equals("2")){
                        interval2.put(street, cnt);
                    }
                    else if(col[0].equals("3")){
                        interval3.put(street, cnt);
                    }
                }
            }
            br.close();

            //get sorted values
            //List<String> key1 = interval.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

            List<String> key1 = interval1.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> key2 = interval2.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> key3 = interval3.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1).map(Map.Entry::getKey).collect(Collectors.toList());
            int maxValueInMap1=(Collections.max(interval1.values()));
            int maxValueInMap2=(Collections.max(interval2.values()));
            int maxValueInMap3=(Collections.max(interval3.values()));


            // send results to client
            String[] stringArray = new String[3];
            //stringArray[0] = key1.get(0) + ": " + interval.get(key1.get(0));;
            //stringArray[1] = key1.get(1) + ": " + interval.get(key1.get(1));;
            //stringArray[2] = key1.get(2) + ": " + interval.get(key1.get(2));;
            stringArray[0] = key1.get(0) + ": " + String.valueOf(maxValueInMap1);;
            stringArray[1] = key2.get(0) + ": " + String.valueOf(maxValueInMap2);;
            stringArray[2] = key3.get(0) + ": " + String.valueOf(maxValueInMap3);;
            JSONstring parser = new JSONstring();
            String result = parser.toJSON(stringArray);
            out.println(result);
        }
        else
        { // do the stuff from previous sprints and at the end create a cache file that stores the counts for all hours not just the top 3
        //*/

            BufferedReader br = new BufferedReader(new FileReader(pathToTemp));
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] col = line.split(",");
                String street = col[5].trim();
                String time = col[1].trim();
                String hour = time.split(":")[0];

                NumberFormat nf = NumberFormat.getInstance();

                try {
                    int x = (int) nf.parse(hour).doubleValue();
                    //int x = Integer.parseInt(hour);

                    if (street.trim().isEmpty()) {
                    } else if (x < 8) {
                        if (interval1.containsKey(street)) {
                            // just increment count
                            interval1.replace(street, interval1.get(street) + 1);
                        } else {
                            // add it and increment count
                            interval1.put(street, 1);
                        }
                    } else if (x < 16) {
                        if (interval2.containsKey(street)) {
                            // just increment count
                            interval2.replace(street, interval2.get(street) + 1);
                        } else {
                            // add it and increment count
                            interval2.put(street, 1);
                        }
                    } else if (x < 24) {
                        if (interval3.containsKey(street)) {
                            // just increment count
                            interval3.replace(street, interval3.get(street) + 1);
                        } else {
                            // add it and increment count
                            interval3.put(street, 1);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            br.close();

            List<String> key1 = interval1.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> key2 = interval2.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> key3 = interval3.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1).map(Map.Entry::getKey).collect(Collectors.toList());

            int maxValueInMap1 = (Collections.max(interval1.values()));
            int maxValueInMap2 = (Collections.max(interval2.values()));
            int maxValueInMap3 = (Collections.max(interval3.values()));

            String[] stringArray = new String[3];

            stringArray[0] = key1.get(0) + ": " + String.valueOf(maxValueInMap1);
            ;
            stringArray[1] = key2.get(0) + ": " + String.valueOf(maxValueInMap2);
            ;
            stringArray[2] = key3.get(0) + ": " + String.valueOf(maxValueInMap3);
            ;

            JSONstring parser = new JSONstring();
            String result = parser.toJSON(stringArray);
            out.println(result); // send results to client

            //SPRINT6 - create cache file
            ///*
            File myObj = new File(pathToCache);
            if (myObj.createNewFile()) { // File created
                FileWriter myWriter = new FileWriter(pathToCache);
                myWriter.write("Interval,Street,Count\n");
                //for (Map.Entry<String, Integer> entry : interval.entrySet()) {
                //    myWriter.write("1" + entry.getKey() + ", " + entry.getValue() + "\n");
                //}
                for (Map.Entry<String, Integer> entry : interval1.entrySet()) {
                    myWriter.write("1," + entry.getKey() + ", " + entry.getValue() + "\n");
                }
                for (Map.Entry<String, Integer> entry : interval2.entrySet()) {
                    myWriter.write("2," + entry.getKey() + ", " + entry.getValue() + "\n");
                }
                for (Map.Entry<String, Integer> entry : interval3.entrySet()) {
                    myWriter.write("3," + entry.getKey() + ", " + entry.getValue() + "\n");
                }
                myWriter.close();
            }
        }
        //*/
    }
}
