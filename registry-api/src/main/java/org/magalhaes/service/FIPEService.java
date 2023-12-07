package org.magalhaes.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.magalhaes.entity.Brand;

import java.util.List;

@RegisterRestClient(baseUri = "https://parallelum.com.br")
public interface FIPEService {

    String ROOT_PATH = "/fipe/api/v1";
    String BRANDS_RESOURCE = "/{vehicleType}/marcas/";
    @Path(ROOT_PATH + BRANDS_RESOURCE)
    @GET
    List<Brand> getBrands(@PathParam("vehicleType") String vehicleType);
}
