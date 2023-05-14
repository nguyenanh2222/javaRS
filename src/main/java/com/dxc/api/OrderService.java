package com.dxc.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import model.Order;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.logging.Logger;

import static com.dxc.api.Main.connectDb;

@Path("/orders")
public class OrderService {
    private static Log log = LogFactory.getLog(OrderService.class);

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") int id) {
        log.info("OrderService#get()");
        return Response.ok("OrderService#get()").build();
    }

    @POST
//    @Path("/create")
    public Response insert(Order order) {
        connectDb.get_db();
        log.info("OrderService#insert()");
        return Response.ok("OrderService#insert()").build();
    }

    @PUT
    public Response update(Order order) {
        connectDb.get_db();

        log.info("OrderService#update()");
        return Response.ok("OrderService#update()").build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        log.info("OrderService#delete()");
        return Response.ok("OrderService#delete()").build();
    }
}
