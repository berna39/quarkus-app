package com.terminator;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.terminator.dto.ProductDto;
import com.terminator.model.Product;
import com.terminator.service.ProductService;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public Response findProducts(){
        List<Product> products = productService.findAll();
        return Response.ok(products).build();
    }

    @POST
    public Response saveProduct(ProductDto productDto){
        Product product = productService.saveProduct(productDto);
        return Response.ok(product).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, ProductDto productDto){
        Product product = productService.updateProduct(id, productDto);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id){
        productService.deleteProduct(id);

        return Response.ok().build();
    }
}