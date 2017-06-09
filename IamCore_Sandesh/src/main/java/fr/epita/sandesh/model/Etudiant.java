package fr.epita.sandesh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Sandesh VAKALE
 *
 */
@Entity
public class Etudiant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String Name;
	private String Email;
	private int number;
	
	/**
	 * Defining the OneToOne Relation  with Address
	 */
	@OneToOne
	private Address address;
	
	/**
	 * get the Address
	 * @return Address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * Set the Address
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * GEt the Id
	 * @return Id
	 */
	public int getId() {
		return Id;
	}
	/**
	 *  Set the Id
	 * @param id
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * Get the Name
	 * @return Name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * Set the Name
	 * @param name
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * Get The  Email
	 * @return Email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * Set the Email
	 * @param email
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * GET the Number
	 * @return Number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * Set the Number
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * Constructor to set the value for Name, Email, Number, Address
	 * @param name
	 * @param email
	 * @param number
	 * @param address
	 */
	public Etudiant(String name, String email, int number,Address address) {
		super();
		this.address=address;
		Name = name;
		Email = email;
		this.number = number;
	}
	/**
	 * blank Consructor
	 */
	public Etudiant(){
		
	}
	
	
}
