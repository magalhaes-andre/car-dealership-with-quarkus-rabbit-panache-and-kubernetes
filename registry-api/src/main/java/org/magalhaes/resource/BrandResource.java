//package org.magalhaes.resource;
//
//import io.smallrye.mutiny.Uni;
//import jakarta.inject.Inject;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.PathParam;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
//import org.eclipse.microprofile.rest.client.inject.RestClient;
//import org.magalhaes.service.FIPEService;
//import org.magalhaes.entity.Brand;
//import org.magalhaes.types.VehicleType;
//
//import java.util.List;
//
//@Path("/{vehicleType}/brands")
//public class BrandResource {
//
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Brand> getBrands(@PathParam("vehicleType") VehicleType vehicleType) {
//        return service.getBrands(vehicleType.getVehicleTypeInPT());
//    }
//
//}
