/*
 * Template JAVA User Interface
 * =============================
 *
 * Database Management Systems
 * Department of Computer Science &amp; Engineering
 * University of California - Riverside
 *
 * Target DBMS: 'Postgres'
 *
 */



import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

/**
 * This class defines a simple embedded SQL utility class that is designed to
 * work with PostgreSQL JDBC drivers.
 *
 */

public class DBproject{
	//reference to physical database connection
	private Connection _connection = null;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public DBproject(String dbname, String dbport, String user, String passwd) throws SQLException {
		System.out.print("Connecting to database...");
		try{
			// constructs the connection URL
			String url = "jdbc:postgresql://localhost:" + dbport + "/" + dbname;
			System.out.println ("Connection URL: " + url + "\n");
			
			// obtain a physical connection
	        this._connection = DriverManager.getConnection(url, user, passwd);
	        System.out.println("Done");
		}catch(Exception e){
			System.err.println("Error - Unable to Connect to Database: " + e.getMessage());
	        System.out.println("Make sure you started postgres on this machine");
	        System.exit(-1);
		}
	}
	
	/**
	 * Method to execute an update SQL statement.  Update SQL instructions
	 * includes CREATE, INSERT, UPDATE, DELETE, and DROP.
	 * 
	 * @param sql the input SQL string
	 * @throws java.sql.SQLException when update failed
	 * */
	public void executeUpdate (String sql) throws SQLException { 
		// creates a statement object
		Statement stmt = this._connection.createStatement ();

		// issues the update instruction
		stmt.executeUpdate (sql);

		// close the instruction
	    stmt.close ();
	}//end executeUpdate

	/**
	 * Method to execute an input query SQL instruction (i.e. SELECT).  This
	 * method issues the query to the DBMS and outputs the results to
	 * standard out.
	 * 
	 * @param query the input query string
	 * @return the number of rows returned
	 * @throws java.sql.SQLException when failed to execute the query
	 */
	public int executeQueryAndPrintResult (String query) throws SQLException {
		//creates a statement object
		Statement stmt = this._connection.createStatement ();

		//issues the query instruction
		ResultSet rs = stmt.executeQuery (query);

		/*
		 *  obtains the metadata object for the returned result set.  The metadata
		 *  contains row and column info.
		 */
		ResultSetMetaData rsmd = rs.getMetaData ();
		int numCol = rsmd.getColumnCount ();
		int rowCount = 0;
		
		//iterates through the result set and output them to standard out.
		boolean outputHeader = true;
		while (rs.next()){
			if(outputHeader){
				for(int i = 1; i <= numCol; i++){
					System.out.print(rsmd.getColumnName(i) + "\t");
			    }
			    System.out.println();
			    outputHeader = false;
			}
			for (int i=1; i<=numCol; ++i)
				System.out.print (rs.getString (i) + "\t");
			System.out.println ();
			++rowCount;
		}//end while
		stmt.close ();
		return rowCount;
	}
	
	/**
	 * Method to execute an input query SQL instruction (i.e. SELECT).  This
	 * method issues the query to the DBMS and returns the results as
	 * a list of records. Each record in turn is a list of attribute values
	 * 
	 * @param query the input query string
	 * @return the query result as a list of records
	 * @throws java.sql.SQLException when failed to execute the query
	 */
	public List<List<String>> executeQueryAndReturnResult (String query) throws SQLException { 
		//creates a statement object 
		Statement stmt = this._connection.createStatement (); 
		
		//issues the query instruction 
		ResultSet rs = stmt.executeQuery (query); 
	 
		/*
		 * obtains the metadata object for the returned result set.  The metadata 
		 * contains row and column info. 
		*/ 
		ResultSetMetaData rsmd = rs.getMetaData (); 
		int numCol = rsmd.getColumnCount (); 
		int rowCount = 0; 
	 
		//iterates through the result set and saves the data returned by the query. 
		boolean outputHeader = false;
		List<List<String>> result  = new ArrayList<List<String>>(); 
		while (rs.next()){
			List<String> record = new ArrayList<String>(); 
			for (int i=1; i<=numCol; ++i) 
				record.add(rs.getString (i)); 
			result.add(record); 
		}//end while 
		stmt.close (); 
		return result; 
	}//end executeQueryAndReturnResult
	
