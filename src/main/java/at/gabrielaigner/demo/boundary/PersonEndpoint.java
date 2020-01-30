package at.gabrielaigner.demo.boundary;

import at.gabrielaigner.demo.control.PersonDAO;
import at.gabrielaigner.demo.model.Person;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonEndpoint {

    @Inject
    PersonDAO personDao;

    @GET
    public Response findAll(){
        //Test von findById (das ist alles schon von panache vorprogrammieret)
        Person person = personDao
                .findById(1L);

        //Test von find by Name
        Person person1 = personDao
                .find("name", "Christian")
                .firstResult();

        return Response
                .ok(person)
                .build();
    }
}
