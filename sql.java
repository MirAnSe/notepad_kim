import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

class sql {
    public static void main(String args[]){
        try{
            System.out.println("Start Connect");
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoRecconect=true&useSSL=false","root","root");
            System.out.println("Connect ok");
        }catch (ClassNotFoundException cne){
            System.out.println("Error EXEPTION: "+cne);
        }catch (SQLException sqle){
            System.out.println("Error SQL: "+sqle);
        }
    }
}
