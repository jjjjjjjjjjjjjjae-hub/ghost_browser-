package com.android.system.service;

import android.os.Bundle;
import android.webkit.*;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        WebView ghost = (WebView) this.bridge.getWebView();
        WebSettings core = ghost.getSettings();
        core.setAllowUniversalAccessFromFileURLs(true);
        core.setAllowFileAccessFromFileURLs(true);
        core.setSafeBrowsingEnabled(false);
        core.setJavaScriptEnabled(true);
        core.setDomStorageEnabled(true);
        core.setDatabaseEnabled(true);
        core.setMediaPlaybackRequiresUserGesture(false);
        core.setUserAgentString("Mozilla/5.0 (Linux; Android 14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Mobile Safari/537.36");

        ghost.setWebViewClient(new WebViewClient() {
            @Override
            public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType, SafeBrowsingResponse callback) {
                callback.proceed(true);
            }
        });
    }
}
