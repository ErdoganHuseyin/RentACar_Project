package RentProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OtoGaleri implements IDatabaseIslemleri {
    ArrayList<Arac> arabalar;
    ArrayList<Musteri> musteriler;
    public OtoGaleri(){
        this.arabalar=new ArrayList<>();
        this.musteriler=new ArrayList<>();
    }

    public void AracEkle(Arac a){
        arabalar.add(a);
    }

    public void UyeKayit(Musteri m){
        musteriler.add(m);
    }
    public Musteri GirisYap(String tc,String sifre){
        for(Musteri m : musteriler){
            if(m.getTcKimlik().equals(tc) && m.getSifre().equals(sifre)){
                return m;
            }
        }
        return  null;
    }
    public Arac ArabaBul(String plaka){
        for(Arac a : arabalar ){
            if(a.getPlaka().equalsIgnoreCase(plaka)){
                return a;
            }

        }
        return null;

    }

    @Override
    public void verikaydet() {
try{

    BufferedWriter yazici = new BufferedWriter(new FileWriter ("KiralamaKayitlari.txt",true));

    for(Arac a : arabalar){
        if(!a.isDurum()){
            String kayit ="Kiralanan: " + a.getMarka() +" " + a.getModel() +" -Plaka:  "+ a.getPlaka();
        yazici.write(kayit);
        yazici.newLine();
        }
    }
yazici.close();
    System.out.println("Veriler Kaydedildi");
}catch (IOException e){
    System.out.println("Dosya hatası: " + e.getMessage());
}

}

    @Override
    public void verioku() {

        System.out.println("Okuma özelliği yakında eklenecek...");
    }

public void araclariListele(){
    System.out.println("\n--- GALERIDEKI ARACLAR ---");
        for(Arac a : arabalar){
            String durumEtiketi = (a.isDurum() == true) ? "[MÜSAİT]" : "[KİRADA]";
            System.out.println(durumEtiketi + " Plaka: " + a.getPlaka() + " | " + a.getMarka() + " " + a.getModel() + " | Gunluk: " + a.getGunlukUcret() + " TL");

        }
    System.out.println("--------------------------\n");
}
}
