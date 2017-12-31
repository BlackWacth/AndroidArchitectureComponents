package com.bruce.components.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.bruce.components.model.Comment;

import java.util.Date;

/**
 * Created by Hua on 2017/12/29.
 */

@Entity(tableName = "comments",
        indices = {@Index(value = "productId")},
        foreignKeys = {@ForeignKey(entity = ProductEntity.class, parentColumns = "id", childColumns = "productId", onDelete = ForeignKey.CASCADE)})
public class CommentEntity implements Comment {

    private int id;
    private int productId;
    private String text;
    private Date postedAt;

    public CommentEntity() {

    }

    public CommentEntity(int id, int productId, String text, Date postedAt) {
        this.id = id;
        this.productId = productId;
        this.text = text;
        this.postedAt = postedAt;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }
}
