package sample;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import static sample.MyGymManager.dbCollection;

public class Tableview extends Application {

    DBObject list = null;
    DBCursor cursor = dbCollection.find();

    public static final String column1 = "1";
    public static final String column2 = "2";
    public static final String column3 = "3";

    Stage window;

    TableView tableView = new TableView(showList());
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Gym Members");

        VBox vBox = new VBox();
        vBox.getChildren().addAll();

        HBox hBox = new HBox();

        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Table View Sample");
        primaryStage.setWidth(880);
        primaryStage.setHeight(700);

        //Title
        final Label label = new Label("Gym Members");
        label.setStyle("-fx-font-style: inherit");
        label.setFont(new Font("Arial", 36));


        //setting up the widths for columns
        TableColumn<Map, String> memberName = new TableColumn("Member Name");
        memberName.setMinWidth(250);
        memberName.setCellValueFactory(new MapValueFactory<>(column1));
        TableColumn<Map, String> memberNo = new TableColumn("Member No");
        memberNo.setMinWidth(250);
        memberNo.setCellValueFactory(new MapValueFactory<>(column2));
        TableColumn<Map, String> memberCato = new TableColumn("Member Category");
        memberCato.setMinWidth(250);
        memberCato.setCellValueFactory(new MapValueFactory<>(column3));

        //creating and formatting the table
        tableView.setEditable(true);
        tableView.setStyle("-fx-background-color: antiquewhite");
        tableView.setMinWidth(600);
        tableView.getColumns().addAll(memberName, memberNo, memberCato);

        //search bar
        TextField searchBar = new TextField();
        searchBar.setPromptText("Search Here");
        searchBar.setMinWidth(250);
        searchBar.setMaxWidth(memberName.getPrefWidth());

        //search button
        Button searchButton = new Button("Search");
        searchButton.setMinWidth(250);
        searchButton.setLayoutX(270);
        searchButton.setLayoutY(80);

        //OnAction for search button
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            }
        });

        hBox.getChildren().addAll(searchBar, searchButton);
        hBox.setSpacing(3);

        vBox.setSpacing(5);
        vBox.setPadding(new Insets(40, 0, 0, 50));
        vBox.getChildren().addAll(label, tableView, hBox);

        ((Group) scene.getRoot()).getChildren().addAll(vBox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public ObservableList<Map> showList() {
        ObservableList<Map> details = FXCollections.observableArrayList();
        while (cursor.hasNext()) {
            Map<String, String> detailList = new HashMap<>();
            list = cursor.next();
            try {
                detailList.put(column1, list.get("Member Name").toString());
            } catch (NullPointerException exception) {
                detailList.put(column1, "-");
            }
            try {
                detailList.put(column2, list.get("Membership No").toString());
            } catch (NullPointerException ex) {
                detailList.put(column2, "-");
                try {
                    detailList.put(column3, list.get("Member Category").toString());
                } catch (NullPointerException e) {
                    detailList.put(column3, "-");

                    details.add(detailList);
                }
                return details;
            }
        }
        return details;
    }
}

