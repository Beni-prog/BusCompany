package Domain;

public class Route {
    private String SCity;
    private String DCity;
    private String ATime;
    private String DTime;
    private int NoOfSeats;
    private int ticketPrice;
    private int id;

    public Route(int id, String SCity, String DCity, String ATime, String DTime, int noOfSeats, int ticketPrice) {
        this.id=id;
        this.SCity = SCity;
        this.DCity = DCity;
        this.ATime = ATime;
        this.DTime = DTime;
        NoOfSeats = noOfSeats;
        this.ticketPrice = ticketPrice;
    }

    public String getSCity() {
        return SCity;
    }

    public void setSCity(String SCity) {
        this.SCity = SCity;
    }

    public String getDCity() {
        return DCity;
    }

    public void setDCity(String DCity) {
        this.DCity = DCity;
    }

    public String getATime() {
        return ATime;
    }

    public void setATime(String ATime) {
        this.ATime = ATime;
    }

    public String getDTime() {
        return DTime;
    }

    public void setDTime(String DTime) {
        this.DTime = DTime;
    }

    public int getNoOfSeats() {
        return NoOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        NoOfSeats = noOfSeats;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id+
                "-" + SCity +
                "-" + DCity +
                "-" + ATime +
                "-" + DTime +
                "-" + NoOfSeats +
                "-" + ticketPrice;
    }
}
