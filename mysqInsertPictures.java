import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysqInsertPictures {


        public static void main(String[] args) throws Exception, IOException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banderas?autoRecconect=true&useSSL=false","root","root");
            String INSERT_PICTURE = "UPDATE `suppliers` SET `foto`=? WHERE `id`=1";

            conn.setAutoCommit(false);
            File file = new File("HeroV2.png");
            try {
                    FileInputStream fis = new FileInputStream(file);
                    PreparedStatement ps = conn.prepareStatement(INSERT_PICTURE);
                //ps.setString(1, "001");
                //ps.setString(2, "name");
                ps.setBinaryStream(1, fis, (int) file.length());
                ps.executeUpdate();
                conn.commit();
            } catch (IOException ieo){
                System.out.println(ieo);
            }
        }


}
