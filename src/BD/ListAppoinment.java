package BD;

import Modelo.Appoinment;

import java.util.ArrayList;
import java.util.List;

public class ListAppoinment {
    private static ListAppoinment instancia;
    private List<Appoinment> listappinment = new ArrayList<>();
    private   int inicio= 0;


    public ListAppoinment() {
        if (listappinment.isEmpty()) { // Solo inicializa si está vacía
            dataBaseAppoimnet();
        }

    }

    public static ListAppoinment getInstance() {
        if (instancia == null) {
            instancia = new ListAppoinment();
        }
        return instancia;
    }





    public List<Appoinment> getListAppoinment() {
        return listappinment;
    }

    void dataBaseAppoimnet() {
        addAppoimnet(new Appoinment("22/01/2025","11:00","DOCUSER5"));
        addAppoimnet(new Appoinment("23/01/2025","13:00","DOCUSER2"));
        addAppoimnet(new Appoinment("24/01/2025","16:00","DOCUSER4"));
        addAppoimnet(new Appoinment("24/01/2025","16:00","DOCUSER4"));
        addAppoimnet(new Appoinment("27/01/2025","16:00","ENFUSER6","PAS_USAR1"));
        addAppoimnet(new Appoinment("28/01/2025","16:00","ENFUSER7","PAS_USAR1"));
        addAppoimnet(new Appoinment("27/01/2025","16:00","ENFUSER9","PAS_USAR1"));
        addAppoimnet(new Appoinment("28/01/2025","16:00","ENFUSER6","PAS_USAR1"));
    }


    public void addAppoimnet(Appoinment appoinment) {
        if (appoinment.getUserSalud() != null && appoinment.getDate() != null) {
            this.listappinment.add(appoinment);

        } else {
            System.out.println("No ha ingresado datos.");
        }

    }

    public void setPatient(String patient){

    }

    public void ShowAll(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("TODA LAS CITAS PRGRAMADAS");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Appoinment app : listappinment){

            System.out.println(( app.getPatient().equals("Sin Asignar")  ? "⚠️" : "✅") +"[" + app.getId() + "]" + " Mis citas son con el doctor o enferemra: " + app.getUserSalud() + " | Fecha: " +app.getDate() + " | "  +   "Dia: " + app.getDayFromDate() + " | " + "Hora: " + app.getHours()+ " | Paciene: "  + app.getPatient());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }


    public void ShowUser(String user){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("🧑‍⚕️ MIS CITAS");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Appoinment app : listappinment){
            if(app.getUserSalud().equals(user)) {
                System.out.println(" ");
                System.out.println("[" + app.getId() + "]" + " Mis citas son con el doctor o enferemra: " + app.getUserSalud() + " | Fecha: " +app.getDate() + " | "  +   "Dia: " + app.getDayFromDate() + " | " + "Hora: " + app.getHours()+ " | Paciene: "  + app.getPatient());
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }


    public void ShowAppoimentPatient(String user) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("👨‍👩‍👧‍👦 MIS CITAS");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Appoinment app : listappinment) {
            if (app.getPatient().equals(user)) {
                System.out.println(" ");
                System.out.println("[" + app.getId() + "]" + " Mis citas son con el doctor o enferemra: " + app.getUserSalud() + " | " + app.getDate() + " | Fecha:  " + "Dia: " + app.getDayFromDate() + " | " + "Hora: " + app.getHours() + " | Paciene: " + app.getPatient());
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }

    }

        public void ShowAppoimentPatientFree(){
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Citas disponibles");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Appoinment app : listappinment){
                if(app.getPatient().equals("Sin Asignar")) {
                    System.out.println(" ");
                    System.out.println("✅  [" + app.getId() + "]" + " Citas Disponibles: " + app.getUserSalud() + " | " +app.getDate() + " | Fecha:  "  +   "Dia: " + app.getDayFromDate() + " | " + "Hora: " + app.getHours()+ " | Paciene: "  + app.getPatient());
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            }
    }



}
