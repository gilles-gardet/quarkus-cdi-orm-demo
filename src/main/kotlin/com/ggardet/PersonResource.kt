package com.ggardet

import jakarta.annotation.security.RolesAllowed
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestQuery

@RolesAllowed("user")
@Path("/persons")
class PersonResource(val personService: PersonService) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getPersonDetail(@RestQuery firstName: String) = personService.getPersonDetail(firstName)
}
