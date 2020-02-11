package sample;

import Domain.Route;
import Repository.RouteFileRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")
public class Controller extends Observable {
    private ArrayList<String> bookingList;

    Controller(ArrayList<String> s){this.bookingList=s;}
    @FXML
    private ListView<String> sourceList;

    @FXML
    private ListView<String> destinationList;
    @FXML
    private ListView<Route> routesList;

    @FXML
    private Button chooseButton;

    @FXML
    private TextField ticketNoText;

    @FXML
    private TextField totalPriceText;
    @FXML
    static ListView<String> adminList;

    @FXML
    private Button bookB;
    ObservableList<String> sourceCities = FXCollections.observableArrayList();
    ObservableList<String> destCities = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        this.sourceCities.setAll("Paris", "Hungary", "Italy", "Lisbon", "Berlin", "Luxembourg");
        this.destCities.setAll("Madrid", "Bucharest", "Cluj", "Dublin");
        this.sourceList.setItems(this.sourceCities);
        this.destinationList.setItems(this.destCities);
    }
    public String name;
    @FXML
    private void chooseBF(ActionEvent actionEvent) {
         name=sourceList.getSelectionModel().getSelectedItem();
        if(name!=null){
            updateDestList();
        }
    }
    RouteFileRepository repo=new RouteFileRepository("C:\\Users\\Smart_Slim\\IdeaProjects\\modelMAPpractic\\src\\routes.txt");
    ArrayList<Route> routes=repo.getRoutes();
    public void updateDestList()
    {
        ObservableList<String>  newDCities = FXCollections.observableArrayList();
        for (Route route : routes) {
            if (route.getSCity().equals(name)) {
                newDCities.add(route.getDCity());
            }
        }
        this.destinationList.setItems(newDCities);
    }
    @FXML
    private void chooseRBF(ActionEvent actionEvent) {
        String name1=destinationList.getSelectionModel().getSelectedItem();
        if(name1!=null){
            showRoutes(name1);
        }
    }
    public void showRoutes(String name1){
        ObservableList<Route> routesL=FXCollections.observableArrayList();
        for(int i=0;i<routes.size();i++)
        {
            if(routes.get(i).getDCity().equals(name1)&&routes.get(i).getSCity().equals(name))
            {
                routesL.add(routes.get(i));
            }
            routesList.setItems(routesL);
        }
    }

    @FXML
    public void bookBF(ActionEvent actionEvent) {
        Route myRoute=routesList.getSelectionModel().getSelectedItem();
        int price=Integer.parseInt(ticketNoText.getText())*myRoute.getTicketPrice();
        String p=price+"$";
        this.totalPriceText.setText(p);
        bookingList.add(myRoute.toString());

        myRoute.setNoOfSeats(myRoute.getNoOfSeats()-Integer.parseInt(ticketNoText.getText()));

        setChanged();
        notifyObservers();
    }
}
