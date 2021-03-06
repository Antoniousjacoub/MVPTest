/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.example.it.mvptest.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.it.mvptest.data.network.model.BlogResponse;
import com.example.it.mvptest.data.network.model.OpenSourceResponse;
import com.example.it.mvptest.di.ActivityContext;
import com.example.it.mvptest.di.PerActivity;
import com.example.it.mvptest.ui.main.login.LoginMvpPresenter;
import com.example.it.mvptest.ui.main.login.LoginMvpView;
import com.example.it.mvptest.ui.main.login.LoginPresenter;
import com.example.it.mvptest.ui.main.main.MainMvpPresenter;
import com.example.it.mvptest.ui.main.main.MainMvpView;
import com.example.it.mvptest.ui.main.main.MainPresenter;
import com.example.it.mvptest.ui.main.main.rate.RatingDialogMvpPresenter;
import com.example.it.mvptest.ui.main.main.rate.RatingDialogMvpView;
import com.example.it.mvptest.ui.main.main.rate.RatingDialogPresenter;
import com.example.it.mvptest.ui.main.splash.SplashMvpPresenter;
import com.example.it.mvptest.ui.main.splash.SplashMvpView;
import com.example.it.mvptest.ui.main.splash.SplashPresenter;
import com.example.it.mvptest.utils.rx.AppSchedulerProvider;
import com.example.it.mvptest.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }



    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }


}