	/**
	 * Method to execute an input query SQL instruction (i.e. SELECT).  This
	 * method issues the query to the DBMS and returns the number of results
	 * 
	 * @param query the input query string
	 * @return the number of rows returned
	 * @throws java.sql.SQLException when failed to execute the query
	 */
	public int executeQuery (String query) throws SQLException {
		//creates a statement object
		Statement stmt = this._connection.createStatement ();

		//issues the query instruction
		ResultSet rs = stmt.executeQuery (query);

		int rowCount = 0;

		//iterates through the result set and count nuber of results.
		while(rs.next()){
			rowCount++;
		}//end while
		stmt.close ();
		return rowCount;
	}
	
	/**
	 * Method to fetch the last value from sequence. This
	 * method issues the query to the DBMS and returns the current 
	 * value of sequence used for autogenerated keys
	 * 
	 * @param sequence name of the DB sequence
	 * @return current value of a sequence
	 * @throws java.sql.SQLException when failed to execute the query
	 */
	
	public int getCurrSeqVal(String sequence) throws SQLException {
		Statement stmt = this._connection.createStatement ();
		
		ResultSet rs = stmt.executeQuery (String.format("Select currval('%s')", sequence));
		if (rs.next()) return rs.getInt(1);
		return -1;
	}

	/**
	 * Method to close the physical connection if it is open.
	 */
	public void cleanup(){
		try{
			if (this._connection != null){
				this._connection.close ();
			}//end if
		}catch (SQLException e){
	         // ignored.
		}//end try
	}//end cleanup
	
	 public static boolean onlyAlphabets(String str){
                 if (str == null || str == "") {
                        return false;
                }

                for (int i = 0; i < str.length(); i++) {
                        if (!Character.isLetter(str.charAt(i))) {
                                return false;
                        }
                }
                return true;
        }


	/**
	 * The main execution method
	 * 
	 * @param args the command line arguments this inclues the <mysql|pgsql> <login file>
	 */
	public static void main (String[] args) {
		if (args.length != 3) {
			System.err.println (
				"Usage: " + "java [-classpath <classpath>] " + DBproject.class.getName () +
		            " <dbname> <port> <user>");
			return;
		}//end if
		
		DBproject esql = null;
		
		try{
			System.out.println("(1)");
			
			try {
				Class.forName("org.postgresql.Driver");
			}catch(Exception e){

				System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
				e.printStackTrace();
				return;
			}
			
			System.out.println("(2)");
			String dbname = args[0];
			String dbport = args[1];
			String user = args[2];
			
			esql = new DBproject (dbname, dbport, user, "");
			
			boolean keepon = true;
			while(keepon){
				System.out.println("MAIN MENU");
				System.out.println("---------");
				System.out.println("1. Add Doctor");
				System.out.println("2. Add Patient");
				System.out.println("3. Add Appointment");
				System.out.println("4. Make an Appointment");
				System.out.println("5. List appointments of a given doctor");
				System.out.println("6. List all available appointments of a given department");
				System.out.println("7. List total number of different types of appointments per doctor in descending order");
				System.out.println("8. Find total number of patients per doctor with a given status");
				System.out.println("9. < EXIT");
				
				switch (readChoice()){
					case 1: AddDoctor(esql); break;
					case 2: AddPatient(esql); break;
					case 3: AddAppointment(esql); break;
					case 4: MakeAppointment(esql); break;
					case 5: ListAppointmentsOfDoctor(esql); break;
					case 6: ListAvailableAppointmentsOfDepartment(esql); break;
					case 7: ListStatusNumberOfAppointmentsPerDoctor(esql); break;
					case 8: FindPatientsCountWithStatus(esql); break;
					case 9: keepon = false; break;
				}
			}
		}catch(Exception e){
			System.err.println (e.getMessage ());
		}finally{
			try{
				if(esql != null) {
					System.out.print("Disconnecting from database...");
					esql.cleanup ();
					System.out.println("Done\n\nBye !");
				}//end if				
			}catch(Exception e){
				// ignored.
			}
		}
	}

	public static int readChoice() {
		int input;
		// returns only if a correct value is given.
		do {
			System.out.print("Please make your choice: ");
			try { // read the integer, parse it and break.
				input = Integer.parseInt(in.readLine());
				break;
			}catch (Exception e) {
				System.out.println("Your input is invalid!");
				continue;
			}//end try
		}while (true);
		return input;
	}//end readChoice

