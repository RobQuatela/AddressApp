//first change
//second change
package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	//data for observable list of Persons
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
	//constructor
	public MainApp() {
        // Add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
	}
	
	//returns data as an observable list of Persons
	public ObservableList<Person> getPersonData() {
		return personData;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Address App");
		
		initRootLayout();
		
		showPersonOverview();
	}
	
	//initializes the roote layout
	public void initRootLayout() {
		try {
			//load root layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			//show the scene containing the root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//shows the person overview inside the root layout
	public void showPersonOverview() {
		try {
			//load person overview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane)loader.load();
			
			//set person overview into center of root layout
			rootLayout.setCenter(personOverview);
			
			//give controller access to main app
			PersonOverviewController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
		System.out.println("test worked");
	}
	
}
