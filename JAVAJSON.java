    package assign;
    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;
    import com.google.gson.JsonArray;
    import com.google.gson.JsonObject;
    import com.google.gson.JsonParser;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
     
    public class json {
        public static void main(String[] args) {
            
            // Create new JSON Object
            JsonObject person = new JsonObject();
            person.addProperty("firstName", "Suraj");
            person.addProperty("lastName", "Singh");
            System.out.println(person.toString());
            // Create Inner JSON Object 
            JsonObject address = new JsonObject();
            address.addProperty("country", "india");
            address.addProperty("city", "pune");
            person.add("address", address);
            System.out.println(person.toString());
            
            // Create JSON Array from String
            String jsonString = "{\"firstName\":\"Suraj\",\"lastName\":\"Bisht\"}";
            JsonParser jsonParser = new JsonParser();
            JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
     
            System.out.println(objectFromString.toString());
            
            // Convert JSON Array String into JSON Array 
            String jsonArrayString = "[\"C\",\"C++\",\"JAVA\"]";
            JsonArray arrayFromString = jsonParser.parse(jsonArrayString).getAsJsonArray();
            
            System.out.println(arrayFromString.toString());
            
            
            // Convert JSON Array String into Java Array List
             Gson googleJson = new Gson();
             ArrayList javaArrayListFromGSON = googleJson.fromJson(arrayFromString, ArrayList.class);
             
             System.out.println(javaArrayListFromGSON);
            
            //Convert Java Plain Object into JSON
            Person personPojo = new Person();
            personPojo.setFname("Suraj");
            personPojo.setLname("Bisht");
            Gson gsonBuilder = new GsonBuilder().create();
            String jsonFromPojo = gsonBuilder.toJson(personPojo);
            
            System.out.println(jsonFromPojo);
            // Convert Java Map into JSON 
            Map personMap = new HashMap();
            personMap.put("firstName", "Suraj");
            personMap.put("lastName", "Bisht");
            String jsonFromJavaMap = gsonBuilder.toJson(personMap);
            
            System.out.println(jsonFromJavaMap);
            // Convert Java Array into JSON
            List languagesArrayList = new ArrayList();
            languagesArrayList.add("C");
            languagesArrayList.add("C++");
            languagesArrayList.add("JAVA");
            
            String jsonFromJavaArrayList = gsonBuilder.toJson(languagesArrayList);
            
            System.out.println(jsonFromJavaArrayList);
           
        }
        
                
    }

        class Person{
            String fname,lname;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    public Person() {
        
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
            
        }
