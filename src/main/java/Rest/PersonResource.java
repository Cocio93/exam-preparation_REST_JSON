/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.mycompany.exam.preparation_rest_json.DataGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author John
 */
@Path("addresses")
public class PersonResource {

    public PersonResource() {
    }
    
    @GET
    @Path("{amount}/{params}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons(@PathParam("amount") int amount, @PathParam("params") String params) {
        DataGenerator generator = new DataGenerator();
        return generator.getData(amount, params);
    }


}
