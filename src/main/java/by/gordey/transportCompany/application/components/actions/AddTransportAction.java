package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.entity.Transport;
import by.gordey.transportCompany.exceptions.DuplicateProductException;

public class AddTransportAction extends BaseAction implements Action{

    @Override
    public void apply() {
        Transport transport = createNewTransport();
        try {
            controller.addNewTransport(transport);
        } catch (DuplicateProductException e) {
            throw new RuntimeException(e);
        }
    }
}
