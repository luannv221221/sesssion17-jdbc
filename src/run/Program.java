package run;

import business.CategoryBusiness;
import entity.Category;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("===============MENU===============\n" +
                    "1.Danh sách danh mục\n" +
                    "2.Thêm mới danh mục\n" +
                    "3.Sửa danh mục\n" +
                    "4.Xóa danh mục \n"+
                    "5.Thoát \n");
            System.out.println("Mời bạn lựa chọn 1 - 4");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Program.displayCategories();
                    break;
                case 2:
                    Program.createCategory(scanner);
                    break;
                case 3:
                    Program.updateCategory(scanner);
                    break;
                case 4:
                    Program.deleteCategory(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Chọn sai vui lòng chọn lại");
            }
        } while (true);
    }

    // xây dưng phương thức hiển thị danh sách danh mục
    public static void displayCategories(){
        List<Category> categories = CategoryBusiness.getAll();
        for (Category category : categories) {
            category.showData();
        }
    }
    // xây dựng phương thức thêm mới danh mục
    public static void createCategory(Scanner scanner){
        Category category = new Category();
        category.inputData(scanner);
        boolean result =  CategoryBusiness.create(category);
        if(result){
            System.out.println("Thêm mới thành công");
        } else {
            System.err.println("Thêm mới thất bại");
        }
    }
    // xây dựng phương thức cập nhật danh mục
    public static void updateCategory(Scanner scanner){
        // Bước 1. Nhập Id Cần sửa
        System.out.println("Nhap vao id can sua ");
        int idEdit = Integer.parseInt(scanner.nextLine());
        // Hiển thị danh mục tìm được
        Category category = CategoryBusiness.findById(idEdit);
        // show danh mục
        if(category != null){
            System.out.println("Thông tin danh mục ");
            category.showData();
            // hỏi người dùng muốn update trường nào và nhập thông tin
            boolean isExit = true;
            do {
                System.out.println("Chọn trường muốn cập nhật");
                System.out.println("1. Sửa tên danh mục");
                System.out.println("2. Sửa trạng thái");
                System.out.println("3. Thoát ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập vào tên mới");
                        category.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào trạng thái");
                        category.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 3:
                        isExit = false;
                        break;
                    default:
                        System.out.println("Sai lua chọn");
                }
            }while (isExit);
            // thực cập nhật trong database gọi đến update của CategoryBusiness
            boolean result = CategoryBusiness.update(category);
            if(result){
                System.out.println("Cập nhật thanh công");
            } else {
                System.err.println("Cập nhật thất bại ");
            }
        } else {
            System.out.println("Koo tim thay danh mục");
        }

    }

    // phương thức xóa danh mục
    public static void deleteCategory(Scanner scanner){
        System.out.println("Mời bạn nhập vào id cần xóa ?");
        int id = Integer.parseInt(scanner.nextLine());
        if(CategoryBusiness.findById(id) != null){
            boolean result = CategoryBusiness.delete(id);
            if(result){
                System.out.println("Xóa thành công ");
            } else {
                System.err.println("Xóa thất bại");
            }
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }
}
