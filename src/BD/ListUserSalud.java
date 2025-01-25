package BD;

import Login.Login;
import Modelo.Patient;
import Modelo.UserSalud;
import Modelo.Users;

import java.util.ArrayList;
import java.util.List;

public class ListUserSalud  {

    List<UserSalud> listuserSaluds = new ArrayList<>();
    public ListUserSalud(){
        database();
    }

    void database(){
        this.addListUserSalud(new UserSalud("Camilo","cam@ejemplo.com","Dermatología","DOCUSER1","123","DOCTOR"));
        this.addListUserSalud(new UserSalud("Maria","mar@ejemplo.com","Psiquiatría","DOCUSER2","123","DOCTOR"));
        this.addListUserSalud(new UserSalud("Jose","joe@ejemplo.com","Neurología","DOCUSER3","123","DOCTOR"));
        this.addListUserSalud(new UserSalud("Ricardo","rich@ejemplo.com","Anestesiología","DOCUSER4","123","DOCTOR"));
        this.addListUserSalud(new UserSalud("Natalia","Nat@ejemplo.com","Dermatología","DOCUSER5","123","DOCTOR"));
        this.addListUserSalud(new UserSalud("Karen","kar@ejemplo.com","pediátricas","ENFUSER6","123","ENFERMERO"));
        this.addListUserSalud(new UserSalud("Rodrigo","rod@ejemplo.com","salud mental","ENFUSER7","123","ENFERMERO"));
        this.addListUserSalud(new UserSalud("Josefa","josf@ejemplo.com","urgencias","ENFUSER8","123","ENFERMERO"));
        this.addListUserSalud(new UserSalud("Johana","joh@ejemplo.com","geriátrica","ENFUSER9","123","ENFERMERO"));
        this.addListUserSalud(new UserSalud("Isabela","isa@ejemplo.com","obstétrico-ginecológica","ENFUSER10","123","ENFERMERO"));
    }

    public void addListUserSalud(UserSalud userSalud){
        listuserSaluds.add(userSalud);
    }
    public void userSaludALL(){
        for(UserSalud user : listuserSaluds){
            System.out.println("Nombre: " + user.getName() + ", Email: " + user.getEmail()+ ", Puesto: " + user.getPuesto());
        }
    }

    public List<UserSalud> getListuserSaluds(){
        return listuserSaluds;
    }


    public String user(String user){


        for (UserSalud userData : listuserSaluds) {

            if(userData.getLogin().equals(user)){
                return userData.getLogin();
            }

        }

        return "";
    }

    public String UserCorreo(String user){
        for (UserSalud userData : listuserSaluds) {
            if(userData.getLogin().equals(user)){
                return userData.getEmail();
            }
        }
        return "";
    }

    public String Tipo(String user){
        for (UserSalud userData : listuserSaluds) {
            if(userData.getLogin().equals(user)){
                return userData.getPuesto();
            }

        }

        return "";
    }


    public String pasword(String password){
        for (UserSalud userData : listuserSaluds) {
            if(userData.getPassword().equals(password)){
                return userData.getPassword();
            }

        }

        return "";
    }

}
