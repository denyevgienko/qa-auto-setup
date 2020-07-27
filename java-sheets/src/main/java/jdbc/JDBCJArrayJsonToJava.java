package jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JDBCJArrayJsonToJava {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        /**
         * create connection to db
         */
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Business?serverTimezone=UTC&useSSL=false", "root", "qwe1rty2");
        //Statament obj for execute queries
        Statement statement = connection.createStatement();
        //create pojo obj
        //execute query and write to ResultSet obj
        ResultSet resultForAppiumQuery = statement.executeQuery("select * from CustomerInfo;");
        //Create json file
        File jdbcJsonArrayFile = new File("java-sheets/target/jdbcArrayJsonFile.json");

        //create json array
        JSONArray jsonArray = new JSONArray();
        //create list of pogo
        ArrayList<CustomerDetailsPOJO> list = new ArrayList<>();
        CustomerDetailsPOJO customerDetailsPOJO;
        //go throw all objects from query result
        while (resultForAppiumQuery.next()) {
            customerDetailsPOJO = new CustomerDetailsPOJO();
            customerDetailsPOJO.setCourseName(resultForAppiumQuery.getString(1));
            customerDetailsPOJO.setPurchasedDate(resultForAppiumQuery.getString(2));
            customerDetailsPOJO.setAmount(Integer.parseInt(resultForAppiumQuery.getString(3)));
            customerDetailsPOJO.setLocation(resultForAppiumQuery.getString(4));
            list.add(customerDetailsPOJO);
        }
        //add all objects from array list to jsonArray
        list.forEach(x -> jsonArray.add(x));
        //add json array to json object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);

        //write json object to file
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(jdbcJsonArrayFile, jsonObject);

        System.out.println(jsonObject.toJSONString());
        //close connection
        connection.close();
    }

}
