package com.ust.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.DaoService;
import com.ust.model.Login;
import com.ust.model.Vendor;

@RestController
public class SpringController {

	@Autowired
	DaoService dao;

	// verify login
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public Login verify(@PathVariable("username") String userName,
			@PathVariable("password") String password) {
		return dao.verification(userName, password);
	}

	// view vendors

	@RequestMapping(value = "/api/vendor/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List getVendor(Model m, @PathVariable("name") String name) {
		List list;
		if (name.equals("null")) {
			list = dao.getVendor();
		} else {
			list = dao.getVendorByName(name);
		}

		return list;
	}

	// view vendor list by id
	@RequestMapping(value = "/api/vendors/{vendor_id}", method = RequestMethod.GET)
	@ResponseBody
	public Vendor getvendors(Model m, @PathVariable("vendor_id") int vendor_id) {

		return dao.getVendorById(vendor_id);
	}

	// Add Vendor
	@ResponseBody
	@RequestMapping(value = "/api/insertvendor", method = RequestMethod.POST)
	public void insertVendor(@RequestBody Vendor vc) throws ParseException {
		dao.insertVendor(vc);
	}

	// update Vendor
	@ResponseBody
	@RequestMapping(value = "/api/updatevendor", method = RequestMethod.PUT)
	public void updateDoctor(@RequestBody Vendor vc) throws ParseException {
		int vendorId = vc.getVendorId();
		int Id = vc.getId();
		dao.updateVendor(vendorId, vc);
	}

	// to disable a vendor

	@RequestMapping(value = "/api/disablevendor/{vId}", method = RequestMethod.PUT)
	@ResponseBody
	public void disableStaff(@PathVariable("vId") int vId) {
		dao.disableVendor(vId);
	}

	// view contact details by vendor id

	@RequestMapping(value = "/api/contactDetails/{vId}", method = RequestMethod.GET)
	@ResponseBody
	public List getContactDetails(Model m, @PathVariable("vId") int vId) {
		List list;
		list = dao.getContactDetailsByVId(vId);
		return list;

	}

}
