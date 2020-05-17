package connection;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bima
 */
public class JavaConnector {
    Connection conn;
    
public static Connection ConnecrDb(){
  try{
     
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/queue", "root", "");
     return conn;
  } catch(Exception e){
      
  }
        return null;
}
}
