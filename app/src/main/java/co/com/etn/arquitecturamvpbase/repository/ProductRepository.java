package co.com.etn.arquitecturamvpbase.repository;

import android.util.Log;

import java.util.ArrayList;

import co.com.etn.arquitecturamvpbase.helper.ServicesFactory;
import co.com.etn.arquitecturamvpbase.model.DeleteResponse;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.service.IServices;
import retrofit.RetrofitError;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public class ProductRepository implements IProductRepository {

    private IServices services;

    public ProductRepository() {
        ServicesFactory servicesFactory = new ServicesFactory();
        services = (IServices) servicesFactory.getInstance( IServices.class );
    }

    public ArrayList<Product> getProductsList() throws RetrofitError {
        ArrayList<Product> products = services.getProductsList();
        return products;
    }

    public Product insertProduct( Product p ) throws RetrofitError {
        return services.insertProduct( p );
    }

    public DeleteResponse deleteProduct(String id ) throws RetrofitError {
        //Product p = new Product();
        //p.setId(id);
        Log.w("myApp","id:"+id);
        return services.deleteProduct( id );
    }

}
