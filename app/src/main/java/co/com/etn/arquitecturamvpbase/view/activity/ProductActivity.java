package co.com.etn.arquitecturamvpbase.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import co.com.etn.arquitecturamvpbase.R;
import co.com.etn.arquitecturamvpbase.helper.Constants;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.presenter.ProductPresenter;
import co.com.etn.arquitecturamvpbase.view.BaseActivity;
import co.com.etn.arquitecturamvpbase.view.adapter.ProductAdapter;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public class ProductActivity extends BaseActivity <ProductPresenter> implements IProductView {

    private ListView productsList;
    private ProductAdapter productAdapter;
    private FloatingActionButton product_button_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        setPresenter(new ProductPresenter());
        getPresenter().inject(this, getValidateInternet());
        createProgressDialog();

        productsList = (ListView) findViewById(R.id.product_listview);
        product_button_add = (FloatingActionButton) findViewById(R.id.product_button_add);
        product_button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ProductActivity.this, ProductAddActivity.class );
                startActivity( intent );
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getListProducts();
    }

    @Override
    public void showProductList(final ArrayList<Product> productsList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                callAdapter(productsList);
            }
        });
    }

    private void callAdapter(final ArrayList<Product> productArrayList){
        productAdapter = new ProductAdapter( this, R.id.product_listview, productArrayList );
        productsList.setAdapter(productAdapter);
        productsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent( ProductActivity.this, DetailActivity.class );
                intent.putExtra( Constants.ITEM_PRODUCT, productArrayList.get(position) );
                startActivity( intent );
            }
        });
    }

}
