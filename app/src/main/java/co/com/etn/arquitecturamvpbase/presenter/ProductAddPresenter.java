package co.com.etn.arquitecturamvpbase.presenter;

import co.com.etn.arquitecturamvpbase.R;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.repository.ProductRepository;
import co.com.etn.arquitecturamvpbase.view.activity.IProductAddView;
import retrofit.RetrofitError;

/**
 * Created by jose.cardenas on 19/09/2017.
 */

public class ProductAddPresenter extends BasePresenter <IProductAddView> {

    private ProductRepository productRepository;
    Product p;

    public ProductAddPresenter() {
        productRepository = new ProductRepository();
    }

    public void createProduct( String name, String description, String quantity, String price ) {
        p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setQuantity(quantity);
        p.setPrice(price);
        if( getValidateInternet().isConnected() ){
            createThreadCreateProduct();
        }
        else {
            // TODO: Implementación alert
        }
    }

    private void createThreadCreateProduct() {
        getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Product pResult = productRepository.insertProduct( p );
                    getView().showProductList( pResult );
                } catch( RetrofitError retrofitError ){
                    //TODO: mostrar alert
                } finally {
                    getView().hideProgress();
                }
            }
        });
        thread.start();
    }

}
