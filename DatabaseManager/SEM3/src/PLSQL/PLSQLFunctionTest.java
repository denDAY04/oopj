package PLSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * {Insert class description here}
 * 
 * @author Andreas Stensig Jensen, on Nov 7, 2014
 * Contributors: 
 */
public class PLSQLFunctionTest {

    private static String url = "jdbc:postgresql://thelizard6.eitlab.ihk-edu.dk:5432/stensig3e14";
    private static String userName = "stensig3e14";
    private static String password = "s134408";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver").newInstance();
        Connection con = DriverManager.getConnection(url, userName, password);
        
        String update = "insert into testPrice (id, price) values (4, calcPrice(2400, true));";
        String query = "select * from testPrice;";
        
        
        PreparedStatement statement = con.prepareStatement(update);
        statement.executeUpdate();
        statement = con.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            System.out.println("" + result.getString(2));
        }
    }

        
}
