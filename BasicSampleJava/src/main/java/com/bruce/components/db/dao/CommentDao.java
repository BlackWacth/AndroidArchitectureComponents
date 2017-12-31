package com.bruce.components.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bruce.components.db.entity.CommentEntity;

import java.util.List;

/**
 * Created by Hua on 2017/12/29.
 */

@Dao
public interface CommentDao {

    @Query("select * from comments where productId = :productId")
    LiveData<List<CommentEntity>> loadComments(int productId);

    @Query("select * from comments where productId = :productId")
    List<CommentEntity> loadCommentsSync(int productId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CommentEntity> products);

}
