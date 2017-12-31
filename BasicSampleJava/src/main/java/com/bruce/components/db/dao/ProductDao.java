package com.bruce.components.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bruce.components.db.entity.ProductEntity;

import java.util.List;

/**
 * Created by Hua on 2017/12/29.
 */
@Dao
public interface ProductDao {

    @Query("select * from products")
    LiveData<List<ProductEntity>> loadAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ProductEntity> products);

    @Query("select * from products where productId = :productId")
    LiveData<ProductEntity> loadProduct(int productId);

    @Query("select * from products where productId = :productId")
    ProductEntity loadProductSync(int productId);

}
