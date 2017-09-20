package co.com.etn.arquitecturamvpbase.repository;

import java.util.ArrayList;

import co.com.etn.arquitecturamvpbase.helper.ServicesFactory;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.service.IServices;
import retrofit.RetrofitError;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public class ProductRepository {

    private IServices services;

    public ProductRepository() {
        ServicesFactory servicesFactory = new ServicesFactory();
        services = (IServices) servicesFactory.getInstance( IServices.class );
    }

    public ArrayList<Product> getProductsList() throws RetrofitError {
        ArrayList<Product> products = services.getProductsList();
        return products;
    }

}
