package co.com.etn.arquitecturamvpbase.service;

import java.util.ArrayList;

import co.com.etn.arquitecturamvpbase.model.Product;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public interface IServices {

    @GET("/products")
    ArrayList<Product> getProductsList();

    @POST("/products")
    Product insertProduct( @Body Product p );

    @DELETE("/products/{id}")
    Product deleteProduct( @Path("id") String id );

}
