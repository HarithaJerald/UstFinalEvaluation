package com.ust.dao;

import java.util.List;

import com.ust.model.Login;
import com.ust.model.Vendor;




public interface DaoService {
	
	//verify login
	public abstract Login verification(String userName, String password);
	//view contact details
	public abstract List<Vendor> getVendor();
	//view vendor by name
	public abstract List<Vendor> getVendorByName(String name);
//	public List<Vendor> getVendorById(int vendorid);
	public abstract int insertVendor(Vendor vendor);
	public abstract int updateVendor(int vendorId, Vendor vendor);
	public abstract int disableVendor(int vId);
	public List<Vendor> getContactDetailsByVId(int vid);
	public Vendor getVendorById(int vendor_id);
	

}
