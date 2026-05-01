package project;

import java.time.LocalDate;

/**
*  @ author: Shaikha Aldosari 202303941
*  @ since 18/4/2026 / fixed 1/5/2026
* @ version :
*/
public class Applicant {
	private String name;
	private String passportNO;
	private String nationality;
	private LocalDate birthdate;
	
	
	public Applicant(String name, String passportNO, String nationality, LocalDate birthdate) {
		this.name = name;
		this.passportNO = passportNO;
		this.nationality = nationality;
		this.birthdate = birthdate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassportNO() {
		return passportNO;
	}


	public void setPassportNO(String passportNO) {
		this.passportNO = passportNO;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public LocalDate getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}


	@Override
	public String toString() {
		return "Applicant Name:" + getName() + ", PassportNO:" + getPassportNO() + ", Nationality:"
				+ getNationality() + ", Birth Date:" + getBirthdate();
	}



	
	

}
