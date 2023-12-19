public class NhanVienFulltime extends NhanVien{
    double fixedSalary;
    double bonus;

    double fine;
    public NhanVienFulltime(){

    }
    public NhanVienFulltime(String id, String name, int age, int phone, String email, double fixedSalary, double bonus, double fine) {
        super(id, name, age, phone, email);
        this.fixedSalary = fixedSalary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double calCulate() {
        return fixedSalary + bonus - fine;
    }
}


