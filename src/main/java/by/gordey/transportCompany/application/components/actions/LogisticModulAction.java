package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.application.function.Logistic;

public class LogisticModulAction implements Action{
    @Override
    public void apply() {
        new Logistic().logistic();
    }
}
