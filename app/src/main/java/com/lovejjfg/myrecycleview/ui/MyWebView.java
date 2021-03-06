package com.lovejjfg.myrecycleview.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;

import com.lovejjfg.myrecycleview.R;

/**
 * Created by Administrator on 2015/10/29.
 */
public class MyWebView extends WebView {

    private View inflate;
    private int headHeight;

    public MyWebView(Context context) {
        this(context, null);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        inflate = View.inflate(context, R.layout.header_layout, null);
        addView(inflate);
        inflate.measure(0, 0);
        headHeight = inflate.getMeasuredHeight();
        inflate.setPadding(0, -headHeight, 0, 0);
        requestLayout();


    }
}
