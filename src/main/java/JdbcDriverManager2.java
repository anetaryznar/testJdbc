import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDriverManager2 {
    public static void main(String[] args) {
        Connection conn = null;
        try{

            DriverManager.registerDriver(new org.postgresql.Driver() );
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteka?user=postgres&password=Ryznar1");

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