	public static void AddDoctor(DBproject esql) {//1
                 try{
          String query = "INSERT INTO Doctor VALUES( ";
                 System.out.print("\tEnter doctor_ID: ");
                 String input = in.readLine();
		 
		 while( onlyAlphabets(input) ){
                 System.out.print("\tEnter Appointment ID: ");
                 input = in.readLine();
                 }
                 query += input;
                 query += ',';
			 
                 System.out.print("\tEnter name: ");
                 String input1 = "'" +  in.readLine() + "'" ;
                 query += input1;
                 query += ',';
			 
                 System.out.print("\tEnter speciality: ");
                 String input2 = "'" +  in.readLine() + "'";
                 query += input2;
                 query += ',';
			 
                 System.out.print("\tEnter department id: ");
                 String input3 =  in.readLine();
		 while(onlyAlphabets(input3) ){  
                 System.out.print("\tEnter department id: ");
                 input3 = in.readLine();
                 }
                 query += input3;
                 query += ");";

         int rowCount = esql.executeQuery(query);
         System.out.println ("total row(s): " + rowCount);
      }catch(Exception e){
         System.err.println (e.getMessage());
      }
        }


	 public static void AddPatient(DBproject esql) {//2
                try{
         String query = "INSERT INTO Patient VALUES( ";
         System.out.print("\tEnter patient_ID: ");
         String input = in.readLine();
	 while(onlyAlphabets(input) ){  
          System.out.print("\tEnter patient_ID:  ");
          input = in.readLine();
         }
         query += input;
         query += ',';
			
         System.out.print("\tEnter name: ");
         String input1 = "'" + in.readLine() + "'";
         query += input1;
         query += ',';
			
         System.out.print("\tEnter gender: ");
         String input2 = "'" + in.readLine() + "'";
	 boolean g = true;
	  while(g) {
		if (input2.equals("'M'") || input2.equals("'F'")){
			g = false;
		}
		else {
			g = true;
			System.out.print("\tEnter gender: ");
         		input2 = "'" + in.readLine() + "'";
		}
	  }		
         query += input2;
         query += ',';
			
         System.out.print("\tEnter age: ");
         String input3 = in.readLine();
         query += input3;
         query += ',';
         System.out.print("\tEnter address: ");
         String input4 = "'" + in.readLine() + "'";
         query += input4;
         query += ',';
         System.out.print("\tEnter number of appointments: ");
         String input5 = in.readLine();
         query += input5;
         query += ')';

         int rowCount = esql.executeQuery(query);
         System.out.println ("total row(s): " + rowCount);
      }catch(Exception e){
         System.err.println (e.getMessage());
      }
        }


	public static void AddAppointment(DBproject esql) {//3
                try{
          String query = "INSERT INTO Appointment VALUES( ";
                 System.out.print("\tEnter Appointment ID: ");
                 String input = in.readLine();
		 while( onlyAlphabets(input) ){
                 System.out.print("\tEnter Appointment ID: ");
                 input = in.readLine();
                }
                 query += input;
                 query += ',';
                 System.out.print("\tEnter a date: ");
                 String input1 =  "'" + in.readLine() + "'";

                 while(input1.length() > 11  || input1.length() < 8) {
                  System.out.print("\tEnter a date: ");
                  input1 =  "'" + in.readLine() + "'";
                 }

                 query += input1;
                 query += ',';
			
                 System.out.print("\tEnter time_slot: ");
                 String input2 = "'" +  in.readLine() + "'";
                 query += input2;
                 query += ',';
			
                 System.out.print("\tEnter status: ");
                 String input3 = "'" +  in.readLine() + "'" ;
		 boolean in1 = true;
		 while(in1){
		 	if(input3.equals("'PA'") || input3.equals("'AC'") || input3.equals("'AV'") || input3.equals("'WL'")) {
				in1 = false;
			 
		 	}
			else {
				in1 = true;
				System.out.print("\tEnter status: ");
                 		input3 = "'" +  in.readLine() + "'" ;
				
			}
		 }
			
                 query += input3;

                 query += ");";

         int rowCount = esql.executeQuery(query);
         System.out.println ("total row(s): " + rowCount);
      }catch(Exception e){
         System.err.println (e.getMessage());
      }
        }



	public static void MakeAppointment(DBproject esql) {//4
		// Given a patient, a doctor and an appointment of the doctor that s/he wants to take, add an appointment to the DB
		try{
         String query = "SELECT Appointment.status FROM Appointment, Patient, Doctor, has_appointment  WHERE Doctor.doctor_ID = has_appointment.doctor_id AND has_appointment.appt_id = Appointment.appnt_ID AND Appointment.appnt_ID =  ";
         System.out.print("\tEnter Appointment ID:  ");
         String input = in.readLine();
         query += input;
		 query += " AND Patient.patient_ID =  ";

		 System.out.print("\tEnter Patient ID:  ");
         String input1 = in.readLine();
		 query += input1;
		 query += " AND Doctor.name =  ";

		 System.out.print("\tEnter Doctor Name:  ");
         String input2 = "'" +  in.readLine() + "'";
		 query += input2;

         int rowCount = esql.executeQuery(query);
         System.out.println ("total row(s): " + rowCount);
	 
      }catch(Exception e){
         System.err.println (e.getMessage());
      }
	}


