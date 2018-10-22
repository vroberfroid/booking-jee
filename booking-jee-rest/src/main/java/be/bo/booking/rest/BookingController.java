package be.bo.booking.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.bo.user.User;
import be.bo.user.service.api.IUserService;

@Path("/users")
public class BookingController {

	@Inject
	IUserService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User getUser(@PathParam("id") Long id) {
		System.out.println("*** In BookingController - Retrieve user "+ id);
		return service.retrieveUser(id);
	}
	
	@GET	
	@Produces("text/plain")
	@Path("/hello")
	public String hello() {
		System.out.println("*** Hello world");
		return "Hello world";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUser() {
		System.out.println("*** In BookingController - Retrieve all users ");
		return (List<User>) service.getAllUser();
	}
	
	@POST
	@Consumes({"application/json"})
	public Response createUser(User user) {
		service.createUser(user);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes({"application/json"})
	public Response updateUser(User user) {		
		service.updateUser(user);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") Long id) {
		System.out.println("*** In BookingController - Delete user "+ id);
		service.deleteUser(id);
		return Response.ok().build();
	}
}
