/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.endpoints;

import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.school.ezon.api.Exceptions.UserExistException;
import org.school.ezon.api.controllers.Controller;
import org.school.ezon.api.controllers.StateInit;
import org.school.ezon.api.facade.Facade;
import org.school.ezon.api.facade.UserFacadeFactory;

/**
 * REST Web Service
 *
 * @author kaspe
 */
@Path("Authenticate")
public class AuthenticateResource {

    Controller controller = StateInit.getController();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AuthenticateResource
     */
    public AuthenticateResource() {
    }

    /**
     * Retrieves representation of an instance of
     * org.school.ezon.api.endpoints.AuthenticateResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AuthenticateResource
     *
     * @param content representation for the resource
     */
    @Path("/{userName}/{password}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signUp(@PathParam("userName") String email, @PathParam("password") String password) {
        try {
            // TODO: Change use from facade to a controller!
            return Response.ok(controller.signUp(email, password)).build();
        } catch (UserExistException ex) {
            return  Response.serverError().build();
        }
    }
}
