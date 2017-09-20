package co.com.etn.arquitecturamvpbase.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.etn.arquitecturamvpbase.R;
import co.com.etn.arquitecturamvpbase.model.Product;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public class ProductAdapter extends ArrayAdapter <Product> {

    private List<Product> productArrayList;
    private Activity context;
    private int resource;
    private Product product;
    TextView name;

    public ProductAdapter( @NonNull Activity context, int resource, @NonNull List<Product> productArrayList ) {
        super( context, resource, productArrayList );
        this.context = context;
        this.productArrayList = productArrayList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        product = productArrayList.get( position );
        loadView( convertView );
        name.setText( product.getName() );
        return convertView;
    }

    private void loadView( View convertView ){
        name = (TextView) convertView.findViewById( R.id.item_name_product );
    }

}
