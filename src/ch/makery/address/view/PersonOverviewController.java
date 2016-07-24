package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;

public class PersonOverviewController {
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;
	
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;
	
	//reference to main application
	private MainApp mainApp;
	
	//constructor called before initialize() method
	public PersonOverviewController() {
		
	}
	
	//initizlizes the contorller class. called after fxml file is loaded
	
	@FXML
	private void initialize() {
		//initialize the person table
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
	}
	
	//called by main application to give ref back to itself
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		//add observable list data to the table
		personTable.setItems(mainApp.getPersonData());
	}
}
