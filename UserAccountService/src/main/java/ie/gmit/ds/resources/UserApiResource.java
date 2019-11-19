package ie.gmit.ds.resources;

import ie.gmit.ds.api.User;
import ie.gmit.ds.db.UserDB;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


/**
 * Resource class for User (Representation class)
 * <p>
 * Are used by multi-threads concurrently - keep resources stateless / immutable
 * <p>
 * References:
 * https://howtodoinjava.com/dropwizard/tutorial-and-hello-world-example/
 * https://www.dropwizard.io/en/stable/getting-started.html
 */
@Path("/users") // Tells Jersey that this resource is accessible at URL
@Produces(MediaType.APPLICATION_JSON) // Lets Jersey content negotiate JSON
public class UserApiResource {

    private final Validator validator;

    /**
     * Single arg constructor to initialise the validator
     *
     * @param validator
     */
    public UserApiResource(Validator validator) {
        this.validator = validator;
    }

    /**
     * List all users
     *
     * @return
     */
    @GET
    public Response getUsers() {
        return Response.ok(UserDB.getUsers()).build();
    }

    /**
     * List info on a user by id
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") int id) {
        User user = UserDB.getUser(id);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Create a user
     *
     * @param user
     * @return
     * @throws URISyntaxException
     */
    @POST
    public Response createUser(User user) throws URISyntaxException {
        System.out.println("User: " + user.toString());
        // Validation
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        User u = UserDB.getUser(user.getUserId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<User> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString());
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (u == null) {
            System.out.println("User HERE!: " + user.toString());
            UserDB.createUser(user.getUserId(), user);

            return Response.created(new URI("/users/create" + user.getUserId())).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Update user by id
     *
     * @param id
     * @param user
     * @return
     */
    @PUT
    @Path("/{userId}")
    public Response updateUserById(@PathParam("userId") int id, User user) {
        // Validation
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        User u = UserDB.getUser(user.getUserId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<User> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (u != null) {
            UserDB.updateUser(user.getUserId(), user);
            return Response.ok(user).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{userId}")
    public Response removeUserById(@PathParam("userId") int id) {
        User user = UserDB.getUser(id);
        if (user != null) {
            UserDB.deleteUser(id);
            return Response.ok().build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}

