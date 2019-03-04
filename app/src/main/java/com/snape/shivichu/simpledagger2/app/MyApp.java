package com.snape.shivichu.simpledagger2.app;

import android.app.Application;

import com.snape.shivichu.simpledagger2.component.BasicComponent;
import com.snape.shivichu.simpledagger2.component.DaggerBasicComponent;
import com.snape.shivichu.simpledagger2.module.AppModule;


public class MyApp extends Application {
    private static MyApp app;
    private AppModule appModule;
    private BasicComponent basicComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        appModule = new AppModule(this);
        basicComponent = DaggerBasicComponent.builder()
                .appModule(appModule)
                .build();
    }

    public static MyApp app() {
        return app;
    }

    public AppModule appModule() {
        return appModule;
    }

    public BasicComponent basicComponent() {
        return basicComponent;
    }
}
