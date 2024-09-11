package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/session16_jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // xây dựng phương thực tạo đôối tượng Connection kết nối java vơi CSDL
    public static Connection openConnection(){
        Connection connection = null;

        try {
            // đăng ký driver cho thằng DriverManager để biết kết nối đến CSDL nào
            Class.forName(DRIVER);
            // Tạo đối tượng connection từ DriveManager
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
    // phương thức đóng kết nối
    public static void closeConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
