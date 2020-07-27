package jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JDBCConnectionJava {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        //dynamic sql class loader
        //Class.forName("com.mysql.cj.jdbc.Driver");
        /**
         * create connection to db
         */
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Business?serverTimezone=UTC&useSSL=false", "root", "qwe1rty2");
        //Statament obj for execute queries
        Statement statement = connection.createStatement();

        /**
         * execute query to find by CourseName
         */
        getResultQuery(statement, "select * from CustomerInfo where CourseName = 'Jmeter';");

        /**
         * execute query select all results
         */
        getResultQuery(statement, "select * from CustomerInfo;");

        /**
         * serialize to pojo
         */

        //create pojo obj
        CustomerDetailsPOJO customerDetailsPOJO = new CustomerDetailsPOJO();
        //execute query and write to ResultSet obj
        ResultSet resultForAppiumQuery = statement.executeQuery("select * from CustomerInfo where CourseName = 'Appium'");
        //get result
        resultForAppiumQuery.next();
        //serisalize
        customerDetailsPOJO.setCourseName(resultForAppiumQuery.getString(1));
        customerDetailsPOJO.setPurchasedDate(resultForAppiumQuery.getString(2));
        customerDetailsPOJO.setAmount(Integer.parseInt(resultForAppiumQuery.getString(3)));
        customerDetailsPOJO.setLocation(resultForAppiumQuery.getString(4));

        System.out.println(customerDetailsPOJO);

        /**
         * serialize with jackson
         */
        //Create json file
        File jdbcJsonFile = new File("java-sheets/target/jdbcJsonFile.json");
        //write to file
        jacksonSerializeAndWriteToFile(jdbcJsonFile, customerDetailsPOJO);
        //add all jsons to arrayList
        ArrayList<CustomerDetailsPOJO> customers = getListOfObjects(statement, "select * from CustomerInfo;");

        //close connection
        connection.close();
    }

    /**
     *
     * @param statement
     * @param query
     * @throws SQLException
     * Print all columns from resultSet
     */
    public static void getResultQuery(Statement statement, String query) throws SQLException {
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            //get 1st column info
            System.out.println(result.getString(1));
            //get 2nd column info
            System.out.println(result.getString(2));
            //get 3th column info
            System.out.println(result.getString(3));
            //get 4th column info
            System.out.println(result.getString(4));
            System.out.println("-------");
        }
    }

    /**
     * write json to file
     */
    public static void jacksonSerializeAndWriteToFile(File file, Object object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, object);
    }

    /**
     * Array list of serilized objects
     */
    public static ArrayList<CustomerDetailsPOJO> getListOfObjects(Statement statement, String query) throws IOException, SQLException {
        ArrayList<CustomerDetailsPOJO> list = new ArrayList<>();
        ResultSet result = statement.executeQuery(query);
        CustomerDetailsPOJO customerDetailsPOJO;
        while (result.next()) {
            customerDetailsPOJO = new CustomerDetailsPOJO();
            customerDetailsPOJO.setCourseName(result.getString(1));
            customerDetailsPOJO.setPurchasedDate(result.getString(2));
            customerDetailsPOJO.setAmount(Integer.parseInt(result.getString(3)));
            customerDetailsPOJO.setLocation(result.getString(4));
            list.add(customerDetailsPOJO);
        }
        return list;
    }
}
