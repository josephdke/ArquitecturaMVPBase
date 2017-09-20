package co.com.etn.arquitecturamvpbase.presenter;

import java.util.ArrayList;

import co.com.etn.arquitecturamvpbase.R;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.repository.ProductRepository;
import co.com.etn.arquitecturamvpbase.view.activity.IProductView;
import retrofit.RetrofitError;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public class ProductPresenter extends BasePresenter <IProductView> {

    private ProductRepository productRepository;

    public ProductPresenter() {
        productRepository = new ProductRepository();
    }

    public void getListProducts() {
        if( getValidateInternet().isConnected() ){
            createThreadProduct();
        }
        else {
            // TODO: Implementación alert
        }
    }

    private void createThreadProduct() {
        getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getProductsList();
            }
        });
        thread.start();
    }

    private void getProductsList(){
        try {
            ArrayList<Product> productsList = productRepository.getProductsList();
            getView().showProductList( productsList );
        } catch( RetrofitError retrofitError ){
            //TODO: mostrar alert
        } finally {
            getView().hideProgress();
        }
    }

}
