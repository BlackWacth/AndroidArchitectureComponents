package com.bruce.components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import com.bruce.components.BasicApp;
import com.bruce.components.db.entity.ProductEntity;

import java.util.List;

/**
 * Created by Hua on 2017/12/29.
 */
public class ProductListViewModel extends AndroidViewModel {

    private final MediatorLiveData<List<ProductEntity>> mObservableProducts;

    public ProductListViewModel(@NonNull Application application) {
        super(application);
        mObservableProducts = new MediatorLiveData<>();
        mObservableProducts.setValue(null);

        LiveData<List<ProductEntity>> products = ((BasicApp) application).getRepository().getProducts();
        mObservableProducts.addSource(products, mObservableProducts::setValue);
    }

    public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }
}
