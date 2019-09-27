package com.ust.model;

public class ContactPerson {

	private int id;
	private String name;
	private int vendorId;
	private String department;
	private String phoneno;
	private String createdDate;

	// setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	// constructors
	public ContactPerson() {
		super();
	}

	public ContactPerson(int id, String name, int vendorId, String department,
			String phoneno, String createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.vendorId = vendorId;
		this.department = department;
		this.phoneno = phoneno;
		this.createdDate = createdDate;
	}

	// toString() method
	@Override
	public String toString() {
		return "ContactPerson [id=" + id + ", name=" + name + ", vendorId="
				+ vendorId + ", department=" + department + ", phoneno="
				+ phoneno + ", createdDate=" + createdDate + "]";
	}

}
