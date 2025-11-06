package tubes.models;

public class ParkingArea {
    private String parkingID;
    private double width;
    private double length;
    private Terminal terminal;
    private Staff staff;
    // private RequestedPlane plane;

    public ParkingArea(String parkingID, double width, double length, Terminal terminal, Staff staff) {
        this.parkingID = parkingID;
        this.width = width;
        this.length = length;
        this.terminal = terminal;
        this.staff = staff;
    }
}
