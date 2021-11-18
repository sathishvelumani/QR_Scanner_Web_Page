package com.project.qrscannerwebpage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_page.*

class WebPage : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_page)

        pageReference.webViewClient = MyBrowser()
        pageReference.settings.javaScriptEnabled = true
        pageReference.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        pageReference.loadUrl(intent.getStringExtra("page").toString())

    }

    private class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}