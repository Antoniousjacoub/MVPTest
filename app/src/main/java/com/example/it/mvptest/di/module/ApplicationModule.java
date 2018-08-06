package com.example.it.mvptest.di.module;

import android.app.Application;
import android.content.Context;




import com.example.it.mvptest.R;
import com.example.it.mvptest.data.AppDataManager;
import com.example.it.mvptest.data.DataManager;
import com.example.it.mvptest.data.db.AppDbHelper;
import com.example.it.mvptest.data.db.DbHelper;
import com.example.it.mvptest.data.network.ApiHeader;
import com.example.it.mvptest.data.network.ApiHelper;
import com.example.it.mvptest.data.network.AppApiHelper;
import com.example.it.mvptest.data.prefs.AppPreferencesHelper;
import com.example.it.mvptest.data.prefs.PreferencesHelper;
import com.example.it.mvptest.di.ApiInfo;
import com.example.it.mvptest.di.ApplicationContext;
import com.example.it.mvptest.di.DatabaseInfo;
import com.example.it.mvptest.di.PreferenceInfo;
import com.example.it.mvptest.utils.AppConstants;
import com.example.it.mvptest.utils.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
