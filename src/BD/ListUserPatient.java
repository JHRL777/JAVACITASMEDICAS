package BD;

import Modelo.Patient;

import java.util.ArrayList;
import java.util.List;

public class ListUserPatient {
    List<Patient> listaPatiente = new ArrayList<>();
     //para inciar los datos guardados en database()
    public ListUserPatient(){
        database();
    }

    void database() {

        this.addLista(new Patient("POS", "01/01/2020", "PAS_USAR1", "123", "Sofia", "sof@ejemplo.com"));
        this.addLista(new Patient("PAC", "01/01/2000", "PAS_USAR2", "123", "Pablo", "pab@ejemplo.com"));
        this.addLista(new Patient("POS", "01/01/2010", "PAS_USAR3", "123", "Juan", "jua@ejemplo.com"));
        this.addLista(new Patient("PAC", "01/01/2021", "PAS_USAR4", "123", "Erika", "erik@ejemplo.com"));
        this.addLista(new Patient("POS", "01/01/2011", "PAS_USAR5", "123", "Lina", "lin@ejemplo.com"));
        this.addLista(new Patient("POS", "01/01/2012", "PAS_USAR6", "123", "Wilfredo", "wlf@ejemplo.com"));
    }

    void addLista(Patient patient){
        listaPatiente.add(patient);
    }
   public String user(String user){
       for (Patient patient : listaPatiente) {
           if(patient.getLoginUser().equals(user)){
               return patient.getLoginUser();
           }

       }

       return "";
   }


    public String pasword(String password){

        for (Patient patient : listaPatiente) {
            if(patient.getPassword().equals(password)){
                return patient.getPassword();
            }

        }

        return "";
    }

    // Método para mostrar todos los pacientes
    public void mostrarPacientes() {
        for (Patient patient : listaPatiente) {
            System.out.println("Nombre: " + patient.getName() + ", Email: " + patient.getEmail());
        }
    }
}


