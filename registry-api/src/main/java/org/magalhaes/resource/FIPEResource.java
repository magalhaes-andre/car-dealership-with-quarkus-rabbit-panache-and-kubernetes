package org.magalhaes.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.magalhaes.entity.Brand;
import org.magalhaes.service.FIPEService;
import org.magalhaes.types.VehicleType;

import java.util.Arrays;
import java.util.List;

@Path("/fipe")
public class FIPEResource {

    @Inject
    @RestClient
    FIPEService service;

    @POST
    @Path("load")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brand> loadBrands(@PathParam("vehicleType") VehicleType vehicleType) {
        Arrays.stream(vehicleType.values()).forEach(type -> {
            //TODO: send brand to queue per type of vehicle
        });
        return getBrands(vehicleType);
        //TODO: Send brands to RabbitMQ.
    }
    @GET
    @Path("/{vehicleType}/brands")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brand> getBrands(@PathParam("vehicleType") VehicleType vehicleType) {
        return service.getBrands(vehicleType.getVehicleTypeInPT());
    }

}