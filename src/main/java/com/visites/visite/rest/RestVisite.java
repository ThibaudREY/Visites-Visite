package com.visites.visite.rest;

import com.visites.visite.repository.VisiteRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("visite")
public class RestVisite {


    @POST
    @Produces({MediaType.TEXT_PLAIN})
    public Response Create(
            @QueryParam("id_agent") int id_agent,
            @QueryParam("id_visiteur") int id_visiteur,
            @QueryParam("date_visite") String date_visite,
            @QueryParam("adresse") String adresse,
            @QueryParam("signature_visiteur") Byte signature_visiteur,
            @QueryParam("signature_agent") Byte signature_agent

    ) {

        VisiteRepository ir = new VisiteRepository();

        System.out.println(id_agent);
        System.out.println(id_visiteur);
        System.out.println(date_visite);
        System.out.println(adresse);
        System.out.println(signature_visiteur);
        System.out.println(signature_agent);


        return Response.status(200).entity(ir.Create(id_agent, id_visiteur, date_visite,adresse,signature_visiteur,signature_agent)).build();

    }


    @DELETE
    @Path("/{id}")
    public Response Delete(@PathParam("id") int id) {

        VisiteRepository ir = new VisiteRepository();

        ir.Delete(id);

        return Response.status(200).entity("Acknoleged: true").build();

    }

    @PUT
    @Path("/{id}")
    public Response Update(
            @QueryParam("id") int id,
            @QueryParam("id_agent") int id_agent,
            @QueryParam("id_visiteur") int id_visiteur,
            @QueryParam("date_visite") String date_visite,
            @QueryParam("adresse") String adresse
    ) {

        VisiteRepository ir = new VisiteRepository();

        ir.Update(id,id_agent,id_visiteur, date_visite, adresse);

        return Response.status(200).entity("Acknoleged: true").build();

    }

    @GET
    @Path("/{id}")
    public Response Read(@PathParam("id") int id) {

        VisiteRepository ir = new VisiteRepository();

        return Response.status(200).entity(ir.Read(id)).build();

    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response ReadAll() {

        VisiteRepository ir = new VisiteRepository();

        return Response
                .status(200).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(ir.All()).build();

    }

}
