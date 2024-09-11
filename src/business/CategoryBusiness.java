package business;

import entity.Category;
import util.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryBusiness {
    // Lấy về danh sách
    public static List<Category> getAll(){
        List<Category> categories = new ArrayList<>();
        Connection connection = null;
        try {
            // b1 Tạo đối tượng kết nois
             connection = ConnectionDataBase.openConnection();
            // b2 viết câu lệnh truy vấn
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category");
            // b3 thực thi
            ResultSet resultSet = statement.executeQuery();
            // b4 duyêt dữ liệu từ resulSet và gán vào categories
            while (resultSet.next()){
                // duyệt từng dòng dữ liệu trong resulSet
               Category category = new Category();
               category.setId(resultSet.getInt("id"));
               category.setName(resultSet.getString("name"));
               category.setStatus(resultSet.getBoolean("status"));
               categories.add(category);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }

        return categories;
    }
    // Thêm mới
    public static boolean create(Category category){
        Connection connection = null;

        try {
            // tạo đối tượng kết nối
            connection = ConnectionDataBase.openConnection();
            // Tạo đối tượng PreparedStatement
            String sql = "insert into category(name,status) value(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            // set các giá trị của tham số trong sql của prepareStatement
            statement.setString(1,category.getName());
            statement.setBoolean(2,category.isStatus());
            //thực thi câu truy vấn
            statement.executeUpdate();
            return true;
        } catch (Exception e){
                e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }

        return false;
    }

    // Sửa

    // Xóa
}
