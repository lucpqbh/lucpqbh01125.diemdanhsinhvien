
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ");
            System.out.println(" 1. Nhập danh sách sinh viên ");
            System.out.println(" 2. Tìm học sinh theo họ ");
            System.out.println(" 3. Tìm và chỉnh sửa học sinh theo họ tên ");
            System.out.println(" 4. Kết thúc ");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    nhapDanhSachSinhVien();
                    break;
                case 2:
                    timSinhVienTheoHo();
                    break;
                case 3:
                    timVaChinhSuaSinhVienTheoHoTen();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (luaChon != 4);
    }

    private static void nhapDanhSachSinhVien() {
        System.out.println(" NHẬP DANH SÁCH SINH VIÊN ");
        System.out.print(" Nhập số lượng sinh viên: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();
        danhSachSinhVien.add(new SinhVien("Pham Qui Luc", 19));
        danhSachSinhVien.add(new SinhVien("Pham Khanh Linh", 19));
        danhSachSinhVien.add(new SinhVien("Pham Văn lam", 19));
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 2) + ":");
            System.out.print("Họ và tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Tuổi: ");
            int tuoi = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            SinhVien sv = new SinhVien(hoTen, tuoi);
            danhSachSinhVien.add(sv);
        }
    }

    private static void timSinhVienTheoHo() {
        System.out.println(" TÌM SINH VIÊN THEO HỌ ");
        System.out.print(" Nhập họ cần tìm: ");
        String ho = scanner.nextLine();
        boolean timThay = false;

        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getHoTen().toLowerCase().contains(ho.toLowerCase())) {
                System.out.println(sv);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sinh viên có họ là " + ho);
        }
    }

    private static void timVaChinhSuaSinhVienTheoHoTen() {
        System.out.println(" TÌM VÀ CHỈNH SỬA SINH VIÊN THEO HỌ TÊN ");
        System.out.print(" Nhập họ tên cần tìm và chỉnh sửa: ");
        String hoTen = scanner.nextLine();
        boolean timThay = false;

        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getHoTen().equalsIgnoreCase(hoTen)) {
                System.out.println(" Thông tin sinh viên cần chỉnh sửa:");
                System.out.println(sv);
                System.out.print(" Nhập họ tên mới: ");
                String hoTenMoi = scanner.nextLine();
                sv.setHoTen(hoTenMoi);
                System.out.println(" Chỉnh sửa thành công.");
                timThay = true;
                break; // Chỉ cần chỉnh sửa 1 sinh viên
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sinh viên có họ tên là " + hoTen);
        }
    }
}

class SinhVien {
    private String hoTen;
    private int tuoi;

    public SinhVien(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "Họ và tên: " + hoTen + ", Tuổi: " + tuoi;
    }
}


