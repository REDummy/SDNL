package USIP2;

import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        //Deklarasi variable
        int jMakan, jLauk, jMinum, nSayur, makan, minum;

        //Simpan nilai ke variable
        nSayur = 8000;
        makan = 300;
        minum = 2000;

        //buat object sacnner untuk
        Scanner sc = new Scanner(System.in)
                ;
        //baca input jumlah
        System.out.print("jMakan");
        jMakan = sc.nextInt();
        System.out.print("jLauk");
        jLauk = sc.nextInt();
        System.out.print("jMinum");
        jMinum= sc.nextInt();

        //hitung total berdasarkan jumlah dan harga
        int total =(jMakan*nSayur)+(jLauk*makan)+(jMinum*minum);


        //cetak total
        System.out.println("Total =" + total );


        double discount, hargaAwal, hargaAkhir;
        hargaAwal= 100000;
        discount = 0.2;
        hargaAkhir = hargaAwal*(1-discount);




    }
}
