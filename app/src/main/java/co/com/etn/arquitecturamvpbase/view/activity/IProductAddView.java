package co.com.etn.arquitecturamvpbase.view.activity;

import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.view.IBaseView;

/**
 * Created by jose.cardenas on 19/09/2017.
 */

public interface IProductAddView extends IBaseView {

    void showProductList( Product p );

}
