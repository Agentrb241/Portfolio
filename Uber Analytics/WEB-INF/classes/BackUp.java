import java.io.*;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/BackUp")
public class BackUp extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
        String timeStamp = now.format(myFormat);

        // reader for user input
        InputStream reader = request.getInputStream();

        // files
        String[] fileNames = {"Uber-Jan-Feb-FOIL", "other-Dial7_B00887",
                              "other-Firstclass_B01536", "uber-raw-data-apr14"};

         // parameters from client
        String fileParam = request.getParameter("param1");

        // convert necessary parameters to ints
        int fileNum = Integer.parseInt(fileParam);

        final String newFile = fileNames[fileNum];

        //store temp file into backup folder
        switch (fileNum){
            case 0:
                Path path = Files.copy(Paths.get("webapps/BadApples/temp/" + newFile + ".csv"),
                        Paths.get("webapps/BadAPPles/backUp-0/" + newFile + timeStamp + ".csv"));
                break;
            case 1:
                path = Files.copy(Paths.get("webapps/BadApples/temp/" + newFile + ".csv"),
                        Paths.get("webapps/BadAPPles/backUp-1/" + newFile + timeStamp + ".csv"));
                break;
            case 2:
                path = Files.copy(Paths.get("webapps/BadApples/temp/" + newFile + ".csv"),
                        Paths.get("webapps/BadAPPles/backUp-2/" + newFile + timeStamp + ".csv"));
                break;
            case 3:
                path = Files.copy(Paths.get("webapps/BadApples/temp/" + newFile + ".csv"),
                        Paths.get("webapps/BadAPPles/backUp-3/" + newFile + timeStamp + ".csv"));
                break;
        }

    }
}

//  javac -Xlint DataList.java CSVFile.java CleanDir.java -cp ../../../../lib/servlet-api.jar *.java