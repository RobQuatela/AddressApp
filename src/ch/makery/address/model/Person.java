package ch.makery.address.model;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty street;
	private final IntegerProperty postalCode;
	private final StringProperty city;
	private final ObjectProperty<LocalDate> birthday;
	
	//default constructor
	public Person() {
		this(null, null);
	}
	
	//constructor with inital data (firstName, lastName)
	public Person(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		
		//for testing dummy data
		this.street = new SimpleStringProperty("1340 Smoketree Terrace");
		this.postalCode = new SimpleIntegerProperty(30024);
		this.city = new SimpleStringProperty("Suwanee");
		this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1989, 4, 12));
	}
	
	public String getFirstName() {
		return firstName.get();
	}
	
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName.get();
	}
	
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	
	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	public void setStreet(String street) {
		this.street.set(street);
	}
	
	public String getStreet() {
		return street.get();
	}
	
	public StringProperty streetProperty() {
		return street;
	}
	
	public int getPostalCode() {
		return postalCode.get();
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode.set(postalCode);
	}
	
	public IntegerProperty postalCodeProperty() {
		return postalCode;
	}
	
	public void setCity(String city) {
		this.city.set(city);
	}
	
	public String getCity() {
		return city.get();
	}
	
	public StringProperty cityProperty() {
		return city;
	}
	
    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
	
	

}
