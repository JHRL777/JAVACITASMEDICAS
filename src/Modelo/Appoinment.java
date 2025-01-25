package Modelo;

import BD.ListUserPatient;
import BD.ListUserSalud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class Appoinment {
    private static Integer contador = 1;
    private  Integer id;
    private String date;
    private final String[]  day =  {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES"};
    private String hours;
    private String userSalud;
    private String patient;
    private ListUserSalud listaUser = new ListUserSalud();
    private ListUserPatient listPatien = new ListUserPatient();


    public Appoinment(String date, String hours, String userSalud) {
        this.id = contador++;
        this.date = date;
        this.hours = hours;
        this.setUserSalud(userSalud);
        this.patient = "Sin Asignar";
    }

    public Appoinment(String date, String hours, String userSalud, String patient) {
        this.id = contador++;
        this.date = date;
        this.hours = hours;
        this.setUserSalud(userSalud);
        this.setPatient(patient);
    }







    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // OPTENER EL FORMATO DE LA HORA
    public String getDayFromDate() {
        // Convertir la fecha en un objeto LocalDate

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(this.date, formatter);



        // Obtener el día de la semana en mayúsculas
        String dayOfWeek = localDate.getDayOfWeek()
                .getDisplayName(java.time.format.TextStyle.FULL, new Locale("es", "CO"))
                .toUpperCase();

        // Validar si el día está permitido en el array
        if (Arrays.asList(day).contains(dayOfWeek)) {
            return dayOfWeek; // Retorna el día si es válido
        } else {
            return "ERROR: El día seleccionado no está permitido."; // Mensaje si no es un día válido
        }
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getUserSalud() {
        return userSalud;
    }
    // OBTENER EL USUARIO DEL DOCTOR
    public void setUserSalud(String user) {
        if(user != null){

            this.userSalud =   this.listaUser.user(user); //error

        }else {
            System.out.println("No selecciono doctor");
        }

    }

    public String getPatient() {
        return patient;
    }

    // OBTENER EL USUARIO DEL PACIENTE
    public void setPatient(String patient) {
        if(patient != null){
            this.patient = listPatien.user(patient);
        }else {
            System.out.println("Debe ingresar un paciente");
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
