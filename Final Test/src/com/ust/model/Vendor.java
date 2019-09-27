package com.ust.model;

public class Vendor {
	
	private int vendorId;
	private String name;
	private String address;
	private String location;
	private String service;
	private String pincode;
	private String createdDate;
	private int isActive;
	private int id;
	private String Contactname;
	private String department;
	private String phoneno;
	private String email;
	
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContactname() {
		return Contactname;
	}
	public void setContactname(String contactname) {
		Contactname = contactname;
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
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(int vendorId, String name, String address, String location,
			String service, String pincode, String createdDate, int isActive) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.createdDate = createdDate;
		this.isActive = isActive;
		
	}
	
	
	public Vendor(int vendorId, String name, String address, String location,
			String service, String pincode, String createdDate, int isActive,
			int id, String contactname, String department, String phoneno) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.createdDate = createdDate;
		this.isActive = isActive;
		this.id = id;
		Contactname = contactname;
		this.department = department;
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + ", address="
				+ address + ", location=" + location + ", service=" + service
				+ ", pincode=" + pincode + ", createdDate=" + createdDate
				+ ", isActive=" + isActive + "]";
	}
	

}
