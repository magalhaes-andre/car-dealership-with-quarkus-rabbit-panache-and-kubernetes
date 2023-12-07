package org.magalhaes.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.magalhaes.entity.Brand;
import org.magalhaes.service.QueueService;
import org.magalhaes.service.FIPEService;
import org.magalhaes.types.VehicleType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/fipe")
public class FIPEResource {

    @Inject
    @RestClient
    FIPEService fipeService;

    @Inject
    QueueService queueService;

    @POST
    @Path("load")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> loadBrands() {
        List<Message> messages = new ArrayList<>();
        Arrays.stream(VehicleType.values()).forEach(type -> {
            messages.add(queueService.sendBrandsToQueue(getBrands(type)));
        });
        return messages;
    }
    @GET
    @Path("/{vehicleType}/brands")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brand> getBrands(@PathParam("vehicleType") VehicleType vehicleType) {
        return fipeService.getBrands(vehicleType.getVehicleTypeInPT());
    }

}