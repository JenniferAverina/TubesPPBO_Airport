package tubes.models;

import java.time.LocalDateTime;

import tubes.models.enums.CategoryTicket;

public class Ticket {
    private String ticketID;
    private String destination;
    private String origin;
    private String flightNumber;
    private String seatNumber;
    private String maskapai;
    private double price;
    private CategoryTicket category;
    private LocalDateTime dateTimeOrigin;
    private LocalDateTime dateTimeDestination;

    public Ticket(String ticketID, String destination, String origin, String flightNumber, LocalDateTime dateTimeOrigin, LocalDateTime dateTimeDestination, String seatNumber, String maskapai, double price, CategoryTicket category) {
        this.ticketID = ticketID;
        this.destination = destination;
        this.origin = origin;
        this.flightNumber = flightNumber;
        this.dateTimeOrigin = dateTimeOrigin;
        this.dateTimeDestination = dateTimeDestination;
        this.seatNumber = seatNumber;
        this.maskapai = maskapai;
        this.price = price;
        this.category = category;
    }

    public String getTicketID() {
        return this.ticketID;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public LocalDateTime getDateTimeOrigin() {
        return this.dateTimeOrigin;
    }

    public LocalDateTime getDateTimeDestination() {
        return this.dateTimeDestination;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public String getMaskapai() {
        return this.maskapai;
    }

    public double getPrice() {
        return this.price;
    }

    public CategoryTicket getCategory() {
        return this.category;
    }
}
