package org.cnit481.group11;

import org.cnit481.group11.connections.StockDataServiceConnection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class DataFetchResource {

    @Inject
    DataFetchBean counter;

    @Inject
    StockDataServiceConnection stockDataService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "hello!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public String getSuccess() {
        return "count: " + counter.getSuccess();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/errors")
    public String getError() {
        return "errors: " + counter.getError();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/health")
    public String getHealth() {
        if (stockDataService.connected()) {
            return "health: good";
        } else {
            return "health: not connected to stockDataService";
        }
    }
}