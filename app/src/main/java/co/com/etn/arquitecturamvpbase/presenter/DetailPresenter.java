package co.com.etn.arquitecturamvpbase.presenter;

import co.com.etn.arquitecturamvpbase.R;
import co.com.etn.arquitecturamvpbase.model.DeleteResponse;
import co.com.etn.arquitecturamvpbase.repository.IProductRepository;
import co.com.etn.arquitecturamvpbase.repository.ProductRepository;
import co.com.etn.arquitecturamvpbase.view.activity.IDetailView;
import retrofit.RetrofitError;

/**
 * Created by jose.cardenas on 19/09/2017.
 */

public class DetailPresenter extends BasePresenter <IDetailView> {

    private IProductRepository productRepository;

    public DetailPresenter(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteProduct(String id) {
        if( getValidateInternet().isConnected() ){
            createThreadDeleteProduct( id );
        }
        else {
            getView().showAlertDialog(R.string.validate_internet);
        }
    }

    public void createThreadDeleteProduct(final String id) {
        getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                deleteProductRepository(id);
            }
        });
        thread.start();
    }

    public void deleteProductRepository(String id){
        try {
            DeleteResponse deleteResponse = productRepository.deleteProduct( id );
            if( deleteResponse.isStatus() ) {
                getView().showToast(R.string.delete_correct);
            }
            else {
                getView().showAlertDialogError(R.string.error);
            }
            //getView().showProductList();
        } catch( RetrofitError retrofitError ){
            //TODO: mostrar alert
        } finally {
            getView().hideProgress();
        }
    }

}
