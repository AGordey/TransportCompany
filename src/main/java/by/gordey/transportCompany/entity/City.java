package by.gordey.transportCompany.entity;

public class City {
    private int id;
    private String name;
    private double latitude; // широта
    private double longitude; //долгота
    private boolean hasAirport;
    private boolean hasSeaport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isHasAirport() {
        return hasAirport;
    }

    public void setHasAirport(boolean hasAirport) {
        this.hasAirport = hasAirport;
    }

    public boolean isHasSeaport() {
        return hasSeaport;
    }

    public void setHasSeaport(boolean hasSeaport) {
        this.hasSeaport = hasSeaport;
    }

    public City() {
    }

    public City(int id, String name, double latitude,
                double longitude, boolean hasAirport,
                boolean hasSeaport) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hasAirport = hasAirport;
        this.hasSeaport = hasSeaport;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", hasAirport=" + hasAirport +
                ", hasSeaport=" + hasSeaport +
                '}';
    }

}
