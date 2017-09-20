package co.com.etn.arquitecturamvpbase.repository;

import android.util.Log;

import co.com.etn.arquitecturamvpbase.helper.ServicesFactory;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.service.IServices;
import retrofit.RetrofitError;

/**
 * Created by jose.cardenas on 19/09/2017.
 */

public class DetailRepository {

    private IServices services;

    public DetailRepository() {
        ServicesFactory servicesFactory = new ServicesFactory();
        services = (IServices) servicesFactory.getInstance( IServices.class );
    }

    public Product deleteProduct( String id ) throws RetrofitError {
        //Product p = new Product();
        //p.setId(id);
        Log.w("myApp","id:"+id);
        return services.deleteProduct( id );
    }

}
