package ie.gmit.ds;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
    /** Data persistence
     * Using a hash-map to store the user and data
     */
    private HashMap<Integer, User> usersMap = new HashMap<>();

    // Testing stuff -- Fix it up later on
    public UserApiResource() {
        User testUser = new User(1, "Morgan", "m@mail", "1234");
        usersMap.put(testUser.getUserId(), testUser);
    }

    @GET
    public Collection<User> getUsers(){
        return usersMap.values();
    }
}
