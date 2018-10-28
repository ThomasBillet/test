package colruyt.trsEJB.entities;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PNO")
	private int id;
	
	@Column(name="PFNAME")
	private String firstName;
	
	@Column(name="PLNAME")
	private String lastName;
	
	@Column(name="PFUNC")
	private String function;
	
	@Column(name="PA_CONO")
	private String companie;
	
	@Column(name="PADEPT")
	private String department;
	
	@Column(name="PTEL")
	private String telephoneNr;
	
	@Column(name="PSEX")
	private String gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getCompanie() {
		return companie;
	}

	public void setCompanie(String companie) {
		this.companie = companie;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTelephoneNr() {
		return telephoneNr;
	}

	public void setTelephoneNr(String telephoneNr) {
		this.telephoneNr = telephoneNr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
