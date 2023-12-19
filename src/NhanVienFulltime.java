public class NhanVienFulltime extends NhanVien{
    double fixedSalary;
    double bonus;
    double fine;

    public NhanVienFulltime(String id, String name, int age, int phone, String email, double fixedSalary, double bonus, double fine) {
        super(id, name, age, phone, email);
        this.fixedSalary = fixedSalary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public double tinhLuong() {
        return fixedSalary + bonus - fine;
    }
}


