package eetac.upc.dsa.services;

import eetac.upc.dsa.GameManager;
import eetac.upc.dsa.GameManagerImpl;
import eetac.upc.dsa.models.Team;
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
@Api(value = "/teams", description = "Endpoint to Teams Service")
@Path("/teams")
public class TeamService {
    private GameManager gm;

    public TeamService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.TeamSize()==0) {
            this.gm.addTeam("Julian_Rodriguez/Fernando_Alonso/Alberto_Melendez",2000,3);
        }
    }

    @GET
    @ApiOperation(value = "get all Teams", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Team.class, responseContainer="List"),
    })

    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeams() {

        List<Team> Teams = this.gm.findAllTeams();

        GenericEntity<List<Team>> entity = new GenericEntity<List<Team>>(Teams) {};
        return Response.status(201).entity(entity).build()  ;
    }

    @GET
    @ApiOperation(value = "get a Team", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Team.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeam(@PathParam("id") int id) {
        Team t = this.gm.getTeam(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Team", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTeams(@PathParam("id") int id) {
        Team t = this.gm.getTeam(id);
        if (t == null) return Response.status(404).build();
        else this.gm.deleteTeam(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Team", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTeam(Team team) {

        Team t = this.gm.updateTeam(team);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Team", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Team.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTeam(Team team) {

        if (team.GetMembers() == null)  return Response.status(500).entity(team).build();
        this.gm.addTeam(team);
        return Response.status(201).entity(team).build();
    }
}
