import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int soNhanVien = 4;
        NhanVien[] nhanVienArray = new NhanVien[soNhanVien];

        nhanVienArray[0] = new NhanVienFulltime("NV1", "Trần Minh Lộc", 30, 123456789, "tranminhloc@gmail.com", 10000000, 1000000, 500000);
        nhanVienArray[1] = new NhanVienFulltime("NV4", "Trần Ngọc Châu", 30, 123456789, "tranngocchau@gmail.com", 10000000, 500000, 1000000);
        nhanVienArray[2] = new NhanVienParttime("NV2", "Nguyễn Đình Thống", 22, 987654321, "nguyendinhthong@gmail.com", 200);
        nhanVienArray[3] = new NhanVienParttime("NV3", "Nguyễn Đình Phong", 30, 999999999, "nguyendinhphong@gmail.com", 100);

        while (true) {
            System.out.println("MENU");
            System.out.println("1. Tính trung bình lương của nhân viên cả công ty.");
            System.out.println("2. Tính trung bình lương của nhân viên fulltime.");
            System.out.println("3. Tính trung bình lương của nhân viên parttime.");
            System.out.println("4. Tính tổng lương phải trả cho nhân viên partime.");
            System.out.println("5. Đếm số người có mức lương cao hơn mức lương trung bình toàn công ty.");
            System.out.println("6. Đếm số nhân viên partime có tên được nhập vào từ bàn phím.");
            System.out.println("0. Thoát chương trình.");

            int chose = scanner.nextInt();

            switch (chose) {
                case 1:
                    AvgSalary(nhanVienArray);
                    break;
                case 2:
                    AvgSalaryFulltime(nhanVienArray);
                    break;
                case 3:
                    AvgSalaryParttime(nhanVienArray);
                    break;
                case 4:
                    totalSalaryParttime(nhanVienArray);
                    break;
                case 5:
                    countHigher(nhanVienArray);
                    break;
                case 0:
                    System.out.println("Kết thúc");
                    System.exit(0);
                default:
                    System.out.println("Hãy chọn từ 1-6");
            }
        }
    }

    private static void AvgSalary(NhanVien[] nhanVienArray) {
        double totalSalary = 0;
        int soNhanVien = 0;
        for (NhanVien nv : nhanVienArray) {
            if (nv instanceof NhanVienFulltime || nv instanceof NhanVienParttime) {
                totalSalary += nv instanceof NhanVienFulltime ? ((NhanVienFulltime) nv).calCulate() : ((NhanVienParttime) nv).calCulate();
                soNhanVien++;
            }
        }
        double avgSalary = soNhanVien > 0 ? totalSalary / soNhanVien : 0;
        System.out.println("Trung bình lương của nhân viên cả công ty là: " + avgSalary);
    }

    private static void AvgSalaryFulltime(NhanVien[] nhanVienArray) {
        double totalSalary = 0;
        int soNhanVienFulltime = 0;
        for (NhanVien nv : nhanVienArray) {
            if (nv instanceof NhanVienFulltime) {
                totalSalary += ((NhanVienFulltime) nv).calCulate();
                soNhanVienFulltime++;
            }
        }
        double avgSalaryFulltime = soNhanVienFulltime > 0 ? totalSalary / soNhanVienFulltime : 0;
        System.out.println("Trung bình lương của nhân viên fulltime là: " + avgSalaryFulltime);
    }

    private static void AvgSalaryParttime(NhanVien[] nhanVienArray) {
        double totalSalary = 0;
        int soNhanVienParttime = 0;
        for (NhanVien nv : nhanVienArray) {
            if (nv instanceof NhanVienParttime) {
                totalSalary += ((NhanVienParttime) nv).calCulate();
                soNhanVienParttime++;
            }
        }
        double avgSalaryParttime = soNhanVienParttime > 0 ? totalSalary / soNhanVienParttime : 0;
        System.out.println("Trung bình lương của nhân viên parttime là: " + avgSalaryParttime);
    }
    
    private static void totalSalaryParttime(NhanVien[] nhanVienArray) {
        double totalSalary = 0;
        for (NhanVien nv : nhanVienArray) {
            if (nv instanceof NhanVienParttime) {
                totalSalary += ((NhanVienParttime) nv).calCulate();
            }
        }
        System.out.println("Tổng lương phải trả cho nhân viên parttime là: " + totalSalary);
    }

    private static void countHigher(NhanVien[] nhanVienArray) {
        double avgSalaryCompany = AvgCompany(nhanVienArray);
        int count = 0;
        for (NhanVien nv : nhanVienArray) {
            if (nv instanceof NhanVienFulltime || nv instanceof NhanVienParttime) {
                double salary = nv instanceof NhanVienFulltime ? ((NhanVienFulltime) nv).calCulate() : ((NhanVienParttime) nv).calCulate();
                if (salary > avgSalaryCompany) {
                    count++;
                }
            }
        }
        System.out.println("Số người có mức lương cao hơn mức lương trung bình toàn công ty là: " + count);
    }

    private static double AvgCompany(NhanVien[] nhanVienArray) {
        double tongLuong = 0;
        int soNhanVien = 0;
        for (NhanVien nv : nhanVienArray) {
            if (nv instanceof NhanVienFulltime || nv instanceof NhanVienParttime) {
                tongLuong += nv instanceof NhanVienFulltime ? ((NhanVienFulltime) nv).calCulate() : ((NhanVienParttime) nv).calCulate();
                soNhanVien++;
            }
        }
        return soNhanVien > 0 ? tongLuong / soNhanVien : 0;
    }
}