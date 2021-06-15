import java.io.*;
import java.util.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Top3Street extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Top3Street() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String PathToDial7 = "/Library/apache-tomcat-10.0.5/webapps/BadAPPles/Data/other-Dial7_B00887.csv";
        String Dial7Cache = "/Library/apache-tomcat-10.0.5/webapps/BadAPPles/Cache/other-Dial7_B00887.csv";
        
        Map.Entry<String, Integer> maxEntry = null;
        Map<String, Integer> interval1 = new HashMap<String, Integer>();
        File file = new File(Dial7Cache); //cahnge path
        List<String[]> cachedResults = new ArrayList();
        //FileWriter myWriter = new FileWriter(file); //
        String line = "";
        if (file.exists()){

            BufferedReader br = new BufferedReader(new FileReader(file));
            //String line = null;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] col = line.split(",");
                int i=Integer.parseInt(col[1]);
                interval1.put(col[0], i);

            }

            List<String> key1 = interval1.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
            int maxValueIntMap1 = (Collections.max(interval1.values()));
            interval1.replace(key1.get(0), 1);
            int maxValueIntMap2 = (Collections.max(interval1.values()));
            interval1.replace(key1.get(1), 1);
            int maxValueIntMap3 = (Collections.max(interval1.values()));
            interval1.replace(key1.get(2), 1);



            String[] stringArray = new String[3];


            stringArray[0] = key1.get(0) + ": " + String.valueOf(maxValueIntMap1);
            stringArray[1] = key1.get(1) + ": " + String.valueOf(maxValueIntMap2);
            stringArray[2] = key1.get(2) + ": " + String.valueOf(maxValueIntMap3);

            JSONstring parser = new JSONstring();
            String result = parser.toJSON(stringArray);
            out.println(result);



               /* String[] stringArray1 = new String[1];
                for(int i = 0; i < m.size();i++){
                    stringArray1[0] = stringArray1[0] + m.get(i);
                }



            //JSONstring parser = new JSONstring();
            //String result = parser.toJSON(stringArray1);
            */



        }else {
            File file1 = new File(PathToDial7);
            InputStream inputStream = new FileInputStream(file1);
            CSVFile csvFile = new CSVFile(inputStream);
            List<String[]> csvList = csvFile.read();
            DataList data = new DataList(csvList);


            file.createNewFile();
            // create file
            BufferedReader br = new BufferedReader(new FileReader(file1));
            //String line = null;

            while ((line = br.readLine()) != null) {
                String[] col = line.split(",");
                String street = col[5].trim();
                String time = col[1].trim();
                String hour = time.split(":")[0];

                NumberFormat nf = NumberFormat.getInstance();

                try {
                    int x = (int) nf.parse(hour).doubleValue();

                    if (street.trim().isEmpty()) {

                    } else if (interval1.containsKey(street)) {
                        // just increment count
                        interval1.replace(street, interval1.get(street) + 1);
                    } else {
                        // add it and increment count
                        interval1.put(street, 1);

                    }


                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            br.close();

            //String[] columns = {"Street", "Count"};
            //cachedResults.add(columns);
            for (Map.Entry<String, Integer> pair : interval1.entrySet()) {
                String temp = pair.getKey();
                String[] values = {temp, String.valueOf(pair.getValue())};
                cachedResults.add(values);
            }
            DataList dataCache = new DataList(cachedResults);
            csvFile.write(dataCache.getData(), Dial7Cache);

            List<String> key1 = interval1.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
            int maxValueIntMap1 = (Collections.max(interval1.values()));
            interval1.replace(key1.get(0), 1);
            int maxValueIntMap2 = (Collections.max(interval1.values()));
            interval1.replace(key1.get(1), 1);
            int maxValueIntMap3 = (Collections.max(interval1.values()));
            interval1.replace(key1.get(2), 1);

            String[] stringArray = new String[3];


            stringArray[0] = key1.get(0) + ": " + String.valueOf(maxValueIntMap1);
            stringArray[1] = key1.get(1) + ": " + String.valueOf(maxValueIntMap2);
            stringArray[2] = key1.get(2) + ": " + String.valueOf(maxValueIntMap3);







            JSONstring parser = new JSONstring();
            String result = parser.toJSON(stringArray);
            out.println(result);




        }
    }
}
