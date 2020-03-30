import java.sql.*;

public class DBAcessor {
    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:bird.db");
        Statement stat = conn.createStatement();

        ResultSet rs = stat.executeQuery("select * from birds;");
        while (rs.next()) {
            System.out.println("name = " + rs.getString("name"));
            System.out.println("desc = " + rs.getString("description"));
            System.out.println("habitat = " + rs.getString("habitat"));
        }
        rs.close();
        conn.close();
    }


}
