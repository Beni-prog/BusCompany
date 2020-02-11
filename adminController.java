package sample;

import Domain.Route;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")
public class adminController implements Observer {
    private ArrayList<String> adminBookingList;
    adminController(ArrayList<String>s){this.adminBookingList=s;}
    @FXML
    public ListView<String> adminList;
    public void initialize(){}
    @Override
    public void update(Observable o, Object arg) {
        //populate adminList
        this.adminList.getItems().clear();
        for (String r: adminBookingList)
        {
            adminList.getItems().add(r);
        }
    }
}
