package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.entity.City;

public class UpdateCityAction extends BaseAction implements Action {
    @Override
    public void apply() {
        City city = createNewCity();
        controller.updateCity(city);

    }
}
