package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Login;

import com.ust.model.Vendor;

public class DaoImplementation implements DaoService {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// login verification
	@Override
	public Login verification(String userName, String password) {
		System.out.println(userName);
		String sql = "select USERID from LOGIN where USERNAME='" + userName
				+ "' and password='" + password + "'";
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Login>(Login.class));
	}

	// view vendor details
	@Override
	public List<Vendor> getVendor() {

		return template
				.query("select VENDORID,NAME,ADDRESS,LOCATION,SERVICE,PINCODE from VENDOR_TABLE where isActive=0",
						new RowMapper<Vendor>() {
							public Vendor mapRow(ResultSet rs, int row)
									throws SQLException {
								Vendor vendor = new Vendor();

								vendor.setVendorId(rs.getInt(1));
								vendor.setName(rs.getString(2));
								vendor.setAddress(rs.getString(3));
								vendor.setLocation(rs.getString(4));
								vendor.setService(rs.getString(5));
								vendor.setPincode(rs.getString(6));
								return vendor;

							}
						});
	}

	// get vendor by name

	public List<Vendor> getVendorByName(String name) {
		return template
				.query("select VENDORID,NAME,ADDRESS,LOCATION,SERVICE,PINCODE from VENDOR_TABLE where isActive=0 and NAME='"
						+ name + "'", new RowMapper<Vendor>() {
					public Vendor mapRow(ResultSet rs, int row)
							throws SQLException {
						Vendor vendor = new Vendor();
						vendor.setVendorId(rs.getInt(1));
						vendor.setName(rs.getString(2));
						vendor.setAddress(rs.getString(3));
						vendor.setLocation(rs.getString(4));
						vendor.setService(rs.getString(5));
						vendor.setPincode(rs.getString(6));
						return vendor;
					}
				});
	}

	// get vendor details by id

	public Vendor getVendorById(int vendor_id) {

		String sql = "select vc.vendorId,vc.name,vc.address,vc.location,vc.service,vc.pincode,cd.name,cd.department,cd.email,cd.phoneno,cd.id from vendor_table vc join contact_person cd on vc.vendorId=cd.vendorId where vc.isActive=0 and vc.vendorId='"
				+ vendor_id + "'";
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Vendor>(Vendor.class));
	}

	// Add vendor

	public int insertVendor(Vendor vc) {

		String sql1 = "insert into vendor_table(name,address,location,service,pincode,isActive) values "
				+ "('"
				+ vc.getName()
				+ "','"
				+ vc.getAddress()
				+ "','"
				+ vc.getLocation()
				+ "','"
				+ vc.getService()
				+ "','"
				+ vc.getPincode() + "'," + 0 + ")";

		template.update(sql1);

		Integer maxId = getSequence();
		String sql2 = "insert into CONTACT_PERSON(vendorid,name,department,email,phoneno) values ("
				+ maxId
				+ ",'"
				+ vc.getName()
				+ "','"
				+ vc.getDepartment()
				+ "','" + vc.getEmail() + "','" + vc.getPhoneno() + "')";
		return template.update(sql2);

	}

	// get vendor id
	private Integer getSequence() {
		Integer seq;
		String sql = "select MAX(vendorid)from vendor_table";
		seq = template.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}

	// update vendor
	public int updateVendor(int vendorid, Vendor vc) {

		String sql = "update vendor_table set name='" + vc.getName()
				+ "' ,address='" + vc.getAddress() + "' ,location='"
				+ vc.getLocation() + "',service='" + vc.getService()
				+ "',pincode='" + vc.getPincode() + "',isActive="
				+ vc.getIsActive() + " " + "where vendorid =" + vendorid;
		template.update(sql);

		// Integer maxId = getSequence();

		String sql1 = "update contact_person set vendorid=" + vendorid
				+ ",name='" + vc.getName() + "',department='"
				+ vc.getDepartment() + "',email='" + vc.getEmail()
				+ "',phoneno='" + vc.getPhoneno() + "'where id = " + vc.getId();

		return template.update(sql1);
	}

	// get contact details by id

	public List<Vendor> getContactDetailsByVId(int vid) {
		return template
				.query("select id,name,department,vendorid,email,phoneno from contact_person where vendorid="
						+ vid + "", new RowMapper<Vendor>() {
					public Vendor mapRow(ResultSet rs, int row)
							throws SQLException {
						Vendor vc = new Vendor();
						vc.setId(rs.getInt(1));
						vc.setContactname(rs.getString(2));
						vc.setDepartment(rs.getString(3));
						vc.setVendorId(rs.getInt(4));
						vc.setEmail(rs.getString(5));
						vc.setPhoneno(rs.getString(6));
						return vc;
					}
				});
	}

	// to disable vendor
	public int disableVendor(int vId) {

		String sql = "update vendor_table set isActive='1' where vendorId="
				+ vId + "";

		return template.update(sql);
	}

}
