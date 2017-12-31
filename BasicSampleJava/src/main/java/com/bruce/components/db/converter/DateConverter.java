package com.bruce.components.db.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 *
 * Created by Hua on 2017/12/29.
 */
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

}
