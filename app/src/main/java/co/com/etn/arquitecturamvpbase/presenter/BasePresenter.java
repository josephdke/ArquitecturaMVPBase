package co.com.etn.arquitecturamvpbase.presenter;

import co.com.etn.arquitecturamvpbase.helper.IValidateInternet;
import co.com.etn.arquitecturamvpbase.view.IBaseView;

/**
 * Created by jose.cardenas on 16/09/2017.
 */

public class BasePresenter <T extends IBaseView> {

    private T view;
    private IValidateInternet validateInternet;

    public void inject( T view, IValidateInternet validateInternet ){
        this.view = view;
        this.validateInternet = validateInternet;
    }

    public T getView() {
        return view;
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }

}
