package com.seberino.pix;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/pix/chave")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChaveResource {
    


    @GET
    public List<ChavePix> listAll()
    {
        return ChavePix.listAll();
    }

    @POST
    @Transactional
    public Response adicionaChave(ChavePix chave)
    {
        //checa se a chave já eiste
        Optional<ChavePix> chave1 = ChavePix.findByIdOptional(chave.getChave());
        if (chave1.isPresent())
        {
            return Response.status(208).build();
        }

        ChavePix.persist(chave);
        return Response.ok(chave).build();
    }


    @GET
    @Path("{chave}")
    public ChavePix recuperaChave(@PathParam("chave") String chave)
    {
        return ChavePix.findById(chave);
    }

    @DELETE
    @Transactional
    @Path("{chave}")
    public Response deleteChave(@PathParam("chave") String chave)
    {
        Optional<ChavePix> chave1 = ChavePix.findByIdOptional(chave);
        if (chave1.isPresent())
        {
            ChavePix.deleteById(chave);
            return Response.ok(chave1.get()).build();
        }
        else
        {
            return Response.status(404).build();
        }
        
    }
}
