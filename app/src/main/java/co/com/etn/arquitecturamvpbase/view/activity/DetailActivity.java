package co.com.etn.arquitecturamvpbase.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import co.com.etn.arquitecturamvpbase.R;
import co.com.etn.arquitecturamvpbase.helper.Constants;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.presenter.DetailPresenter;
import co.com.etn.arquitecturamvpbase.presenter.ProductAddPresenter;
import co.com.etn.arquitecturamvpbase.view.BaseActivity;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public class DetailActivity extends BaseActivity<DetailPresenter> implements IDetailView {

    private TextView product_detail_name_value;
    private TextView product_detail_description_value;
    private TextView product_detail_quantity_value;
    private TextView product_detail_price_value;
    private Product product;

    Button product_detail_button_eliminar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        setPresenter(new DetailPresenter());
        getPresenter().inject(this, getValidateInternet());
        createProgressDialog();

        int n;
        loadView();
        product = (Product) getIntent().getSerializableExtra( Constants.ITEM_PRODUCT );
        setDataItem();
        product_detail_button_eliminar = (Button) findViewById(R.id.product_detail_button_eliminar);
        product_detail_button_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().deleteProduct( product.getId() );
            }
        });
    }

    private void setDataItem() {
        product_detail_name_value.setText( product.getName() );
        product_detail_description_value.setText( product.getDescription() );
        product_detail_quantity_value.setText( product.getQuantity() );
        product_detail_price_value.setText( product.getPrice() );
    }

    private void loadView(){
        product_detail_name_value = (TextView) findViewById(R.id.product_detail_name_value);
        product_detail_description_value = (TextView) findViewById(R.id.product_detail_description_value);
        product_detail_quantity_value = (TextView) findViewById(R.id.product_detail_quantity_value);
        product_detail_price_value = (TextView) findViewById(R.id.product_detail_price_value);
    }

    public void showProductList(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DetailActivity.this.finish();
            }
        });
    }

}
