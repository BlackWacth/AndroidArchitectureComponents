package com.bruce.components.model;

import java.util.Date;

/**
 * Created by Hua on 2017/12/29.
 */
public interface Comment {

    int getId();

    int getProductId();

    String getText();

    Date getPostedAt();

}
