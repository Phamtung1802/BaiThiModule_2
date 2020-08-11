public class Main {
    public static void main(String[] args) {
        DanhBa.getInstance().loadDanhBa("Contact.txt");
        GiaoDienNguoiDung.startMainMenu();
    }
}
