package co.com.etn.arquitecturamvpbase.repository;

import java.util.ArrayList;

import co.com.etn.arquitecturamvpbase.helper.ServicesFactory;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.service.IServices;
import retrofit.RetrofitError;

/**
 * Created by jose.cardenas on 19/09/2017.
 */

public class ProductAddRepository {

    private IServices services;

    public ProductAddRepository() {
        ServicesFactory servicesFactory = new ServicesFactory();
        services = (IServices) servicesFactory.getInstance( IServices.class );
    }

    public Product insertProduct( Product p ) throws RetrofitError {
        return services.insertProduct( p );
    }

}
