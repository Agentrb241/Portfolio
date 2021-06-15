import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Update")
public class Update extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // reader for user input
        InputStream reader = request.getInputStream();

        // files
        String[] fileNames = {"Uber-Jan-Feb-FOIL", "other-Dial7_B00887", "other-Firstclass_B01536",
                              "uber-raw-data-apr14","other-Federal_02216", "other-Highclass_B01717"};
        String PathToTemp = "webapps/BadAPPles/temp/";
        String Top3HoursCache = "webapps/BadAPPles/cache/Top3Hours.csv";
        String Top3StreetsCache = "webapps/BadAPPles/cache/Top3Streets.csv";
        String TopStreetsTimeCache = "webapps/BadAPPles/cache/TopStreetsTime.csv";
        String TopVehicleAMCache = "webapps/BadAPPles/cache/TopVehicleAM.csv";
        String TopVehiclePMCache = "webapps/BadAPPles/cache/TopVehiclePM.csv";

         // parameters from client
        String fileParam = request.getParameter("param1");
        String rowParam = request.getParameter("param2");
        String columnParam = request.getParameter("param3");
        String valueParam = request.getParameter("param4");

        // convert necessary parameters to ints
        int fileNum = Integer.parseInt(fileParam);
        int row = Integer.parseInt(fileParam);
        int column = Integer.parseInt(fileParam);
        String newValue = valueParam;

        String file = fileNames[fileNum] + ".csv";

        // create file and load into dataList
        File newFile = new File(PathToTemp + file);
        InputStream inputStream = new FileInputStream(newFile);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> csvList = csvFile.read();
        DataList data = new DataList(csvList);

        // update 
        data.update(row, column, newValue);

        // delete old file
        CleanDir clean = new CleanDir();
        clean.removeFile(new File(PathToTemp + file));

        // write the dataList to the backup
        csvFile.write(data.getData(), PathToTemp + file);


        // get old value for caching purposes
        String oldValue = data.getData().get(row)[column];

        // update cache if it exists
        if (fileNum == 1) { // Dial
            File Top3Hours = new File(Top3HoursCache);
            File Top3Streets = new File(Top3StreetsCache);
            File TopStreetsTime = new File(TopStreetsTimeCache);

            if (Top3Hours.exists() && column == 1) { // if file exists and time column was updated
            
                String oldTime = "9";//data.getData().get(row)[column].split(":")[0];
                String[] values = {oldTime};
                int[] columns = {0};
                decrementCache(Top3Hours,Top3HoursCache, values, columns);
                values[0] = "14";//newValue;
                incrementCache(Top3Hours,Top3HoursCache, values, columns);

            }
            if (Top3Streets.exists() && column == 5) { // if file exists and street column was updated
                String oldStreet = data.getData().get(row)[column];
                String[] values = {oldStreet};
                int[] columns = {0};
                decrementCache(Top3Streets,Top3StreetsCache, values, columns);
                values[0] = newValue;
                incrementCache(Top3Streets,Top3StreetsCache, values, columns);
            }
            if (TopStreetsTime.exists() && (column == 1 || column == 5)){ // if file exists and either street or time columns were updated
                if (column == 1) { //time updated
                    String streetName = data.getData().get(row)[5];
                    int oldTime = Integer.parseInt(data.getData().get(row)[column].split(":")[0]);
                    int interval = 0;
                    if (oldTime < 8) {
                        interval = 1;
                    }
                    else if (oldTime < 16) {
                        interval = 2;
                    }
                    else if (oldTime < 24) {
                        interval = 3;
                    }
                    String[] values = {String.valueOf(interval), streetName};
                    int[] columns = {0,1};
                    decrementCache(Top3Streets,Top3StreetsCache, values, columns);

                    int newTime = Integer.parseInt(newValue);
                    if (newTime < 8) {
                        interval = 1;
                    }
                    else if (newTime < 16) {
                        interval = 2;
                    }
                    else if (newTime < 24) {
                        interval = 3;
                    }
                    values[0] = String.valueOf(interval);
                    incrementCache(Top3Streets,Top3StreetsCache, values, columns);

                }
                else { // streetName updated
                    int time = Integer.parseInt(data.getData().get(row)[1]);
                    String oldStreet = data.getData().get(row)[column];

                    int interval = 0;
                    if (time < 8) {
                        interval = 1;
                    }
                    else if (time < 16) {
                        interval = 2;
                    }
                    else if (time < 24) {
                        interval = 3;
                    }
                    String[] values = {String.valueOf(interval), oldStreet};
                    int[] columns = {0,1};
                    decrementCache(Top3Streets,Top3StreetsCache, values, columns);

                    String newStreet = newValue;
                    values[1] = newStreet;
                    incrementCache(Top3Streets,Top3StreetsCache, values, columns);
                }
            }
        }
        else if (fileNum == 2 || fileNum == 5) { // FirstClass or HighClass
            File TopVehiclesAM = new File(TopVehiclesAMCache);
            File TopVehiclesPM = new File(TopVehiclesPMCache);

            if (TopVehiclesAM.exists() && (oldValue.contains("AM") || newValue.contains("AM")) && column == 1) { // if file exists and time column was updated

                String vehicleClass;
                if (fileNum == 2) {
                    vehicleClass = "FirstClass";
                }
                else {
                    vehicleClass = "HighClass";
                }

                if (oldValue.contains("AM")){
                    // decrement old value
                    String[] values = {oldValue, vehicleClass}  ;
                    int[] columns = {0, 1};
                    decrementCache(TopVehiclesAM, TopVehiclesAMCache, values, columns);
                }
                if (newValue.contains("AM") || column == 2){
                    // increment old value
                    String[] values = {newValue, vehicleClass};
                    int[] columns = {0, 1};
                    decrementCache(TopVehiclesAM, TopVehiclesAMCache, values, columns);
                }

            }
            if (TopVehiclesPM.exists() && (oldValue.contains("PM") || newValue.contains("PM")) && column == 1) { // if file exists and time column was updated

                String vehicleClass;
                if (fileNum == 2) {
                    vehicleClass = "FirstClass";
                }
                else {
                    vehicleClass = "HighClass";
                }

                if (oldValue.contains("PM")){
                    // decrement old value
                    String[] values = {oldValue, vehicleClass};
                    int[] columns = {0, 1};
                    decrementCache(TopVehiclesAM, TopVehiclesPMCache, values, columns);
                }
                if (newValue.contains("PM") || column == 2){
                    // increment old value
                    String[] values = {newValue, vehicleClass};
                    int[] columns = {0, 1};
                    decrementCache(TopVehiclesAM, TopVehiclesPMCache, values, columns);
                }

            }
        }
        else if (fileNum == 4) { // Federal

        }
        else if (fileNum == 3) { // apr

        }


    }

    void incrementCache(File file, String fileName, String[] values, int[] columns) {
        try {
        // create file and load into dataList
            InputStream inputStream = new FileInputStream(file);
            CSVFile csvFile = new CSVFile(inputStream);
            List<String[]> csvList = csvFile.read();
            DataList data = new DataList(csvList);

            boolean isNewValue = true;
            for (int i = 0; i < data.getData().size(); i++) {
                
                boolean isRow = true;
                for (int j = 0; j < values.length; j++) {

                    if (!data.getData().get(i)[columns[j]].equals(values[j])){
                        isRow = false;
                    }
                }
                if (isRow) {
                    int count = Integer.parseInt(data.getData().get(i)[data.getData().get(i).length-1]);
                    count++;
                    data.update(i, 1, String.valueOf(count));
                    isNewValue = false;
                    break;
                }

            }
            if (isNewValue){ // if new value isn't an existing value then add it to the cache

                String[] newRow = new String[values.length+1];
                for (int i = 0; i < values.length; i++) {
                    newRow[i] = values[i];
                }
                newRow[values.length] = "1";
                data.getData().add(newRow);
            }

            // write the dataList to the backup
            csvFile.write(data.getData(), fileName);
            
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        } 
    
    }

    void decrementCache(File file, String fileName, String[] values, int[] columns) {
        try {
        // create file and load into dataList
            InputStream inputStream = new FileInputStream(file);
            CSVFile csvFile = new CSVFile(inputStream);
            List<String[]> csvList = csvFile.read();
            DataList data = new DataList(csvList);

            for (int i = 0; i < data.getData().size(); i++) {
                
                boolean isRow = true;
                for (int j = 0; j < values.length; j++) {

                    if (!data.getData().get(i)[columns[j]].equals(values[j])){
                        isRow = false;
                    }

                }
                if (isRow) {
                    int count = Integer.parseInt(data.getData().get(i)[data.getData().get(i).length-1]);
                    count--;
                    data.update(i, count, String.valueOf(count));
                    break;
                }

            }

            // write the dataList to the backup
            csvFile.write(data.getData(), fileName);
            
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        } 
    
    }

    

}

//  javac -Xlint CSVFile.java DataList.java -cp ../../../../lib/servlet-api.jar Update.java


// Dial - Top3Hours, Top3Streets, TopStreetsTime

// FirstClass - TopVehicles
// HighClass - TopVehicles

// Federal - NumPeopleArrived

// apr - Lat-Long
