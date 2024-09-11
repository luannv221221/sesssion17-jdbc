package business;

import entity.Category;
import util.ConnectionDataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    // Sửa

    // Xóa
}
