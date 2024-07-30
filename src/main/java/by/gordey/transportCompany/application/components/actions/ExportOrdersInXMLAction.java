package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.entity.Order;
import by.gordey.transportCompany.entity.OrderWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class ExportOrdersInXMLAction extends BaseAction implements Action {
    @Override
    public void apply() {
        List<Order> orders = controller.getOrders();
        OrderWrapper wrapper = new OrderWrapper(orders);
        try {
            JAXBContext context = JAXBContext.newInstance(OrderWrapper.class, Order.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File("src/main/java/by/gordey/transportCompany/orders.xml"));
            System.out.println("Выполнен экспорт в xml выполненных поисков \n");

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
