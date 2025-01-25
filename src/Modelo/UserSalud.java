package Modelo;

public class UserSalud extends Users{

    private String especiarity;
    private String Login;
    private String password;
    private String Puesto;

    public UserSalud(String name, String email, String especiarity, String login, String password, String puesto) {
        super(name, email);
        this.especiarity = especiarity;
        this.Login = login;
        this.password = password;
        this.Puesto = puesto;
    }

    public String getEspeciarity() {
        return especiarity;
    }

    public void setEspeciarity(String especiarity) {
        this.especiarity = especiarity;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String puesto) {
        Puesto = puesto;
    }

}
