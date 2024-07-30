package by.gordey.transportCompany.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
//TODO Сделать отдельным потоком Thread
@XmlRootElement (name="orders")
public class OrderWrapper {
    List<Order> orders;

    public OrderWrapper() {
    }

    public OrderWrapper(List<Order> orders) {
        this.orders = orders;
    }

    @XmlElement(name = "order")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}

