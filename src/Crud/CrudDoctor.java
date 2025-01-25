package Crud;

import BD.ListAppoinment;
import Crud.Interface.ICrud;
import Modelo.Appoinment;

public class CrudDoctor implements ICrud {

    ListAppoinment lista = ListAppoinment.getInstance();

    @Override
    public void ShowAll() {
        lista.ShowAll();
    }

    @Override
    public void ShowUser(String user) {

        lista.ShowUser(user);
    }

    @Override
    public void addAppoiment(Appoinment appoinment) {
        lista.addAppoimnet(appoinment);
    }

    @Override
    public void update(int id, String user){

    }

    @Override
    public void deleate(int id) {

    }
}
