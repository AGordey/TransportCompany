package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.entity.Transport;

public class UpdateTransportAction extends BaseAction implements Action{
    @Override
    public void apply() {
        Transport transport = createNewTransport();
        controller.updateTransport(transport);
    }
}
