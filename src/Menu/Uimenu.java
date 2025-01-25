package Menu;

import BD.ListAppoinment;
import Crud.CrudDoctor;
import Crud.CrudPatients;
import Modelo.Appoinment;

import java.util.Scanner;

public class Uimenu {

    private static Scanner sc = new Scanner(System.in);

    private  static  CrudDoctor  crudDoctor  = new CrudDoctor();
    private static CrudPatients crudPatients = new CrudPatients();
    public static   void MenuUsuarioSalud(String tipo, String user){



        System.out.println("Menu");
        System.out.println("Tipo de user: " + tipo);
        int estado = -1;
        do {

            if(tipo.equals("DOCTOR")){
                System.out.println("MENU DOCTOR");
                System.out.println("*************************");
                System.out.println("Selecione\n [1] Agendar\n [2] Mostrar citas\n [3] Mostrar mis citas\n  [4] Asignarme una cita ya creada por otro doctor \n [5] Cancelar cita \n [0] Salir");
                System.out.println("*************************");
                estado = Integer.parseInt(sc.nextLine());
                if(estado == 1) {
                    MenuAgendarCita(user);
                } else if (estado == 2) {
                    crudDoctor.ShowAll();
                } else if (estado == 3) {
                    crudDoctor.ShowUser(user);
                }else if (estado == 4) {
                    MenuActualizarCitaPatientDOC(user);
                }else if (estado == 5) {
                    MenuCancelarCitaPatientDOC();
                }

            } else if (tipo.equals("ENFERMERO")) {
                System.out.println("MENU ENFERMERO");
                System.out.println("*************************");
                System.out.println("Selecione\n [1] Ver mis citas\n[ 0] Salir");
                System.out.println("*************************");

                estado = Integer.parseInt(sc.nextLine());
                if(estado == 1) {
                    System.out.println("Total mis citas citas");
                    crudDoctor.ShowUser(user);
                }

            }

        }while(estado != 0);

    }

    public static  void MenuPatient(String user){
        System.out.println("Menu");
        int estado = 0;
        do {
            System.out.println("MENU PACIENMTE");
            System.out.println("*************************");
            System.out.println("Selecione\n [1] Agendar\n [2] MOSTRAR MIS CITAS \n [3] AGENDAR CITA\n [4] CANCELAR CITA \n[0] Salir");
            System.out.println("*************************");
            estado = Integer.parseInt(sc.nextLine());
            if(estado == 1){
                System.out.println("Agendar citas");
                MenuAgendarCitaPatient(user);
            } else if (estado == 2) {
                crudPatients.ShowUser(user);
            } else if (estado ==3) {
                MenuActualizarCitaPatient(user);
            }else if (estado ==4) {
                MenuCancelarCitaPatient(user);
            }

        }while (estado != 0);
    }

    public static void MenuAgendarCita(String user){
        System.out.println("MENU AGENDAR CITA");
        System.out.println("Anadir cita");
        System.out.println("Fecha formato [DD/MM/YYYY]");
        String fecha = sc.nextLine();
        System.out.println("Hora HH:MM");
        String hora = sc.nextLine();
        crudDoctor.addAppoiment(new Appoinment(fecha, hora, user));
        System.out.println("✅ Cita agregada correctamente.\n");
    }


    public static void MenuAgendarCitaPatient(String user){
        System.out.println("MENU AGENDAR CITA");
        System.out.println("Anadir cita");
        System.out.println("Fecha formato [DD/MM/YYYY]");
        String fecha = sc.nextLine();
        System.out.println("Hora HH:MM");
        String hora = sc.nextLine();
        System.out.println("Escriba uno de los siguientes docotores");
        crudPatients.ShowUserOnly();
        String doctor = sc.nextLine();


        crudPatients.addAppoiment(new Appoinment(fecha, hora,doctor, user));

        System.out.println("✅ Cita agregada correctamente.\n");
    }


    public static void MenuActualizarCitaPatient(String user){
        System.out.println("CITAS DISPONIBLES");
        crudPatients.ShowAll();
        System.out.println("SELECCIONAR CITA DISPONIBLE CON EL ID EJEMPLO 1 O 2 O 3...");
        int id = Integer.parseInt(sc.nextLine());
        crudPatients.update(id,user);
    }


    public static void MenuCancelarCitaPatient(String user){
        System.out.println("Cancelar cita");
        crudPatients.ShowUser(user);
        System.out.println("SELECCIONAR CITA DISPONIBLE CON EL ID EJEMPLO 1 O 2 O 3...");
        int id = Integer.parseInt(sc.nextLine());
        crudPatients.deleate(id);

    }

    public static void MenuActualizarCitaPatientDOC(String user){
        System.out.println("CITAS DISPONIBLES");
        crudDoctor.ShowAll();
        System.out.println("SELECCIONAR CITA DISPONIBLE CON EL ID EJEMPLO 1 O 2 O 3...");
        int id = Integer.parseInt(sc.nextLine());
        crudDoctor.update(id,user);
    }


    public static void MenuCancelarCitaPatientDOC(){
        System.out.println("Cancelar cita");
        crudDoctor.ShowAll();
        System.out.println("SELECCIONAR CITA DISPONIBLE CON EL ID EJEMPLO 1 O 2 O 3...");
        int id = Integer.parseInt(sc.nextLine());
        crudDoctor.deleate(id);

    }

}
