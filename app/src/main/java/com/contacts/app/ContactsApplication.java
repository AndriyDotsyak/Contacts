package com.contacts.app;

import android.app.Application;

import com.contacts.app.util.Constants;

import dagger.hilt.android.HiltAndroidApp;
import io.reactivex.plugins.RxJavaPlugins;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

@HiltAndroidApp
public class ContactsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initRealm();
        initTimber();
        initRx();
    }

    private void initTimber() {
        // TODO Init timber
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(Constants.DATABASE_NAME)
                .deleteRealmIfMigrationNeeded()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();

        Realm.setDefaultConfiguration(configuration);
    }

    private void initRx() {
        RxJavaPlugins.setErrorHandler(Timber::e);
    }

}
