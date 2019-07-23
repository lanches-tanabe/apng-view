package com.github.sahasbhop.apngview.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.github.sahasbhop.apngview.ApngDrawable;
import com.github.sahasbhop.apngview.ApngImageLoader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_view_pager).setOnClickListener(this);
        findViewById(R.id.button_list_view).setOnClickListener(this);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApngDrawable drawable = ApngDrawable.getFromView(view);
                boolean isStart = !drawable.isRunning();

                if (isStart) {
                    drawable.start();
                } else {
                    drawable.stop();
                }
            }
        });
        ApngImageLoader.getInstance().displayApng("http://ics-web.jp/lab-data/140930_apng/images/elephant_apng_zopfli.png",
            imageView,
            new ApngImageLoader.ApngConfig(0, true, false));
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button_view_pager:
                intent = new Intent(this, ViewPagerActivity.class);
                break;
            case R.id.button_list_view:
                intent = new Intent(this, ListViewActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
