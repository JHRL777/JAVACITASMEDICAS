package Crud.Interface;

import Modelo.Appoinment;

public interface ICrud {


    void ShowAll();
    void ShowUser(String user);
    void addAppoiment(Appoinment appoinment);
    void update(int id, String user);
    void deleate(int id);




}
