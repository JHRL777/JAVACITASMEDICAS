package Crud;

import BD.ListAppoinment;
import BD.ListUserSalud;
import Crud.Interface.ICrud;
import Modelo.Appoinment;
import Modelo.UserSalud;

import java.util.List;

public class CrudPatients implements ICrud {

    ListAppoinment lista = ListAppoinment.getInstance();
    ListUserSalud LisUser = new ListUserSalud();



    // mostrar citas disponibles
    @Override
    public void ShowAll() {

        lista.ShowAppoimentPatientFree();
    }

    @Override
    public void ShowUser(String user) {
            lista.ShowAppoimentPatient(user);
    }

    @Override
    public void addAppoiment(Appoinment appoinment) {
            lista.addAppoimnet(appoinment);
    }

    @Override
    public void update(int id, String user) {
        int estado = 0;
        for(Appoinment lususer : lista.getListAppoinment()){
           if(lususer.getId().equals(id)){
               lususer.setPatient(user);
               System.out.println("✅ Cita agregada correctamente.\n");
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


    //Mostrar solo los usuario para citas
    public void ShowUserOnly(){
        int i = 0;
      for(UserSalud user : LisUser.getListuserSaluds()) {
          System.out.println("["+i+"] "+user.getLogin());
          i++;
      }
    }
}
