package com.student.jersey.StudentCrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DBcrud {
	Connection cn;
	String lhost = "jdbc:oracle:thin:@localhost:1521:xe";
	String usernm = "system";
	String userpass = "1234";
	public DBcrud() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(lhost,usernm,userpass);
			System.out.println("Done");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Stud>getStudents(){
		List<Stud> std = new ArrayList<Stud>();
		String sql = "select * from student";
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Stud s = new Stud();
				s.setStudent_No(rs.getInt(1));
				s.setStudent_Name(rs.getString(2));
				s.setStudent_DOB(rs.getDate(3));
				s.setStudent_DOJ(rs.getDate(4));
				std.add(s);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return std;
	}
	public String createStudent(Stud d) {
		String msg = "Data inserted Successfully ";
		String err = "Data insertion failed";
		int flag = 0;
		String sql = "insert into student values(?,?,?,?)";
		try {
			java.sql.Date date1 = new java.sql.Date(d.getStudent_DOB().getTime());
			java.sql.Date date2 = new java.sql.Date(d.getStudent_DOJ().getTime());
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, d.getStudent_No());
			pst.setString(2, d.getStudent_Name());
			pst.setDate(3, date1);
			pst.setDate(4,date2);
			pst.executeUpdate();
			flag = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag == 1) {
			return msg;
		}
		else {
			return err;
		}
	}
	public String updateStudents(Stud s) {
		String msg = "Data Updated Successfully ";
		String err = "Data Updation failed";
		String sql = "update student set Student_Name=?,Student_DOB=?,Student_DOJ=? where Student_NO=?";
		int flag = 0;
		try {
			java.sql.Date date1 = new java.sql.Date(s.getStudent_DOB().getTime());
			java.sql.Date date2 = new java.sql.Date(s.getStudent_DOJ().getTime());
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, s.getStudent_Name());
			pst.setDate(2, date1);
			pst.setDate(3,date2);
			pst.setInt(4, s.getStudent_No());
			pst.executeUpdate();
			flag = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag == 1) {
			return msg;
		}else {
			return err;
		}
	}
	public String deleteStudent(int no) {
		int flag = 0;
		String sql = String.format("delete from student where Student_NO =%d",no);
		try {
			Statement st = cn.createStatement();
			flag = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag == 0) {
			return "Data Not Found";
		}else {
			return "Data Deleted Successfully";
		}
	}
	public Stud getStudent(int no) {
		String sql = "select * from student where Student_NO="+no;
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				Stud s = new Stud();
				s.setStudent_No(rs.getInt(1));
				s.setStudent_Name(rs.getString(2));
				s.setStudent_DOB(rs.getDate(3));
				s.setStudent_DOJ(rs.getDate(4));
				return s;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
