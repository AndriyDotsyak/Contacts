package com.contacts.base;

public interface BaseContract {

    interface View {
        void onProgress(boolean isProgress);
        void showToast(String text);
    }

    interface Presenter {
        void onCreate();
        void onStart();
        void onStop();
        void onDestroy();
    }

}
