package tpfd.techcom.com.faultdetectorapp;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AppWebViewClient extends WebViewClient {

    private ProgressBar progressBar;
    private TextView appNameTextView, waitTextView;

    public AppWebViewClient(ProgressBar progressBar, TextView appNameTextView, TextView waitTextView) {
        this.progressBar=progressBar;
        this.appNameTextView=appNameTextView;
        this.waitTextView=waitTextView;
        appNameTextView.setVisibility(View.VISIBLE);
        waitTextView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        appNameTextView.setVisibility(view.GONE);
        waitTextView.setVisibility(view.GONE);
        progressBar.setVisibility(view.GONE);
    }
}
