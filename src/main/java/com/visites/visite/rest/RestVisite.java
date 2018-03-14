package com.visites.visite.rest;

import com.visites.visite.repository.VisiteRepository;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class RestVisite {


    @POST
    @Produces({MediaType.TEXT_PLAIN})
    public Response Create(String body) {

        JSONObject post = new JSONObject(body);

        VisiteRepository ir = new VisiteRepository();

        return Response.status(200).entity(
                ir.Create(
                        post.getInt("id_agent"),
                        post.getInt("id_visiteur"),
                        post.getString("date_visite"),
                        post.getString("adresse"),
                        post.getString("signature_visiteur"),
                        post.getString("signature_agent"))
        ).build();

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
    public Response Update(@PathParam("id") int id, String body) {

        JSONObject post = new JSONObject(body);

        VisiteRepository ir = new VisiteRepository();

        ir.Update(
                id,
                post.getInt("id_agent"),
                post.getInt("id_visiteur"),
                post.getString("date_visite"),
                post.getString("adresse"),
                post.getString("signature_visiteur"),
                post.getString("signature_agent")
        );

        return Response.status(200).entity("Acknoleged: true").build();

    }

    @GET
    @Path("/{id}")
    public Response Read(@PathParam("id") int id) {

        VisiteRepository ir = new VisiteRepository();

        return Response.status(200).entity(ir.Read(id)).build();

    }

    @GET
    @Path("/all{start : (/start)?}{length : (/length)?}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response ReadAll(@PathParam("start") int start, @PathParam("length") int length) {

        VisiteRepository ir = new VisiteRepository();

        return Response.status(200).entity(ir.All(start, length)).build();

    }

}
