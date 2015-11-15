package com.lovejjfg.myrecycleview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lovejjfg.myrecycleview.adapter.SampleAdapter;
import com.lovejjfg.myrecycleview.ui.MyWebView;

import java.util.ArrayList;
import java.util.List;

public class MyWebViewActivity extends AppCompatActivity {

    private MyWebView myWeb;
    private ProgressBar mPB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        myWeb = (MyWebView) findViewById(R.id.web);
        mPB = (ProgressBar) findViewById(R.id.pb);
        mPB.setMax(100);
        WebSettings settings = myWeb.getSettings();
        settings.setJavaScriptEnabled(true);

        myWeb.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mPB.setProgress(newProgress);
            }
        });
        myWeb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("baidu")) {
                    Toast.makeText(MyWebViewActivity.this, "baidu", 0).show();
                }
                view.loadUrl(url);
                return true;
            }

        });

        myWeb.loadUrl("https://www.baidu.com/");
        Log.e("kkkkkkk", "xxxxxxxxxxxxxx");

    }
}
