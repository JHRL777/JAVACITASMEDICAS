package Login;

import BD.ListUserPatient;
import BD.ListUserSalud;
import Menu.Uimenu;

import java.util.Scanner;

public class Login {
    private String tipo;



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static void ValieUser(){
        ListUserPatient loginpatien = new ListUserPatient();
        ListUserSalud   loginSalud = new ListUserSalud();
        Scanner sc = new Scanner(System.in);

        Integer opciones = -1;
        String user = "";
        String passWord = "";
        do {

            System.out.println("\n=============================");
            System.out.println("   Bienvenido al Sistema");
            System.out.println("=============================");
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("[1] Paciente");
            System.out.println("[2] Empleado");
            System.out.println("[0] Salir");
            System.out.print("Opción: ");

            try {
                opciones = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Ingrese un número válido.");
                continue;
            }

            if (opciones == 1) {

                inicioPatient(sc,opciones,loginpatien,user,passWord);

            } else if (opciones == 2) {

                inicioEmpleado(sc,opciones,loginSalud,user,passWord);

            } else if (opciones == 0) {
                System.out.println("Saliendo del Sistema 'Thanks''");
            } else {
                System.out.println("Opcion invalida porfavor ingresar una opcion valida [1] or [2]");
            }

        }while (opciones != 0);
        sc.close();
    }

    public static void inicioPatient(Scanner sc,Integer opciones,ListUserPatient  loginpatien, String user, String passWord) {

        System.out.println("Iniciar seccion como paciente");
        System.out.println("Login: ");

        user = sc.nextLine();
        System.out.println("passs: ");

        passWord = sc.nextLine();


        String userDat = loginpatien.user(user);
        String pasword = loginpatien.pasword(passWord);

            if (userDat.equals(user) && pasword.equals(passWord)) {
                System.out.println("-----------------------------");
                System.out.println("✅ Inicio de sesión exitoso.");
                System.out.println("****************************");
                System.out.println("👨‍👩‍👧‍👦 Usuario de inicio: "+user);
                System.out.println("****************************");
                Uimenu.MenuPatient(user);
                System.out.println("-----------------------------");
            }else {
                System.out.println("Valida tu usuario o contraseña");
            }

    }



    public static void inicioEmpleado(Scanner sc,Integer opciones,ListUserSalud  loginSalud, String user, String passWord){
        System.out.println("Iniciar seccion como EMPLEADO");
        System.out.println("Login: ");


        user = sc.nextLine();

        System.out.println("passs: ");

        passWord = sc.nextLine();

        String UserDataSALUD = loginSalud.user(user);
        String Tipo = loginSalud.Tipo(user);

        String paswordDataSALUD = loginSalud.pasword(passWord);

            if (UserDataSALUD.equals(user) && paswordDataSALUD.equals(passWord)) {
                System.out.println("-----------------------------");
                System.out.println("✅ Inicio de sesión exitoso.");
                System.out.println("****************************");
                System.out.println("🧑‍⚕️‍ Usuario de inicio: "+user);
                System.out.println("****************************");
                Uimenu.MenuUsuarioSalud(Tipo,UserDataSALUD);

                System.out.println("-------------------------");
            }

    }




}
