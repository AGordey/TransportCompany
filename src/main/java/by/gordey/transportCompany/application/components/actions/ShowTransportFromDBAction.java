package by.gordey.transportCompany.application.components.actions;

public class ShowTransportFromDBAction extends BaseAction implements Action {
    @Override
    public void apply() {
        System.out.println("Список транспорта из БД");
        controller.getTransports().forEach(System.out::println);
        System.out.println();//Посмотреть что выведет
    }
}
