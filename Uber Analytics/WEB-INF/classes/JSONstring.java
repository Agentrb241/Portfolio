public class JSONstring {

    // might have to remove static to be compatible with app code
    public static String toJSON(String[] stringArray){
        String input = "";
        String splitBy = ": ";
        String columnName = "JSON_Objects";
        String json = "{ \"" + columnName + "\" : [ ";
        for (int i = 0; i < stringArray.length; i++) {
            input = stringArray[i];
            String[] column = input.split(splitBy);    // use : as separator
            json += "{ \"" + column[0] + "\" : \"" + column[1] + "\" }";
            if (i+1 != stringArray.length) {
                json += ", ";
            } 
            else {
                 return json += " ] }";
            }
        }
        //return "Error with toJSON";
        return json += " ]}"; // this is still valid JSON
        
    }
  /*
    public static void main(String[] args){
        String[] stringArray = {"Manhattan: 150", "Bronx: 100", "Brooklyn: 50"};
        String JSON = toJSON(stringArray);
        System.out.println(JSON);
    }
  */
}
