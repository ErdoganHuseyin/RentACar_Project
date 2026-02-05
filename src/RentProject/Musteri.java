package RentProject;

import java.util.ArrayList;

public class Musteri {
    private String adSoyad;
    private String tcKimlik;
    private String sifre;
    ArrayList<Arac> kiralananAraclar;

    public Musteri(String adSoyad,String tcKimlik,String sifre){
        this.adSoyad=adSoyad;
        this.tcKimlik=tcKimlik;
        this.sifre=sifre;
        this.kiralananAraclar = new ArrayList<>();
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    public String getSifre() {
        return sifre;
    }

    public void aracKirala(Arac a, int gun){
        System.out.println(a.getMarka()+a.getModel()+a.getPlaka()+"Aracimiz "+gun+" boyunca kiralanmistir Odencek Ucret: "+ a.ucretHesapla(gun));
        kiralananAraclar.add(a);
        a.setDurum(false);

    }
    public void aracTeslim(Arac a){
        System.out.println(a.getMarka()+a.getModel()+a.getPlaka()+"Aracimiz teslim edilmistir Bizi tercih ettiginiz icin tesekkur ederiz");
        kiralananAraclar.remove(a);
       a.setDurum(true);
    }

    public void kiraladiklarimiListele(){
    if(kiralananAraclar.isEmpty()){
        System.out.println("Listeniz bos");
    }else{
        System.out.println("---Elinizdeki Araclar---");
        for(Arac a : kiralananAraclar){
            System.out.println("--> " + a.getMarka() + a.getModel() + a.getPlaka());

        }


}
    }


}
