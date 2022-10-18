package library.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {
    public final static String connectionString = "jdbc:mysql://localhost:3306/t2203e";
    public final static String user = "root";
    public final static String pwd = "root";// neu la xampp: "" , mamp: "root"

    Connection conn;

    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(connectionString,user,pwd);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Statement getStatement() throws Exception{
        return conn.createStatement();
    }

    public ResultSet query(String sql){
        try {
            return getStatement().executeQuery(sql);
        }catch (Exception e){
            return null;
        }
    }

    public boolean executeQuery(String sql){
        try {
             getStatement().execute(sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
