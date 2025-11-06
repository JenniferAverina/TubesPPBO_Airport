package tubes.models;

import tubes.models.enums.ProhibitedItems;

public class Items {
    private String namaBarang;
    private ProhibitedItems reason; 
    private int ammount;

    public Items(String namaBarang, ProhibitedItems reason, int ammount) {
        this.namaBarang = namaBarang;
        this.reason = reason;
        this.ammount = ammount;
    }

    public String getNamaBarang() {
        return this.namaBarang;
    }

    public ProhibitedItems getReason() {
        return this.reason;
    }

    public int getAmmount() {
        return this.ammount;
    }
}
