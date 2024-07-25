package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.exceptions.StopApplicationException;

public class StopApplicationAction implements Action {
    @Override
    public void apply() {
        throw new StopApplicationException();
    }
}
