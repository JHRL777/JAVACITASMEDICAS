package Crud;

import BD.ListAppoinment;
import Crud.Interface.ICrud;
import Modelo.Appoinment;

import java.util.List;

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
        int estado = 0;
        for(Appoinment lususer : lista.getListAppoinment()){
            if(lususer.getId().equals(id)){
                lususer.setUserSalud(user);
                System.out.println("✅ Modificacion de doctor.\n");
                break;
            }else {
                estado = 1;
            }
        }
        if(estado == 1){
            System.out.println("❌ No se encontraton citas con el id: "+ id);
        }
    }

    @Override
    public void deleate(int id) {
        List<Appoinment> appoinments = lista.getListAppoinment(); // Obtener la lista

        boolean eliminado = appoinments.removeIf(app -> app.getId() == id); // Remover el elemento

        if (eliminado) {
            System.out.println("✅ Eliminado correctamente.");
        } else {
            System.out.println("❌ No se encontraron citas con el ID: " + id);
        }
    }
}
