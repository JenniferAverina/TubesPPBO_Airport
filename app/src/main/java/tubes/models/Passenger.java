package tubes.models;

import tubes.models.enums.JenisKelamin;
import tubes.models.enums.SpecialNeeds;

public class Passenger extends User{
    private SpecialNeeds specialNeeds;
    private Passport passport;
    public Passenger(SpecialNeeds specialNeeds, String nik, String nama, String tempatLahir, String tanggalLahir, String email, String password, JenisKelamin jenisKelamin) {
        super(nik, nama, tempatLahir, tanggalLahir, email, password, jenisKelamin);
        this.specialNeeds = SpecialNeeds.NONE;
    }

    public SpecialNeeds getSpecialNeeds() {
        return this.specialNeeds;
    }

    public void setSpecialNeeds(SpecialNeeds specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public Passport getPassport() {
        return this.passport;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "specialNeeds=" + specialNeeds +
                '}';
    }
}
