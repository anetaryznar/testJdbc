

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDriver {
    public static void main(String[] args) {
        Connection conn = null;
        try{
            Properties props = new Properties();
            props.put("user","postgres");
            props.put("password","Ryznar1");

            Driver d  = (Driver) Class.forName("org.postgresql.Driver").newInstance();
            conn = d.connect("jdbc:postgresql://localhost:5432/biblioteka",props);

            Statement stmt = conn.createStatement();
            stmt.execute("select * from autor");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                int id_autor = rs.getInt(1);
                String imie = rs.getString(2);
                System.out.println(id_autor+"  "+ imie);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
