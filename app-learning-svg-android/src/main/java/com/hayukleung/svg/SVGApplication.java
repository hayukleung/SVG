package com.hayukleung.svg;

import android.app.Application;

import com.github.megatronking.svg.sample.drawables.SVGLoader;

/**
 * SVG
 * <p>
 * liangxiaxu@aobi.com
 * 2017-12-07 15:01
 */

public class SVGApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SVGLoader.load(this);
    }
}
