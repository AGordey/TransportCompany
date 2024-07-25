package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.application.utils.Input;

public class DeleteTransportAction extends BaseAction implements Action{
    @Override
    public void apply() {
        int id = Input.getInt("Введи id транспорта который хочешь удалить");
        controller.deleteTransport(id);
    }
}
