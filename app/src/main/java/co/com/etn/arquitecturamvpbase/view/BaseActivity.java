package co.com.etn.arquitecturamvpbase.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import co.com.etn.arquitecturamvpbase.helper.IValidateInternet;
import co.com.etn.arquitecturamvpbase.helper.ValidateInternet;
import co.com.etn.arquitecturamvpbase.presenter.BasePresenter;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public class BaseActivity <T extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private IValidateInternet validateInternet;
    private ProgressDialog progressDialog;
    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validateInternet = new ValidateInternet(this);
    }

    @Override
    public void showProgress(int message) {
        progressDialog.setMessage( getResources().getString(message) );
        progressDialog.show();
    }

    public void createProgressDialog(){
        progressDialog = new ProgressDialog( this );
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }

    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
