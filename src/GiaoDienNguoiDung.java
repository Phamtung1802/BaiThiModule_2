import java.util.Scanner;

public class GiaoDienNguoiDung {
    static String hoTen="",soDienThoai="",diaChi="",email="";
    static void startMainMenu(){
        int choice=-1;
        while(!(choice ==8)){
            Scanner input=new Scanner(System.in);
            System.out.println("-------------------CHUONG TRINH QUAN LY DANH BA-------------------");
            System.out.println("CHON CHUC NANG THEO SO DE TIEP TUC");
            System.out.println("1. IN DANH SACH");
            System.out.println("2. THEM MOI");
            System.out.println("3. CAP NHAT");
            System.out.println("4. XOA");
            System.out.println("5. TIM KIEM");
            System.out.println("6. DOC TU FILE");
            System.out.println("7. GHI VAO FILE");
            System.out.println("8. THOAT");
            choice=input.nextInt();
            input.nextLine();
            if (choice==1){
                String subChoice="";
                System.out.println("DANH BA:\n");
                System.out.println("1. THEM MOI");
                System.out.println("Danh Ba-An Enter De Tim Lien Lac Tiep Theo");
                subChoice= input.nextLine();
                input.nextLine();
                if(subChoice.equals("1")){
                    hienThiMenuSua(input);
                    DanhBa.getInstance().add(hoTen,soDienThoai,diaChi,email);
                    hoTen="";soDienThoai="";diaChi="";email="";
                    return;
                }else {
                    DanhBa.getInstance().hienThiDanhBa();
                    System.out.println("\n\n");
                }
            }
            if(choice==2){
                hienThiMenuSua(input);
                DanhBa.getInstance().add(hoTen,soDienThoai,diaChi,email);
                hoTen="";soDienThoai="";diaChi="";email="";
            }
            if(choice==3){
                System.out.println("-------------------CAP NHAT DANH BA-------------------");
                System.out.println("NHAP TEN LIEN LAC CAN SUA: ");
                String tenLienLac=input.nextLine();
                int ketQua=DanhBa.getInstance().find(tenLienLac);
                if(ketQua>-1){
                    hienThiMenuSua(input);
                    DanhBa.getInstance().amend(ketQua,hoTen,soDienThoai,diaChi,email);
                    hoTen="";soDienThoai="";diaChi="";email="";
                }
                else System.out.println("Khong Tim Thay Ten Lien Lac\n\n\n");
            }
            if(choice==4){
                System.out.println("-------------------XOA LIEN LAC-------------------");
                System.out.println("NHAP TEN LIEN LAC CAN XOA: ");
                String tenLienLac=input.nextLine();
                int ketQua=DanhBa.getInstance().find(tenLienLac);
                System.out.println();
                if(ketQua>-1){
                    System.out.println("BAN CO CHAC MUON XOA KHONG");
                    System.out.println("1. Co");
                    System.out.println("2. Khong");
                    int luaChon=input.nextInt();
                    input.nextLine();
                    if(luaChon==1){
                        DanhBa.getInstance().delete(ketQua);
                        System.out.println("Da Xoa");
                    }
                }
                else System.out.println("Khong Tim Thay Ten Lien Lac\n\n\n");
            }
            if(choice==5){
                System.out.println("-------------------TIM KIEM LIEN LAC-------------------");
                System.out.println("NHAP TEN LIEN LAC CAN TIM: ");
                String tenLienLac=input.nextLine();
                int ketQua=DanhBa.getInstance().find(tenLienLac);
                if(ketQua>-1){
                    System.out.println(DanhBa.getInstance().getDanhBa().get(ketQua));
                }
                else System.out.println("Khong Tim Thay Ten Lien Lac\n\n\n");
            }
            if(choice==6){
                System.out.println("-------------------DOC TU FILE-------------------");
                System.out.println("Load file moi se xoa danh ba, ban co muon tiep tuc");
                System.out.println("1. yes");
                System.out.println("2. no");
                int nextchoice=input.nextInt();
                if(choice==1){
                    return;
                }
                System.out.println("NHAP DUONG DAN FILE: ");
                String tenFile=input.nextLine();
                DanhBa.getInstance().loadDanhBa(tenFile);
            }
        }
    }

    static void hienThiMenuSua(Scanner input){

        while(hoTen.equals("")) {
            System.out.println("Nhap Ho Ten");
            hoTen = input.nextLine();
            if(!hoTen.equals("")){
                break;
            }
            System.out.println("nhap Lai");
        }
        System.out.println("Nhap So Dien Thoai");
        soDienThoai=input.nextLine();
        System.out.println("Nhap Dia Chi");
        diaChi=input.nextLine();
        System.out.println("Nhap Email");
        email=input.nextLine();
    }
}
