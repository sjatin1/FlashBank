package perfios.pojo;

import java.sql.*;

public class Util {
    public static Statement getStatement(){
        Connection con = null;
        Statement st =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PerfiosBank","root","password");
            st = con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }
    public static Connection getPstatement(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PerfiosBank","root","password");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

}
