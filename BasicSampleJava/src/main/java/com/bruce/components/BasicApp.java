package com.bruce.components;

import android.app.Application;

import com.bruce.components.db.AppDatabase;
import com.bruce.components.db.DataGenerator;

/**
 * Created by Hua on 2017/12/29.
 */

public class BasicApp extends Application{

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }
}
