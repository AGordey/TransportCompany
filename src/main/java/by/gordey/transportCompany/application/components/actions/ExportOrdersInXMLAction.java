package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.controller.LogisticController;
import by.gordey.transportCompany.controller.LogisticControllerImpl;
import by.gordey.transportCompany.entity.Order;
import by.gordey.transportCompany.entity.OrderWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class ExportOrdersInXMLAction extends Thread implements Action {

    @Override
    public void apply() {
        String name = Thread.currentThread().getName();
        System.out.println("Поток экспорта "+name);
        Thread thread = new Thread(this); // Создаем новый объект Thread с текущим экземпляром класса
        thread.start();

    }


    @Override
    public void run() {
        System.out.println("Заснул на 5 сек");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LogisticController controller = new LogisticControllerImpl();
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
