import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhBa {
    private static ArrayList<LienLac> danhBa=new ArrayList<>();
    private static final DanhBa instance=new DanhBa();

    public static DanhBa getInstance(){
        return instance;
    }

    public ArrayList<LienLac> getDanhBa(){
        return danhBa;
    }

    private DanhBa(){
        danhBa.add(new LienLac("tung","0944075003","Ha Noi","phamtung.0218@gmai.com"));
    }

    public String hienThiDanhBa(){
        Scanner input=new Scanner(System.in);
        StringBuffer danhSach=new StringBuffer("");
        for(LienLac lienlac:danhBa){
            System.out.println(lienlac.toString());
            String next=input.nextLine();
        }
        return danhSach.toString();
    }

    public String inDanhba(){
        StringBuffer danhSach=new StringBuffer("");
        for(LienLac lienlac:danhBa){
            System.out.println(lienlac.toString());
        }
        System.out.println("-------------------DANH BA-------------------");
        System.out.println(danhSach.toString());
        return danhSach.toString();
    }

    public void add(String hoTen,String SDT,String diaChi,String email){
        danhBa.add(new LienLac(hoTen,SDT,diaChi,email));
        inDanhba();
    }
    public int find(String soDienThoai){
        for(LienLac timkiem:danhBa){
            if(timkiem.getSoDienThoai().equals(soDienThoai)){
                return danhBa.indexOf(timkiem);
            }
        }
        return -1;
    }

    public void amend(int index,String hoTen,String SDT,String diaChi,String email){
        danhBa.get(index).setHoTen(hoTen);
        danhBa.get(index).setSoDienThoai(SDT);
        danhBa.get(index).setDiaChi(diaChi);
        danhBa.get(index).setEmail(email);
        inDanhba();
    }
    public void delete(int index){
        danhBa.remove(index);
    }


    public  ArrayList<LienLac> loadDanhBa(String Path) {
        ArrayList<LienLac> list=new ArrayList<>();
        File FileLuu=new File(Path);
        FileReader reader = null;
        try {
            reader = new FileReader(FileLuu);
        }catch (FileNotFoundException e){
            try {
                FileLuu.createNewFile();
            }catch (IOException e2){
                System.out.println("Loi");
            }
        }
        StringBuffer data=new StringBuffer("");
        try {int a=-1;
            while((a=reader.read())!=-1) {
                data.append((char) a);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] newdata=data.toString().split("\n");
        if(newdata.length>1) {
            for (int i = 0; i < newdata.length; i++) {
                String[] tempstr = newdata[i].split(",");
                list.add(new LienLac(tempstr[0], tempstr[1], tempstr[2],tempstr[3]));
            }
        }
        danhBa.clear();
        danhBa.addAll(list);
        return list;
    }
    public static void WriteFile(String path) throws IOException {
        File file=new File(path);
        FileWriter writer=new FileWriter(file);
        for(LienLac lienLac:danhBa) {
            try {
                writer.write(lienLac.getHoTen()+","+lienLac.getSoDienThoai()+","+lienLac.getDiaChi()+","+lienLac.getEmail()+"\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("loi");
            }
        }
        try {
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("loi");
        }
    }

}
