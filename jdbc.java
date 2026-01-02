import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlConnect {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String jdbcId = "dbadmin";
        final String jdbcPass = "passw0rd";
        final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/";
        Connection cn = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);
        PreparedStatement st = cn.prepareStatement("show databases");
        ResultSet rs = st.executeQuery();
        while( rs.next() )
        {
            System.out.println( rs.getString(1));
        }
        rs.close();
        st.close();
        cn.close();
    }
}
