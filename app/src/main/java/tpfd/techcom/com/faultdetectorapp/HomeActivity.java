package tpfd.techcom.com.faultdetectorapp;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class HomeActivity extends AppCompatActivity {

    private WebView webView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Boolean isFirstRun;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        isFirstRun = getSharedPreferences("PREFERENCES",MODE_PRIVATE).getBoolean("isFirstRun",true);

        if (isFirstRun){
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            finish();
        }

        progressBar = findViewById(R.id.progressBar);

        swipeRefreshLayout = findViewById(R.id.swipeContainer);

        webView = findViewById(R.id.web_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://192.168.1.150:8000/dashboard/#");

        webView.setWebViewClient(new AppWebViewClient(progressBar));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}
