package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.application.function.Logistic;
import by.gordey.transportCompany.application.utils.Application;

public class LogisticModulAction implements Action{
    @Override
    public void apply() {
        new Logistic().logistic();
    }
}