	public static void ListAppointmentsOfDoctor(DBproject esql) {//5
                // For a doctor ID and a date range, find the list of active and available appointments of the doctor
                try{
                String query = "SELECT * FROM Appointment, Doctor WHERE Appointment.status = 'AC' OR Appointment.status = 'AV' AND Doctor.doctor_id = ";
                System.out.print("\tEnter doctor_ID: ");
                String input = in.readLine();

               while( onlyAlphabets(input) ){
                System.out.print("\tEnter doctor_ID: ");
                input = in.readLine();
                }
                query += input;

                query += " AND Appointment.adate  BETWEEN ";
                System.out.print("\tEnter date_A: ");
                String input1 = "'" + in.readLine() + "'";

                while(input1.length() > 11  || input1.length() < 8) {
                  System.out.print("\tEnter a date: ");
                  input1 =  "'" + in.readLine() + "'";
                 }
                query += input1;

                query += "AND  ";
                System.out.print("\tEnter date_B: ");
                String input2 = "'" + in.readLine() + "'";
                query += input2;

        int rowCount = esql.executeQuery(query);
         System.out.println ("total row(s): " + rowCount);

        }catch(Exception e){
            System.err.println (e.getMessage());
        }

    }


	public static void ListAvailableAppointmentsOfDepartment(DBproject esql) {//6
                // For a department name and a specific date, find the list of available appointments of the department
                try{
         String query = "SELECT *  FROM Department, Doctor,has_appointment, Appointment WHERE Appointment.status = 'AV' AND Department.dept_ID = Doctor.did AND Doctor.doctor_ID = has_appointment.doctor_id AND has_appointment.appt_id = Appointment.appnt_ID AND Appointment.adate =   ";
         System.out.print("\tEnter appointment date:  ");
         String input = "'"+ in.readLine()+ "'";
	 while(input.length() > 11  || input.length() < 8) {
                  System.out.print("\tEnter appointment date: ");
                  input =  "'" + in.readLine() + "'";
                 }
         query += input;

         query += "AND Department.name =  ";
         System.out.print("\tEnter Department Name:  ");
         String input1 = "'" + in.readLine()+ "'";
         query += input1;

         int rowCount = esql.executeQuery(query);
         System.out.println ("total row(s): " + rowCount);
      }catch(Exception e){
         System.err.println (e.getMessage());
      }
        }

	 public static void ListStatusNumberOfAppointmentsPerDoctor(DBproject esql) {//7
                // Count number of different types of appointments per doctors and list them in descending order
                try{
        String query = "SELECT Doctor.name,Appointment.status,COUNT(Appointment.status) AS num FROM Appointment, Doctor, has_appointment WHERE Doctor.doctor_ID = has_appointment.doctor_id AND Appointment.appnt_ID = has_appointment.appt_id GROUP BY Appointment.status, Doctor.name ORDER BY num  DESC; ";
                 int rowCount = esql.executeQuery(query);
        System.out.println ("total row(s): " + rowCount);
      }catch(Exception e){
        System.err.println (e.getMessage());
      }

        }


	public static void FindPatientsCountWithStatus(DBproject esql) {//8
                // Find how many patients per doctor there are with a given status (i.e. PA, AC, AV, WL) and list that number per doctor.
                try{
         String query = "SELECT Doctor.name,COUNT(Patient.name) FROM Patient, searches, Appointment, Doctor, has_appointment WHERE Patient.patient_ID = searches.pid AND searches.aid = Appointment.appnt_ID AND Doctor.doctor_ID = has_appointment.doctor_id AND Appointment.appnt_ID = has_appointment.appt_id AND Appointment.status = ";
         System.out.print("\tEnter status:  ");
         String input ="'" +  in.readLine() + "'";
	 boolean in1 = true;
		 while(in1){
		 	if(input.equals("'PA'") || input.equals("'AC'") || input.equals("'AV'") || input.equals("'WL'")) {
				in1 = false;
			 
		 	}
			else {
				in1 = true;
				System.out.print("\tEnter status: ");
                 		input = "'" +  in.readLine() + "'" ;
				
			}
		 }
         query += input;
         query += " GROUP BY Doctor.name;";
         //System.out.print(query);


         int rowCount = esql.executeQuery(query);
         System.out.println ("total row(s): " + rowCount);
      }catch(Exception e){
         System.err.println (e.getMessage());
      }
        }
	
}
