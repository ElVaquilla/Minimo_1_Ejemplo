package eetac.upc.dsa.services;

import eetac.upc.dsa.GameManager;
import eetac.upc.dsa.GameManagerImpl;
import eetac.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Api(value = "/users", description = "Endpoint to User Service")
@Path("/users")
public class UserService {

    private GameManager gm;

    public UserService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.UserSize()==0) {
            this.gm.addUser("Julian", "Rodriguez", "Flipi");
            this.gm.addUser("Alberto", "Melendez", "Lobi");
            this.gm.addUser("Fernando", "Alonso", "33?");
        }
    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })

    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<User> User = this.gm.findAllUsers();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(User) {};
        return Response.status(201).entity(entity).build()  ;
    }

    @GET
    @ApiOperation(value = "get a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        User u = this.gm.getUser(id);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
    }

    @DELETE
    @ApiOperation(value = "delete a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteUsers(@PathParam("id") int id) {
        User u = this.gm.getUser(id);
        if (u == null) return Response.status(404).build();
        else this.gm.deleteUser(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateUser(User user) {

        User u = this.gm.updateUser(user);

        if (u == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(User user) {

        if (user.GetName() == null || user.GetLastName() == null || user.GetUserName() == null)  return Response.status(500).entity(user).build();
        this.gm.addUser(user);
        return Response.status(201).entity(user).build();
    }
}