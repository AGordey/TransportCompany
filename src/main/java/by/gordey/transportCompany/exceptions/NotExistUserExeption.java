package by.gordey.transportCompany.exceptions;

public class NotExistUserExeption extends RuntimeException{
    @Override
    public String toString() {
        return "Такого пользователя нету в БД. Зарегистрируйся и перезапусти программу";
    }

    public void closeApp () {
        throw new StopApplicationException();
    }
}
