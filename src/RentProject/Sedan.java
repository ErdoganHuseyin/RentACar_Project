package RentProject;

public class Sedan extends Arac {
public Sedan(String marka,String model, int gunlukUcret,String plaka){
super(marka, model, gunlukUcret, plaka);
}

@Override
    public int ucretHesapla(int gun){
    int ucret;
    ucret =  getGunlukUcret() * gun;
    return ucret;
}
}