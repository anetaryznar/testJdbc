import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcHikariProperties {
    private static final int MAX_SIZE = 3;

    public static void main(String[] args) {

        Connection conn = null;
        try {

            HikariConfig config = new HikariConfig("/hikari.properties");
            DataSource dataSource = new HikariDataSource(config);

            conn.setAutoCommit(false);
            conn = dataSource.getConnection();


            String SQL = "Update autor SET imie = ? WHERE id_autor = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1,"olek");
            pstm.setInt(2,3);

            int rs1 = pstm.executeUpdate();
            System.out.println(rs1);





            Statement stmt = conn.createStatement();
            stmt.execute("select * from autor");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int personId = rs.getInt(1);
                String lastName = rs.getString(2);

                System.out.println(personId + " " + lastName);
            }
            try {
                if (stmt != null)
                    stmt.close();
            } catch (Exception e) {
                System.out.println(e);
            }


//            Statement stmt1 = conn.createStatement();
//            stmt1.execute("select * from egzemplarz");
//            ResultSet rs1 = stmt1.getResultSet();
//            // do work
//            while (rs1.next()) {
//                int idksiazka = rs1.getInt(1);
//                int nrKatalogowy = rs1.getInt(2);
//
//                System.out.println(idksiazka + " " + nrKatalogowy);
//            }
//            try {
//                if (stmt1 != null)
//                    stmt1.close();
//            } catch (Exception e) {
//                System.out.println(e);
//            }


        } catch (Exception e) {
            // handle any exceptions as appropriate
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

    public String gjjhfs() {

        return "";
    }
}
