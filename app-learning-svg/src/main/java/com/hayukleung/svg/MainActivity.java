package com.hayukleung.svg;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.hayukleung.svg.databinding.ActivityMainBinding;

/**
 * SVG
 * <p>
 * liangxiaxu@aobi.com
 * 2017-12-06 15:41
 */
public class MainActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_christmas_hat);
        binding.textView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
    }
}
