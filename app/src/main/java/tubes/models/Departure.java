package tubes.models;

import tubes.models.enums.ArrivalStatus;

public class Departure {
    private String kodeBandaraTujuan;
    private String kodeBandaraAsal;
    private ArrivalStatus status;
    private Ticket ticket;

    public Departure(String kodeBandaraTujuan, String kodeBandaraAsal, ArrivalStatus status) {
        this.kodeBandaraTujuan = kodeBandaraTujuan;
        this.kodeBandaraAsal = kodeBandaraAsal;
        this.status = status;
    }
}
