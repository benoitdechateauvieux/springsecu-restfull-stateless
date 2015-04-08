package org.exoplatform.bch.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bdechateauvieux on 4/8/15.
 */
@Service
@Path("/user")
public class UserService {

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<User> getUsers() {
        return Arrays.asList(new User("Benoit"));
    }
}
