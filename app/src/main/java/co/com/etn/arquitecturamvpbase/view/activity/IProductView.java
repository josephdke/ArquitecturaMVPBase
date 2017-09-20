package co.com.etn.arquitecturamvpbase.view.activity;

import java.util.ArrayList;

import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.view.IBaseView;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public interface IProductView extends IBaseView {

    void showProductList(ArrayList<Product> productsList);

}
