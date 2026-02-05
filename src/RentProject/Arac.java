package RentProject;

public abstract class Arac {
    private String plaka;
    private String marka;
    private String model;
    private int gunlukUcret;
    private boolean durum;
    public Arac(String marka,String model,int gunlukUcret,String plaka){
        this.marka=marka;
        this.model=model;
        this.gunlukUcret=gunlukUcret;
        this.plaka=plaka;
        this.durum=true;
    }
    public String getMarka(){
        return marka;
    }
    public String getModel(){
        return model;
    }

    public int getGunlukUcret() {
        return gunlukUcret;
    }

    public String getPlaka() {
        return plaka;
    }

    public boolean isDurum() {
        return durum;
    }

    public void setDurum(boolean durum) {
        this.durum = durum;
    }

    public abstract int ucretHesapla(int gun);
}
