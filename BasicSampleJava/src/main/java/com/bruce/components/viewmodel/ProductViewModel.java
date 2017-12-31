package com.bruce.components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.bruce.components.BasicApp;
import com.bruce.components.DataRepository;
import com.bruce.components.db.entity.CommentEntity;
import com.bruce.components.db.entity.ProductEntity;

import java.util.List;

/**
 * Created by Hua on 2017/12/29.
 */

public class ProductViewModel extends AndroidViewModel{

    public ObservableField<ProductEntity> product = new ObservableField<>();

    private final LiveData<ProductEntity> mObservableProduct;

    private final int mProductId;

    private final LiveData<List<CommentEntity>> mObservableComments;

    public ProductViewModel(@NonNull Application application, DataRepository repository, final int productId) {
        super(application);
        mProductId = productId;
        mObservableComments = repository.loadComments(mProductId);
        mObservableProduct = repository.loadProduct(mProductId);
    }

    public LiveData<List<CommentEntity>> getComments() {
        return mObservableComments;
    }

    public LiveData<ProductEntity> getObservableProduct() {
        return mObservableProduct;
    }

    public void setProduct(ProductEntity product) {
        this.product.set(product);
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        @NonNull
        private final Application mApplication;
        private final int mProductId;
        private final DataRepository mRepository;

        public Factory(@NonNull Application application, int productId) {
            mApplication = application;
            mProductId = productId;
            mRepository = ((BasicApp)application).getRepository();
        }

        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T)new ProductViewModel(mApplication, mRepository, mProductId);
        }
    }
}
