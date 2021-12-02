package ir.maktab.HW14.ataAccess;

import java.sql.Connection;
import java.sql.DriverManager;


public class BaseDao {
    private static final String URL = "jdbc:mysql://localhost:3306/hw13th";
    private static final String USERNAME = "neda";
    private static final String PASSWORD = "13730203@Neda";
    protected Connection connection;

    public BaseDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
