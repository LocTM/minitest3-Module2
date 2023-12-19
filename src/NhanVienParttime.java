public class NhanVienParttime extends NhanVien {
    double time;

    public NhanVienParttime(){
    
    }
    public NhanVienParttime(String id, String name, int age, int phone, String email, double time) {
        super(id, name, age, phone, email);
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double calCulate() {
        return time * 50000;
    }
}

