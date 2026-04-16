package com.ghost.browser;

import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        // WebView-ді тауып, оған "авто-рұқсат" логикасын қосамыз
        WebView webView = this.bridge.getWebView();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                // Бұл жерде ешқандай диалог терезесі шықпайды
                runOnUiThread(() -> {
                    request.grant(request.getResources());
                });
            }
        });
    }
}
