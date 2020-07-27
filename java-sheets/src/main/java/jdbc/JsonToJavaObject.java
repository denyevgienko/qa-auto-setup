package jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToJavaObject {

    public static void main(String[] args) throws IOException {

        File jsonFile = new File("java-sheets/src/main/java/jdbc/fileexample/jsonFile.json");

        CustomerDetailsPOJO customerDetailsPOJO;
        ObjectMapper objectMapper = new ObjectMapper();
        customerDetailsPOJO = objectMapper.readValue(jsonFile, CustomerDetailsPOJO.class);

        System.out.println(customerDetailsPOJO);



    }

}
