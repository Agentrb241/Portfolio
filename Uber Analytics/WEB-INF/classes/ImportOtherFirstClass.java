import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ImportOtherFirstClass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ImportOtherFirstClass() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        //Creating a File object for directory
        File directoryPath = new File("webapps/BadAPPles/backUp-2"); // change to file location 
        //List of all files and directories
        String contents[] = directoryPath.list();
        String importf = String.join(",", contents);

        out.println(importf);

    }

}

//  javac -Xlint -cp ../../../../lib/servlet-api.jar ImportOtherFirstClass.java