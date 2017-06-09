package fr.epita.sandesh.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**

 * @author Sandesh VAKALE
 *
 */
@Entity
public class Address {

	@Id
	private int Id;
	private String City;
	private String Street;
	
	/**
	 * Get the ID
	 * @return ID
	 */
	public int getId() {
		return Id;
	}
	
	/**
	 * Set the Id
	 * @param id
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * Get the City
	 * @return City
	 */
	public String getCity() {
		return City;
	}
	/**
	 * Set the City
	 * @param city
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * Get the Street
	 * @return
	 */
	public String getStreet() {
		return Street;
	}
	/**
	 * Set the Street
	 * @param street
	 */
	public void setStreet(String street) {
		Street = street;
	}
	/**
	 * Constructor set the value of ID, Street, CIty
	 * @param id
	 * @param city
	 * @param street
	 */
	public Address(int id, String city, String street) {
		super();
		Id = id;
		City = city;
		Street = street;
	}
	
	public Address(){
		
	}
}
