import java.io.*;
import java.util.List;
import java.util.ArrayList;

import java.nio.file.Files;
import java.nio.file.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/CreateTempServlet")
public class CreateTempServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        // reader for user input
        InputStream reader = request.getInputStream();

        // files
        String[] fileNames = {"Uber-Jan-Feb-FOIL", "other-Dial7_B00887",
                              "other-Firstclass_B01536", "uber-raw-data-apr14"};

         // parameters from client
        String fileParam = request.getParameter("param1");
        String backUpFile = request.getParameter("param2");

        // convert necessary parameters to ints
        int fileNum = (int) Double.parseDouble(fileParam);

        File dir = new File("webapps/BadAPPles/temp");
        CleanDir clean = new CleanDir();
        clean.cleanDirectory(dir);

        final String file = fileNames[fileNum] + ".csv";
        
        //store backUp file into temp folder
        switch (fileNum){
            case 0:
                Path path = Files.copy(Paths.get("webapps/BadAPPles/backUp-0/" + backUpFile),
                        Paths.get("webapps/BadAPPles/temp/" + file));
                break;
            case 1:
                path = Files.copy(Paths.get("webapps/BadAPPles/backUp-1/" + backUpFile),
                        Paths.get("webapps/BadAPPles/temp/" + file));
                break;
            case 2:
                path = Files.copy(Paths.get("webapps/BadAPPles/backUp-2/" + backUpFile),
                        Paths.get("webapps/BadAPPles/temp/" + file));
                break;
            case 3:
                path = Files.copy(Paths.get("webapps/BadAPPles/backUp-3/" + backUpFile),
                        Paths.get("webapps/BadAPPles/temp/" + file));
                break;
        }

    }
}

//  javac -Xlint DataList.java CSVFile.java CleanDir.java -cp ../../../../lib/servlet-api.jar *.java
