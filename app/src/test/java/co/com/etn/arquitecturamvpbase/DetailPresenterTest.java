package co.com.etn.arquitecturamvpbase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.etn.arquitecturamvpbase.helper.IValidateInternet;
import co.com.etn.arquitecturamvpbase.model.DeleteResponse;
import co.com.etn.arquitecturamvpbase.presenter.DetailPresenter;
import co.com.etn.arquitecturamvpbase.repository.IProductRepository;
import co.com.etn.arquitecturamvpbase.view.activity.IDetailView;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jose.cardenas on 23/09/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class DetailPresenterTest {

    @Mock
    IValidateInternet validateInternet;

    @Mock
    IProductRepository productRepository;

    @Mock
    IDetailView detailView;

    DetailPresenter detailPresenter;

    @Before
    public void setUp() throws Exception {
        detailPresenter = Mockito.spy( new DetailPresenter( productRepository ) );
        detailPresenter.inject( detailView, validateInternet );
    }

    @Test
    public void methodDeleteProductWithConnectionShouldCallMethodCreateThreadDeleteProduct(){
        String id = "12313gh";
        when( validateInternet.isConnected() ).thenReturn(true);
        detailPresenter.deleteProduct(id);
        verify(detailPresenter).createThreadDeleteProduct(id);
        verify(detailView,never()).showAlertDialog(R.string.validate_internet);
    }

    @Test
    public void methodDeleteProductWithouConnectionShouldCallMethodCreateThreadDeleteProduct(){
        String id = "12313gh";
        when( validateInternet.isConnected() ).thenReturn(false);
        detailPresenter.deleteProduct(id);
        verify(detailView).showAlertDialog(R.string.validate_internet);
        verify(detailPresenter,never()).createThreadDeleteProduct(id);
    }

    @Test
    public void methodDeleteProductShouldCallMethodDeleteProductInRepositoryTrue(){
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setStatus(true);
        String id = "12313gh";
        when(productRepository.deleteProduct(id)).thenReturn(deleteResponse);
        detailPresenter.deleteProductRepository(id);
        Assert.assertTrue(deleteResponse.isStatus());
        verify(detailView).showToast(R.string.delete_correct);
        verify(detailView,never()).showAlertDialogError(R.string.error);
    }

    @Test
    public void methodDeleteProductShouldCallMethodDeleteProductInRepositoryFalse(){
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setStatus(false);
        String id = "12313gh";
        when(productRepository.deleteProduct(id)).thenReturn(deleteResponse);
        detailPresenter.deleteProductRepository(id);
        Assert.assertFalse(deleteResponse.isStatus());
        verify(detailView).showAlertDialogError(R.string.error);
        verify(detailView,never()).showToast(R.string.delete_correct);
    }

}
