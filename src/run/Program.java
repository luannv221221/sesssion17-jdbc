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
                    break;
                case 4:
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
}
