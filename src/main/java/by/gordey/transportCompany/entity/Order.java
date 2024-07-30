package by.gordey.transportCompany.entity;

public class Order {


    private String cityFrom;
    private String cityTo;
    private int numberOfPeople;
    private int cargoQuantity;
    private String speedestTransport;
    private int priceOfSpeedestTransport;
    private int timeOfSpeedestTransport;
    private String chiepestTransport;
    private int priceOfChiepestTransport;
    private int timeOfChiepestTransport;


    public Order() {
    }

    public Order(String cityFrom, String cityTo,
                 int numberOfPeople, int cargoQuantity,
                 String speedestTransport, int priceOfSpeedestTransport, int timeOfSpeedestTransport,
                 String chiepestTransport, int priceOfChiepestTransport, int timeOfChiepestTransport) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.numberOfPeople = numberOfPeople;
        this.cargoQuantity = cargoQuantity;
        this.speedestTransport = speedestTransport;
        this.priceOfSpeedestTransport = priceOfSpeedestTransport;
        this.timeOfSpeedestTransport = timeOfSpeedestTransport;
        this.chiepestTransport = chiepestTransport;
        this.priceOfChiepestTransport = priceOfChiepestTransport;
        this.timeOfChiepestTransport = timeOfChiepestTransport;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public void setCargoQuantity(int cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    public String getSpeedestTransport() {
        return speedestTransport;
    }

    public void setSpeedestTransport(String speedestTransport) {
        this.speedestTransport = speedestTransport;
    }

    public int getPriceOfSpeedestTransport() {
        return priceOfSpeedestTransport;
    }

    public void setPriceOfSpeedestTransport(int priceOfSpeedestTransport) {
        this.priceOfSpeedestTransport = priceOfSpeedestTransport;
    }

    public int getTimeOfSpeedestTransport() {
        return timeOfSpeedestTransport;
    }

    public void setTimeOfSpeedestTransport(int timeOfSpeedestTransport) {
        this.timeOfSpeedestTransport = timeOfSpeedestTransport;
    }

    public String getChiepestTransport() {
        return chiepestTransport;
    }

    public void setChiepestTransport(String chiepestTransport) {
        this.chiepestTransport = chiepestTransport;
    }

    public int getPriceOfChiepestTransport() {
        return priceOfChiepestTransport;
    }

    public void setPriceOfChiepestTransport(int priceOfChiepestTransport) {
        this.priceOfChiepestTransport = priceOfChiepestTransport;
    }

    public int getTimeOfChiepestTransport() {
        return timeOfChiepestTransport;
    }

    public void setTimeOfChiepestTransport(int timeOfChiepestTransport) {
        this.timeOfChiepestTransport = timeOfChiepestTransport;
    }

    @Override
    public String toString() {
        return "\nOrder{" + "cityFrom='" + cityFrom + '\'' + ", cityTo='" + cityTo + '\'' +
                ", numberOfPeople=" + numberOfPeople + ", cargoQuantity=" + cargoQuantity +
                "т, speedestTransport='" + speedestTransport + '\'' + ", priceOfSpeedestTransport=" + priceOfSpeedestTransport +
                "$, timeOfSpeedestTransport=" + timeOfSpeedestTransport + "часов, chiepestTransport='" + chiepestTransport +
                '\'' + ", priceOfChiepestTransport=" + priceOfChiepestTransport + "$, " +
                "timeOfChiepestTransport=" + timeOfChiepestTransport + "часов}'";
    }
}
