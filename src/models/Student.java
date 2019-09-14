package models;

import java.util.ArrayList;
import utilities.StringExtensions;

public class Student extends User implements IModel<Student> {
	
	private String email;
	private ArrayList<String> phoneNumbers;
	private String cardId;

	public Student() {
		this.phoneNumbers = new ArrayList<String>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public void addPhoneNumber(String phoneNumber) {
		this.phoneNumbers.add(phoneNumber);
	}
	
	public void removePhoneNumber(String phoneNumber) {
		this.phoneNumbers.remove(phoneNumber);
	}
	
	public ArrayList<String> getPhoneNumbers() {
		return new ArrayList<String>(phoneNumbers);
	}

	@Override
	public boolean modelIsValid() {
		return StringExtensions.IsNullOrWhitespace(getFirstName()) && 
			StringExtensions.IsNullOrWhitespace(getLastName()) &&
			StringExtensions.IsNullOrWhitespace(getUserName()) &&
			StringExtensions.IsNullOrWhitespace(getPassword()) &&
			StringExtensions.IsNullOrWhitespace(email) &&
			StringExtensions.IsNullOrWhitespace(cardId);
	}
	
	@Override
	public boolean isIdenticalTo(Student model) {
		return model.getUserName().equals(getUserName());
	}
}
