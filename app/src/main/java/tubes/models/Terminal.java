package tubes.models;

public class Terminal {
    private String terminalID;
    private String namaTerminal;
    private boolean isInternational;
    private Staff staff;

    public Terminal(String terminalID, String namaTerminal, boolean isInternational, Staff staff) {
        this.terminalID = terminalID;
        this.namaTerminal = namaTerminal;
        this.isInternational = isInternational;
        this.staff = staff;
    }

    public String terminalID() {
        return this.terminalID;
    }

    public String namaTerminal() {
        return this.namaTerminal;
    }

    public boolean isInternational() {
        return this.isInternational;
    }

    public Staff getStaff() {
        return this.staff;
    }
}
