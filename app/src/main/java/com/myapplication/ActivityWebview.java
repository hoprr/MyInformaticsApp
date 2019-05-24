package com.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.myapplication.connection.ConnectionDetector;


public class ActivityWebview extends AppCompatActivity {

    ConnectionDetector cd;
    private WebView fweBview;
    private WebSettings webSettings;
    ProgressBar progressBar;
    Boolean isInternetPresent = false;
    String url =AllConstants.webViewUrl;
    String title =AllConstants.webViewTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_webview);
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
//        getSupportActionBar().setTitle(title); // set the top title
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
  //      getSupportActionBar().setDisplayUseLogoEnabled(true);

        cd = new ConnectionDetector(this);
        progressBar = (ProgressBar) findViewById(R.id.smoothProgressbar);
       // final TextView toptitle = (TextView) findViewById(R.id.toptitle);
       //   toptitle.setText(AllConstants.topTitle.toString().trim());
        isInternetPresent = cd.isConnectingToInternet();
        try {
            if (!isInternetPresent) {
                showInternetAlert();
            }
            updateWebView(url);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    void showInternetAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You don't have Internet Connection.")
                .setCancelable(false)
                .setPositiveButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                .setNegativeButton("Retry",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                startActivity(getIntent());
                            }
                        });

        // Creating dialog box
        AlertDialog alert = builder.create();
        // Setting the title manually
        alert.setTitle("Internet Connection");
        alert.show();

    }
    private class HelloWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            progressBar.setVisibility(View.GONE);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && fweBview.canGoBack()) {
            fweBview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
    private void updateWebView(String url) {
        // TODO Auto-generated method stub

        fweBview = (WebView) findViewById(R.id.fbwebView);
        fweBview.getSettings().setJavaScriptEnabled(true);
        fweBview.getSettings().setDomStorageEnabled(true);
        fweBview.getSettings().setPluginState(WebSettings.PluginState.ON);
        webSettings = fweBview.getSettings();

        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setBuiltInZoomControls(true);

        //fweBview.getSettings().setPluginsEnabled(true);
        fweBview.loadUrl(url);

        fweBview.setWebViewClient(new HelloWebViewClient());

    }

    public void btnHome(View v) {

  /*  Intent next = new Intent(this, ActivityItemMultiSelect.class);
        next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(next);*/

    }

    public void btnBack(View v) {
        finish();

    }
}


















