package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.exceptions.DuplicateProductException;

public class AddCityAction extends BaseAction implements Action {

    @Override
    public void apply() {
        City city = createNewCity();
        try {
            controller.addNewCity(city);
        } catch (DuplicateProductException e) {
            throw new RuntimeException(e);
        }
    }
}
