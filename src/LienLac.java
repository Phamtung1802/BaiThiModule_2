public class LienLac {
    String hoTen;
    String soDienThoai;
    String diaChi;
    String email;

    public LienLac(String hoTen, String soDienThoai, String diaChi, String email) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "Ho Ten= " + hoTen +"\n"+
                "So Dien Thoai= " + soDienThoai +"\n"+
                "Dia Chi= " + diaChi +"\n"+
                "Email= " + email +"\n";
    }
}
