package eetac.upc.dsa.services;

import eetac.upc.dsa.GameManager;
import eetac.upc.dsa.GameManagerImpl;
import eetac.upc.dsa.models.Game;
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
@Api(value = "/games", description = "Endpoint to Game Service")
@Path("/games")
public class GameService {
    private GameManager gm;

    public GameService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.GameSize()==0) {
            this.gm.addGame(0);
            this.gm.addGame(1);
            this.gm.addGame(2);
        }
    }

    @GET
    @ApiOperation(value = "get all Games", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Game.class, responseContainer="List"),
    })

    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGames() {

        List<Game> Games = this.gm.findAllGames();

        GenericEntity<List<Game>> entity = new GenericEntity<List<Game>>(Games) {};
        return Response.status(201).entity(entity).build()  ;
    }

    @GET
    @ApiOperation(value = "get a Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Game.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGame(@PathParam("id") int id) {
        Game g = this.gm.getGame(id);
        if (g == null) return Response.status(404).build();
        else  return Response.status(201).entity(g).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteGame(@PathParam("id") int id) {
        Game g = this.gm.getGame(id);
        if (g == null) return Response.status(404).build();
        else this.gm.deleteGame(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateGame(Game game) {

        Game g = this.gm.updateGame(game);

        if (g == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Game.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newGame(Game game) {

        if (game.GetState() != 0 && game.GetState() != 1 && game.GetState() != 2 && game.GetState() != 3)  return Response.status(500).entity(game).build();
        this.gm.addGame(game);
        return Response.status(201).entity(game).build();
    }

}