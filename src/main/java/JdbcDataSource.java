import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDataSource {

    public static void main(String[] args) {

        Connection conn = null;
        try {

            PGSimpleDataSource dataSource = new PGSimpleDataSource();
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("biblioteka");
            dataSource.setPortNumber(5432);
            dataSource.setUser("postgres");
            dataSource.setPassword("Ryznar1");

            conn = dataSource.getConnection();

            Statement stmt = conn.createStatement();
            stmt.execute("select * from autor");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id_autor = rs.getInt(1);
                String imie = rs.getString(2);
                System.out.println(id_autor + "  " + imie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
