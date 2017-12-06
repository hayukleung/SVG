package com.hayukleung.svg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * SVG
 * <p>
 * liangxiaxu@aobi.com
 * 2017-12-06 16:32
 */

public class VectorDrawable2BitmapView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;

    public VectorDrawable2BitmapView(Context context) {
        this(context, null);
    }

    public VectorDrawable2BitmapView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VectorDrawable2BitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VectorDrawable2BitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap = getBitmapFromVectorDrawable(getContext(), R.drawable.ic_christmas_hat);
    }

    private Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = MeasureSpec.makeMeasureSpec(mBitmap.getWidth(), MeasureSpec.EXACTLY);
        int measuredHeight = MeasureSpec.makeMeasureSpec(mBitmap.getHeight(), MeasureSpec.EXACTLY);
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }
}
