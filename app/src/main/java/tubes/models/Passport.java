package tubes.models;

import java.util.ArrayList;

public class Passport {
    private String passportID;
    private String nationality;
    private ArrayList<Departure> listPenerbangan;

    public Passport(String passportID, String nationality) {
        this.passportID = passportID;
        this.nationality = nationality;
        this.listPenerbangan = new ArrayList<>();
    }

    public String getPassportID() {
        return this.passportID;
    }

    public String getNationality() {
        return this.nationality;
    }

    public ArrayList<Departure> getListPenerbangan() {
        return this.listPenerbangan;
    }

    public void addNewPenerbangan(Departure inputDeparture) {
        this.listPenerbangan.add(inputDeparture);
    }
}
