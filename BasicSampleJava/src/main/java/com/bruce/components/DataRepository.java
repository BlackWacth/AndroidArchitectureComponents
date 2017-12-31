package com.bruce.components;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.bruce.components.db.AppDatabase;
import com.bruce.components.db.entity.CommentEntity;
import com.bruce.components.db.entity.ProductEntity;

import java.util.List;

/**
 * Created by Hua on 2017/12/29.
 */

public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;

    private MediatorLiveData<List<ProductEntity>> mObservableProducts;

    private DataRepository(AppDatabase database) {
        mDatabase = database;
        mObservableProducts = new MediatorLiveData<>();
        mObservableProducts.addSource(mDatabase.productDao().loadAllProducts(), productEntities -> {
            if (mDatabase.getDatabaseCreated().getValue() != null) {
                mObservableProducts.postValue(productEntities);
            }
        });
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }

    public LiveData<List<CommentEntity>> loadComments(int productId) {
        return mDatabase.commentDao().loadComments(productId);
    }

    public LiveData<ProductEntity> loadProduct(int productId) {
        return mDatabase.productDao().loadProduct(productId);
    }
}
