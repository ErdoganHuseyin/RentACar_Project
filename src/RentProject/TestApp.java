package RentProject;

import java.util.Scanner;
public class TestApp {
    static   Scanner scanner = new Scanner(System.in);
    static OtoGaleri galeri = new OtoGaleri();


    public static void main(String[] args){


        galeri.AracEkle(new Sedan("Toyota", "Corolla", 1200, "34 ABC 123"));
        galeri.AracEkle(new SUV("Range Rover", "Sport", 3500, "06 SUV 999"));
        galeri.AracEkle(new Sedan("Renault", "Megane", 1000, "35 RNT 35"));
        galeri.AracEkle(new SUV("Volvo", "XC90", 4000, "07 VLV 07"));



        while(true){
            System.out.println("=========================================");
            System.out.println("   🚗  RENT A CAR SİSTEMİNE HOŞGELDİNİZ  🚗");
            System.out.println("=========================================");

            System.out.println("1 - Giris Yap");
            System.out.println("2 - Kayıt Ol");
            System.out.println("0 - Cıkıs Yap");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();


            if (secim == 0) {
        System.out.println("sistemden cikis yapiliyor");
            galeri.verikaydet();
            break;
            }
            else if(secim == 1){
                System.out.println("Giris ekranina yonlendiriliyosunuz");
            girisEkrani();
            }
            else if(secim == 2){
                System.out.println("Kayit ekranina yonlendiriliyosunuz");
                kayitEkrani();
            }

        }




        System.out.println("\nProgram Sonlandı. İyi günler!");
        scanner.close();


    }
    public static void kayitEkrani(){
        System.out.println("\n--- YENİ ÜYE KAYDI ---");
        System.out.print("Adınız Soyadınız: ");
        String ad = scanner.nextLine();

        System.out.print("TC Kimlik No Belirleyin: ");
        String yeniTc = scanner.nextLine();

        System.out.print("Şifre Belirleyin: ");
        String yeniSifre = scanner.nextLine();


        Musteri yeniMusteri = new Musteri(ad, yeniTc, yeniSifre);
        galeri.UyeKayit(yeniMusteri);

        System.out.println("Kayıt Başarılı! Giriş ekranına yönlendiriliyorsunuz...\n");
    }

    public static void girisEkrani(){

        System.out.println("--- GİRİŞ EKRANI ---");
        System.out.print("TC Kimlik No: ");
        String tc = scanner.nextLine();

        System.out.print("Şifre: ");
        String sifre = scanner.nextLine();


        Musteri m = galeri.GirisYap(tc, sifre);

        if (m != null) {
            System.out.println("\nHoşgeldin Sayın " + m.getAdSoyad());
            musteriPaneli(m);
        } else {
            System.out.println("Hatalı giriş!");
        }

    }
    public static void devamEtmekIcinBekle(){
        System.out.println("\n(Devam etmek icin ENTER tusuna basin...)");
        scanner.nextLine();
    }


    public static void musteriPaneli(Musteri musteri){
        while(true){
            System.out.println("\n--- MÜŞTERİ PANELİ ---");
            System.out.println("1- Araçları Listele");
            System.out.println("2- Araç Kirala");
            System.out.println("3- Kiraladıklarım");
            System.out.println("4- Araç İade Et (YENİ)");
            System.out.println("0- Çıkış");
            System.out.print("Seçim: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            if(secim == 1){
                galeri.araclariListele();
                devamEtmekIcinBekle();

            }
            else if(secim == 2){
                System.out.println("Kiralamak istediginiz aracin plakasini giriniz");
                String plaka = scanner.nextLine();
                Arac a = galeri.ArabaBul(plaka);
                if(a != null){
                    System.out.println("Sectiginiz araci kac gun kiraliyacaksiniz? ");
                    int gun = scanner.nextInt();
                    scanner.nextLine();
                    musteri.aracKirala(a , gun);

                }else{
                    System.out.println("Arac bulunamadi");
                }
                devamEtmekIcinBekle();
            }
            else if(secim == 3){
                musteri.kiraladiklarimiListele();
                devamEtmekIcinBekle();
            }
            else if(secim == 4){
                System.out.print("Teslim edeceginiz aracin plakasi: ");
                String plaka = scanner.nextLine();
                Arac a = galeri.ArabaBul(plaka);
                if(a != null ){
                    musteri.aracTeslim(a);
                }else{
                    System.out.println("Hatali islem");
                }
                devamEtmekIcinBekle();


            }
            else if(secim == 0){
          break;
            }

        }



    }


    }


