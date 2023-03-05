package com.contacts.base;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

public abstract class BaseRepository {

    public Consumer<Throwable> logRequestError(String reques) {
        return throwable -> Timber.e(throwable, "Request failed: %s", reques);
    }

}
