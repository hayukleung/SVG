package com.hayukleung.svg;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.megatronking.svg.sample.drawables.christmas_hat;
import com.github.megatronking.svg.support.SVGDrawable;
import com.hayukleung.svg.databinding.ActivitySvgBinding;

/**
 * SVG
 * <p>
 * liangxiaxu@aobi.com
 * 2017-12-07 15:02
 */

public class SVGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySvgBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_svg);
        Drawable drawable = new SVGDrawable(new christmas_hat(this));
        binding.imageView.setImageDrawable(drawable);
    }
}
