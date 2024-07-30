package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.application.components.utils.Input;

public class DeleteCityAction extends BaseAction implements Action {

    @Override
    public void apply() {
        int id = Input.getInt("Введите Id");
        controller.deleteCity(id);
    }
}
