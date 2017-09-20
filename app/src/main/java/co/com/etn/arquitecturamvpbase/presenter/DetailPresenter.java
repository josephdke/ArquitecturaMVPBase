package co.com.etn.arquitecturamvpbase.presenter;

import co.com.etn.arquitecturamvpbase.R;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.repository.DetailRepository;
import co.com.etn.arquitecturamvpbase.repository.ProductAddRepository;
import co.com.etn.arquitecturamvpbase.view.activity.IDetailView;
import co.com.etn.arquitecturamvpbase.view.activity.IProductAddView;
import retrofit.RetrofitError;

/**
 * Created by jose.cardenas on 19/09/2017.
 */

public class DetailPresenter extends BasePresenter <IDetailView> {

    private DetailRepository detailRepository;

    public DetailPresenter() {
        detailRepository = new DetailRepository();
    }

    public void deleteProduct(String id) {
        if( getValidateInternet().isConnected() ){
            createThreadDeleteProduct( id );
        }
        else {
            // TODO: Implementación alert
        }
    }

    private void createThreadDeleteProduct( final String id ) {
        getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    detailRepository.deleteProduct( id );
                    getView().showProductList();
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
