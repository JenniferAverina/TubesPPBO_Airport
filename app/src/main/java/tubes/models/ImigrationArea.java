package tubes.models;

import java.util.ArrayList;
import java.util.List;

public class ImigrationArea {
    private String imigrationID;
    private List<Passenger> listPenumpang;
    private Staff staff;
    private List<Items> confiscatedItems;

    public ImigrationArea(String imigrationID, Staff staff) {
        this.imigrationID = imigrationID;
        this.staff = staff;
        this.listPenumpang = new ArrayList<>();
        this.confiscatedItems = new ArrayList<>();
    }

    public String getImigrationID() {
        return imigrationID;
    }

    public Staff getStaff() {
        return staff;
    }

    // List Penumpang
    public List<Passenger> getListPenumpang() {
        return listPenumpang;
    }
    public void addPenumpang(Passenger penumpang) {
        this.listPenumpang.add(penumpang);
    }

    // List Items
    public List<Items> getConfiscatedItems() {
        return confiscatedItems;
    }
    public void addItems(Items items) {
        this.confiscatedItems.add(items);
    }

}
