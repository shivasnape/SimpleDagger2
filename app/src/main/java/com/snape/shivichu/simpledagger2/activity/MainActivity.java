package com.snape.shivichu.simpledagger2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.snape.shivichu.simpledagger2.R;
import com.snape.shivichu.simpledagger2.app.MyApp;
import com.snape.shivichu.simpledagger2.model.ObjectManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity {
    @BindView(R.id.image) ImageView imageView;
    @Inject
    ObjectManager objectManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApp.app().basicComponent().inject(this);
        ButterKnife.bind(this);

        String link = objectManager.get("link", String.class);
        if(link==null){
            link = "https://image.ibb.co/gfmwVK/image.jpg";
            objectManager.save("link", link);
        }

        Glide.with(this).load(link).into(imageView);
    }
}
