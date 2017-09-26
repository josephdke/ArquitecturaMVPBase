package co.com.etn.arquitecturamvpbase.view.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import co.com.etn.arquitecturamvpbase.R;
import co.com.etn.arquitecturamvpbase.model.Product;
import co.com.etn.arquitecturamvpbase.presenter.ProductAddPresenter;
import co.com.etn.arquitecturamvpbase.view.BaseActivity;

public class ProductAddActivity extends BaseActivity<ProductAddPresenter> implements IProductAddView, TextWatcher {

    Button product_add_button_crear;
    TextInputEditText product_add_edittext_name;
    TextInputEditText product_add_edittext_description;
    TextInputEditText product_add_edittext_quantity;
    TextInputEditText product_add_edittext_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        setPresenter(new ProductAddPresenter());
        getPresenter().inject(this, getValidateInternet());
        createProgressDialog();

        product_add_button_crear = (Button) findViewById(R.id.product_add_button_crear);
        product_add_button_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().createProduct(
                        product_add_edittext_name.getText().toString(),
                        product_add_edittext_description.getText().toString(),
                        product_add_edittext_quantity.getText().toString(),
                        product_add_edittext_price.getText().toString()
                );
            }
        });
        product_add_edittext_name = (TextInputEditText) findViewById(R.id.product_add_edittext_name);
        product_add_edittext_name.addTextChangedListener(this);
        product_add_edittext_description = (TextInputEditText) findViewById(R.id.product_add_edittext_description);
        product_add_edittext_description.addTextChangedListener(this);
        product_add_edittext_quantity = (TextInputEditText) findViewById(R.id.product_add_edittext_quantity);
        product_add_edittext_quantity.addTextChangedListener(this);
        product_add_edittext_price = (TextInputEditText) findViewById(R.id.product_add_edittext_price);
        product_add_edittext_price.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        validarCampos();
    }

    public void validarCampos(){
        if( product_add_edittext_name.getText().length()>0 &&
                product_add_edittext_description.getText().length()>0 &&
                product_add_edittext_quantity.getText().length()>0 &&
                product_add_edittext_price.getText().length()>0 ){
            product_add_button_crear.setEnabled(true);

            product_add_button_crear.setBackgroundColor(ContextCompat.getColor(this,R.color.colorEnabled));
        }
        else {
            product_add_button_crear.setEnabled(false);
            product_add_button_crear.setBackgroundColor(ContextCompat.getColor(this,R.color.colorDisabled));
        }
    }

    public void showProductList( final Product p ){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ProductAddActivity.this, "Insertado con código "+p.getId()+":"+p.getName(), Toast.LENGTH_LONG).show();
                ProductAddActivity.this.finish();
            }
        });
    }

}
