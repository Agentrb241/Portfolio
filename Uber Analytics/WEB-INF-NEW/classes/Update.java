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

         // parameters from client
        String fileParam = request.getParameter("param1");
        String rowParam = request.getParameter("param2");
        String columnParam = request.getParameter("param3");
        String valueParam = request.getParameter("param4");

        // convert necessary parameters to ints
        int fileNum = Integer.parseInt(fileParam);
        int row = Integer.parseInt(rowParam);
        int column = Integer.parseInt(columnParam);
        String newVal = valueParam;

        String file = fileNames[fileNum] + ".csv";

        // create file and load into dataList
        File newFile = new File("webapps/BadAPPles/temp/" + file);
        InputStream inputStream = new FileInputStream(newFile);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> csvList = csvFile.read();
        DataList data = new DataList(csvList);

        // get old value for caching purposes. Need to obtain before data is updated
        String oldVal = data.getData().get(row)[column];


        // update 
        data.update(row, column, newVal);

        // delete old file
        CleanDir clean = new CleanDir();
        clean.removeFile(new File("webapps/BadAPPles/temp/" + file));

        // write the dataList to the backup
        csvFile.write(data.getData(), "webapps/BadAPPles/temp/" + file);

        // update cache if it exists
        if (fileNum == 1) { // Dial
            File Top3Hours = new File("webapps/BadAPPles/cache/Top3Hours.csv");
            File Top3Streets = new File("webapps/BadAPPles/cache/Top3Streets.csv");
            File TopStreetsTime = new File("webapps/BadAPPles/cache/TopStreetsTime.csv");

            if (Top3Hours.exists() && column == 1) { // if file exists and time column was updated
    
                String oldTime = oldVal.split(":")[0];
                String[] oldValues = {oldTime};
                String[] newValues = {newVal};
                int[] columns = {0};
                updateCache(Top3Hours, "webapps/BadAPPles/cache/Top3Hours.csv", oldValues, newValues, columns);
            }
            if (Top3Streets.exists() && column == 5) { // if file exists and street column was updated  (index 5)

                String oldStreet = oldVal;
                String[] oldValues = {oldStreet};
                String[] newValues = {newVal};
                int[] columns = {0};
                updateCache(Top3Streets, "webapps/BadAPPles/cache/Top3Streets.csv", oldValues, newValues, columns);
            }
            if (TopStreetsTime.exists() && (column == 1 || column == 5)){ // if file exists and either street or time columns were updated

                if (column == 1) { //time updated
                    String streetName = data.getData().get(row)[5];
                    int oldTime = Integer.parseInt(oldVal.split(":")[0]);
                    int oldInterval = 0;
                    if (oldTime < 8) {
                        oldInterval = 1;
                    }
                    else if (oldTime < 16) {
                        oldInterval = 2;
                    }
                    else if (oldTime < 24) {
                        oldInterval = 3;
                    }
                    String[] oldValues = {String.valueOf(oldInterval), streetName};
                    int[] columns = {0,1};

                    int newTime = Integer.parseInt(newVal.split(":")[0]);
                    int newInterval = 0;
                    if (newTime < 8) {
                        newInterval = 1;
                    }
                    else if (newTime < 16) {
                        newInterval = 2;
                    }
                    else if (newTime < 24) {
                        newInterval = 3;
                    }
                    String[] newValues = {String.valueOf(newInterval), streetName};
                    updateCache(TopStreetsTime, "webapps/BadAPPles/cache/TopStreetsTime.csv", oldValues, newValues, columns);

                }
                else { // streetName updated
                    int time = Integer.parseInt(data.getData().get(row)[1].split(":")[0]);
                    String oldStreet = oldVal;

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

                    String[] oldValues = {String.valueOf(interval), oldStreet};
                    int[] columns = {0,1};

                    String newStreet = newVal;
                    String[] newValues = {String.valueOf(interval), newStreet};
                    updateCache(TopStreetsTime, "webapps/BadAPPles/cache/TopStreetsTime.csv", oldValues, newValues, columns);
                }
            }
        }
        else if (fileNum == 2 || fileNum == 5) { // FirstClass or HighClass
            File TopVehicleAM = new File("webapps/BadAPPles/cache/TopVehicleAM.csv");
            File TopVehiclePM = new File("webapps/BadAPPles/cache/TopVehiclePM.csv");

            String oldTime = oldVal.split(":")[0];

            if (TopVehicleAM.exists() && (oldVal.contains("AM") || newVal.contains("AM")) && column == 1) { // if file exists and time column was updated

                String vehicleClass;
                if (fileNum == 2) {
                    vehicleClass = "FirstClass";
                }
                else {
                    vehicleClass = "HighClass";
                }

                if (oldVal.contains("AM")){
                    // decrement old value
                    String[] values = {oldTime, vehicleClass}  ;
                    int[] columns = {0, 1};
                    decrementCache(TopVehicleAM, "webapps/BadAPPles/cache/TopVehicleAM.csv", values, columns);
                }
                if (newVal.contains("AM") || column == 2){
                    // increment old value
                    String newTime = newVal.split(":")[0];
                    String[] values = {newTime, vehicleClass};
                    int[] columns = {0, 1};
                    incrementCache(TopVehicleAM, "webapps/BadAPPles/cache/TopVehicleAM.csv", values, columns);
                }

            }
            if (TopVehiclePM.exists() && (oldVal.contains("PM") || newVal.contains("PM")) && column == 1) { // if file exists and time column was updated

                String vehicleClass;
                if (fileNum == 2) {
                    vehicleClass = "FirstClass";
                }
                else {
                    vehicleClass = "HighClass";
                }

                if (oldVal.contains("PM")){
                    // decrement old value
                    String[] values = {oldVal, vehicleClass};
                    int[] columns = {0, 1};
                    decrementCache(TopVehiclePM, "webapps/BadAPPles/cache/TopVehiclePM.csv", values, columns);
                }
                if (newVal.contains("PM") || column == 2){
                    // increment old value
                    String[] values = {newVal, vehicleClass};
                    int[] columns = {0, 1};
                    incrementCache(TopVehiclePM, "webapps/BadAPPles/cache/TopVehiclePM.csv", values, columns);
                }

            }
        }
        else if (fileNum == 4) { // Federal (index 6)

            File NumPeopleArrived = new File("webapps/BadAPPles/cache/NumPeopleArrived.csv");
            if (NumPeopleArrived.exists() && column == 6) {
                String[] oldValues = {oldVal.trim()};
                String[] newValues = {newVal};
                int[] columns = {0};
                updateCache(NumPeopleArrived, "webapps/BadAPPles/cache/NumPeopleArrived.csv", oldValues, newValues, columns);
             }

        }
        else if (fileNum == 3) { // apr

            File LatLong = new File("webapps/BadAPPles/cache/LatLong.csv");
            if (LatLong.exists() && column == 6) {
                String[] oldValues = {oldVal.trim()};
                String[] newValues = {newVal};
                int[] columns = {0};
                updateCache(LatLong, "webapps/BadAPPles/cache/LatLong.csv", oldValues, newValues, columns);
            }
        }


    }




    void updateCache(File file, String fileName, String[] oldValues, String[] newValues, int[] columns) {
        try {
        // create file and load into dataList
            InputStream inputStream = new FileInputStream(file);
            CSVFile csvFile = new CSVFile(inputStream);
            List<String[]> csvList = csvFile.read();
            DataList data = new DataList(csvList);

            boolean isNewValue = true;
            for (int i = 0; i < data.getData().size(); i++) {
                
                boolean isOldRow = true;
                boolean isNewRow = true;
                for (int j = 0; j < newValues.length; j++) {

                    if (!data.getData().get(i)[columns[j]].equals(oldValues[j])){
                        isOldRow = false;
                    }
                    if (!data.getData().get(i)[columns[j]].equals(newValues[j])){
                        isNewRow = false;
                    }

                }
                if (isOldRow) {
                    int countIndex = data.getData().get(0).length-1;
                    int count = Integer.parseInt(data.getData().get(i)[countIndex]);
                    count--;
                    data.update(i, countIndex, String.valueOf(count));
                }
                if (isNewRow) {
                    int countIndex = data.getData().get(0).length-1;
                    int count = Integer.parseInt(data.getData().get(i)[countIndex]);
                    count++;
                    data.update(i, countIndex, String.valueOf(count));
                    isNewValue = false;
                }

            }
            if (isNewValue){ // if new value isn't an existing value then add it to the cache

                String[] newRow = new String[newValues.length+1];
                for (int i = 0; i < newValues.length; i++) {
                    newRow[i] = newValues[i];
                }
                newRow[newValues.length] = "1";
                data.getData().add(newRow);
            }

            // write the dataList to the backup
            csvFile.write(data.getData(), fileName);
            
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
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
                    int countIndex = data.getData().get(0).length-1;
                    int count = Integer.parseInt(data.getData().get(i)[countIndex]);
                    count++;
                    data.update(i, countIndex, String.valueOf(count));
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
                    int countIndex = data.getData().get(0).length - 1;
                    int count = Integer.parseInt(data.getData().get(i)[countIndex]);
                    count--;
                    data.update(i, countIndex, String.valueOf(count));
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
