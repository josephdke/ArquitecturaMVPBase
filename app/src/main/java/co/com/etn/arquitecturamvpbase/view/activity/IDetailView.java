package co.com.etn.arquitecturamvpbase.view.activity;

import co.com.etn.arquitecturamvpbase.view.IBaseView;

/**
 * Created by jose.cardenas on 19/09/2017.
 */

public interface IDetailView extends IBaseView {

    void showProductList();

    void showAlertDialog(int validate_internet);

    void showToast(int delete_correct);

    void showAlertDialogError(int error);
}
