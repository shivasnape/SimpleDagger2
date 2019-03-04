package com.snape.shivichu.simpledagger2.component;

import com.snape.shivichu.simpledagger2.activity.MainActivity;
import com.snape.shivichu.simpledagger2.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {AppModule.class})
public interface BasicComponent {
    void inject(MainActivity activity);
}
