package sample;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.UnknownHostException;

public class Main extends Application {


    public Main() throws UnknownHostException {
    }

    public static void main(String[] args) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static MongoClient mongoClient;

    static {
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        }
    }

    public static DB db = mongoClient.getDB("Gym_Management_System");
    public static DBCollection collection1 = db.getCollection("GymMember");
    public static BasicDBObjectBuilder basicDBObjectBuilder = new BasicDBObjectBuilder().start();
}
