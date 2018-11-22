package tpfd.techcom.com.faultdetectorapp;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AppWebViewClient extends WebViewClient {

    private ProgressBar progressBar;

    public AppWebViewClient(ProgressBar progressBar) {
        this.progressBar=progressBar;
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        progressBar.setVisibility(view.GONE);
    }
}
