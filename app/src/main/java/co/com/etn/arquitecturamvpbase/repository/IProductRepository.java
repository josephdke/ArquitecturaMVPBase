package co.com.etn.arquitecturamvpbase.repository;

import java.util.ArrayList;

import co.com.etn.arquitecturamvpbase.model.DeleteResponse;
import co.com.etn.arquitecturamvpbase.model.Product;

/**
 * Created by jose.cardenas on 23/09/2017.
 */

public interface IProductRepository {

    public ArrayList<Product> getProductsList();

    public Product insertProduct( Product p );

    public DeleteResponse deleteProduct(String id );

}
