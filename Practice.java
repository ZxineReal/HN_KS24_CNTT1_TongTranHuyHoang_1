import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mssv = new String[100];
        int choice = 0;
        int n = 0;
        do {
            System.out.println("1. In ra danh sách MSSV hiện có");
            System.out.println("2. Thêm MSSV mới");
            System.out.println("3. Cập nhật MSSV mới");
            System.out.println("4. Xóa MSSV cụ thể");
            System.out.println("5. Tìm kiếm MSSV");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printMSSV(mssv, n);
                    break;
                case 2:
                    n = addMSSV(mssv, n);
                    break;
                case 3:
                    updateMSSV(mssv, n);
                    break;
                case 4:
                    n = deleteMSSV(mssv, n);
                    break;
                case 5:
                    break;
                case 6:

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                    break;
            }
        } while (choice != 6);
    }
    public static void  printMSSV(String[] arr, int n) {
        if (n <= 0) {
            System.out.println("Hiện không có MSSV nào!");
        } else {
            System.out.println("Danh sách MSSV:");
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
    }
    public static int addMSSV(String[] arr, int n) {
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m;
        p = Pattern.compile("^B\\d{7}$");
        boolean flag = false;

        while (!flag) {
        System.out.println("Mời bạn nhập vào MSSV cần thêm:");
        String newMssv = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(newMssv)) {
                System.out.println("Mã sinh viên đã tồn tại!");
            }
        }
        m = p.matcher(newMssv);
        if (m.find()) {
            System.out.println("Thêm thành công MSSV: " + newMssv);
            arr[n++] = newMssv;
            break;
        } else {
            System.out.println("Sai định dạng, vui lòng nhập lại!");
        }
        }
        return n++;
    }
    public static void updateMSSV(String[] arr, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào MSSV cần chỉnh sửa:");
        String mssv = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i].equals(mssv)) {
                found = true;
                System.out.println("Mời bạn nhập vào MSSV mới:");
                String newMssv = sc.nextLine();
                arr[i] = newMssv;
                System.out.println("Cập nhật MSSV thành công!");
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy MSSV!");
        }
    }
    public static int deleteMSSV(String[] arr, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào MSSV cần xóa:");
        String mssv = sc.nextLine();
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(mssv)) {
                index = i;
            }
        }

        if (index >= 0) {
            for (int i = index; i < n-1; i++) {
                arr[i] = arr[i+1];
            }
            System.out.println("Xóa mã sinh viên thành công");
        } else {
            System.out.println("Mã sinh viên không tồn tại!");
        }

        return n--;
    }
    public static void findMSSV(String[] arr, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập chuỗi ký tự");
    }
}
