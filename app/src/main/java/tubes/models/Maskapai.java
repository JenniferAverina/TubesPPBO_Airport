package tubes.models;

public class Maskapai {
    private String kodeMaskapai;
    private String namaMaskapai;

    public Maskapai(String kodeMaskapai, String namaMaskapai) {
        this.kodeMaskapai = kodeMaskapai;
        this.namaMaskapai = namaMaskapai;
    }

    public String getKodeMaskapai() {
        return this.kodeMaskapai;
    }

    public String getNamaMaskapai() {
        return this.namaMaskapai;
    }

    public String toString() {
        return this.kodeMaskapai + " - " + this.namaMaskapai;
    }
}
