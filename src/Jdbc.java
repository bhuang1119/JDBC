import java.sql.*;

public class Jdbc {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "";
            sql = "select * from user";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String  host = rs.getString(1);
                String user = rs.getString(2);
                String pass = rs.getString(3);

                System.out.println("host:"+host);
                System.out.println("user:"+user);
                System.out.println("pass:"+pass);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



}
