package sample;

import Domain.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Parent root2 = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Client c1=new Client("Ion");
        Client c2=new Client("Vasile");
        ArrayList<Client> clients=new ArrayList<>();
        clients.add(c1);
        clients.add(c2);
        ArrayList<String> list=new ArrayList<>();


        //aici
        Controller ctrl1=new Controller(list);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setController(ctrl1);
        Parent root=loader.load();
        primaryStage.setTitle(clients.get(0).getName());
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();


        Stage s=new Stage();
        Controller ctrl2=new Controller(list);
        FXMLLoader loader1=new FXMLLoader(getClass().getResource("sample.fxml"));
        loader1.setController(ctrl2);
        Parent root1=loader1.load();
        s.setTitle(clients.get(1).getName());
        s.setScene(new Scene(root1,600,475));
        s.show();

        Stage admin=new Stage();
        adminController ctrl3=new adminController(list);
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("admin.fxml"));
        loader2.setController(ctrl3);
        Parent root3=loader2.load();
        admin.setTitle("Admin");
        admin.setScene(new Scene(root3,300,275));
        admin.show();

        ctrl1.addObserver(ctrl3);
        ctrl2.addObserver(ctrl3);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
