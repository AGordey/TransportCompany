package by.gordey.transportCompany.entity;

public class Transport {
    private int id;
    private String transport_name;
    private int speed;
    private int capacityOfPeople;
    private int capacityOfWeigh;
    private int costOfKilometer;
    private TypeTransport typeTransport;


    public Transport() {
    }

    public Transport(int id, String transport_name, int speed,
                     int capacityOfPeople, int capacityOfWeigh,
                     int costOfKilometer, TypeTransport typeTransport) {
        this.id = id;
        this.transport_name = transport_name;
        this.speed = speed;
        this.capacityOfPeople = capacityOfPeople;
        this.capacityOfWeigh = capacityOfWeigh;
        this.costOfKilometer = costOfKilometer;
        this.typeTransport = typeTransport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransport_name() {
        return transport_name;
    }

    public void setTransport_name(String transport_name) {
        this.transport_name = transport_name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCapacityOfPeople() {
        return capacityOfPeople;
    }

    public void setCapacityOfPeople(int capacityOfPeople) {
        this.capacityOfPeople = capacityOfPeople;
    }

    public int getCapacityOfWeigh() {
        return capacityOfWeigh;
    }

    public void setCapacityOfWeigh(int capacityOfWeigh) {
        this.capacityOfWeigh = capacityOfWeigh;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    public int getCostOfKilometer() {
        return costOfKilometer;
    }

    public void setCostOfKilometer(int costOfKilometer) {
        this.costOfKilometer = costOfKilometer;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + transport_name + '\'' +
                ", speed=" + speed +
                ", capacityOfPeople=" + capacityOfPeople +
                ", capacityOfWeigh=" + capacityOfWeigh +
                ", typeTransport=" + typeTransport +
                ", costOfKilometer=" + costOfKilometer +
                '}';
    }
}
