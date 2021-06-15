import java.io.*;
import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Delete")
public class Delete extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        InputStream reader = request.getInputStream();

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

        // convert necessary parameters to ints
        int fileNum = Integer.parseInt(fileParam);
        int rows = Integer.parseInt(fileParam);

        String newFile = fileNames[fileNum] + ".csv";

        // create file and load into dataList
        File file = new File(PathToTemp + newFile);
        InputStream inputStream = new FileInputStream(file);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> csvList = csvFile.read();
        DataList data = new DataList(csvList); 

        data.delete(rows);

        // delete old file
        CleanDir clean = new CleanDir();
        clean.removeFile(new File(PathToTemp + newile));

        // write the dataList to the backup
        csvFile.write(data.getData(), PathToTemp + newFile);
        String oldValue = data.getData().get(rows[]);
        if (fileNum == 1) { // Dial
            File Top3Hours = new File(Top3HoursCache);
            File Top3Streets = new File(Top3StreetsCache);
            File TopStreetsTime = new File(TopStreetsTimeCache);

            if (Top3Hours.exists()) { // if file exists and time column was updated
            
                String[] values = {rows[1].split(:)[0]};
                int[] columns = {0};
                decrementCache(Top3Hours,Top3HoursCache, values, columns);

            }
            if (Top3Streets.exists() ) { // if file exists and street column was updated
                String[] values = {rows[4]};
                int[] columns = {0};
                decrementCache(Top3Streets,Top3StreetsCache, values, columns);
            }
            if (TopStreetsTime.exists()){ // if file exists and either street or time columns were updated
                    String streetName = data.getData().get(row[5]);
                    int interval = 0;
                    int oldTime = Integer.parseInt(data.getData().get(rows[1].split(":")[0]);
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
            }
        }
        else if (fileNum == 2 || fileNum == 5) { // FirstClass or HighClass
            File TopVehiclesAM = new File(TopVehicleAMCache);
            File TopVehiclesPM = new File(TopVehiclePMCache);

            if (TopVehiclesAM.exists() && (oldValue.contains("AM")) ) { // if file exists and time column was updated

                String vehicleClass;
                if (fileNum == 2) {
                    vehicleClass = "FirstClass";
                }
                else {
                    vehicleClass = "HighClass";
                }

                
                if (newValue.contains("AM") ){
                    // increment old value
                    String[] values = {oldValue, vehicleClass};
                    int[] columns = {0, 1};
                    decrementCache(TopVehiclesAM, TopVehicleAMCache, values, columns);
                }

            }
            if (TopVehiclesPM.exists() && (oldValue.contains("PM"))) { // if file exists and time column was updated

                String vehicleClass;
                if (fileNum == 2) {
                    vehicleClass = "FirstClass";
                }
                else {
                    vehicleClass = "HighClass";
                }

                
                if (newValue.contains("PM") ){
                    // increment old value
                    String[] values = {oldValue, vehicleClass};
                    int[] columns = {0, 1};
                    decrementCache(TopVehiclesAM, TopVehiclePMCache, values, columns);
                }

            }
        }
        else if (fileNum == 4) { // Federal

        }
        else if (fileNum == 3) { // apr

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

//  javac -Xlint CSVFile.java DataList.java -cp ../../../../lib/servlet-api.jar Delete.java
