package com.student.jersey.StudentCrud;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("student")

public class Resources {
	DBcrud stddata = new DBcrud();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Stud> getStudent(){
		return stddata.getStudents();
	}
	@Path("insert")
	@POST
	public String insertStdData(Stud ins) {
		return stddata.createStudent(ins);
	}
	
	@Path("update")
	@PUT
	public String updateStdData(Stud updte) {
		return stddata.updateStudents(updte);
	}
	
	@Path("delete/{no}")
	@DELETE
	public String deleteStdData(@PathParam("no")int no){
		return stddata.deleteStudent(no);
	}
	
	@Path("search/{no}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@GET
	public Stud getDataSingle(@PathParam("no")int no) {
		return stddata.getStudent(no);
	}
}
