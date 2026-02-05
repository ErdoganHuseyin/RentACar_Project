package RentProject;

public class SUV extends Arac {
    public SUV(String marka, String model, int gunlukUcret, String plaka) {
        super(marka, model, gunlukUcret, plaka);
    }
    @Override
    public int ucretHesapla(int gun){
        return (getGunlukUcret()*gun)+500;
    }
}
