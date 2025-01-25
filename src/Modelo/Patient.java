package Modelo;

public class Patient extends Users {

    private String Diagnostic;
    private String Plan;
    private String birthdate;
    private String loginUser;
    private String password;

    public Patient(String plan, String birthdate, String loginUser, String password,String name, String email) {
        super(name, email);
        this.Plan = plan;
        this.birthdate = birthdate;
        this.loginUser = loginUser;
        this.password = password;

    }

    public String getDiagnostic() {
        return Diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        Diagnostic = diagnostic;
    }

    public String getPlan() {
        return Plan;
    }

    public void setPlan(String plan) {
        Plan = plan;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
