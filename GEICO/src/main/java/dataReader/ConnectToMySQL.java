package dataReader;

import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectToMySQL {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    public static Properties LoadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }
    public static Connection connectToMySQL() throws Exception{
        Properties prop = LoadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String username = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url,username,password);
        System.out.println("Database is connected");
        return connect;
    }
    public void createTable (String tableName, String columnName, List<WebElement> webelement) throws Exception{
        try {
            connectToMySQL();
            String query1 = "drop table "+tableName;
            ps = connect.prepareStatement(query1);
            ps.executeUpdate();
            String query2 = "create table "+tableName+"("+columnName+" varchar(100))";
            ps = connect.prepareStatement(query2);
            ps.executeUpdate();
            for(WebElement it: webelement){
                String query3 = "insert into "+tableName+" values('"+it.getText()+"')";
                ps = connect.prepareStatement(query3);
                ps.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<String> readData(String tableName, String columnName) {
        List<String> warning = new ArrayList<>();
        try{
            Connection con = connectToMySQL();
            Statement st = con.createStatement();
            String query = "select * from " + tableName;
            //st.executeUpdate("insert into pnt(stdId,stName) values(8,'bah')");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                //System.out.println("Data"+rs.getString("stdId")+" "+rs.getString("stName"));
                warning.add(rs.getString(columnName));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return warning;
    }
}


