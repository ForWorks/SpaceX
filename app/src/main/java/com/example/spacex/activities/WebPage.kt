package com.example.spacex.activities

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.example.spacex.R
import com.example.spacex.classes.Constants

class WebPage : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var nameField: TextView
    private lateinit var url: String
    private lateinit var name: String

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        getIntentData()
        init()

        webView.webViewClient = MyWebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

    private fun init() {
        webView = findViewById(R.id.webView)
        nameField = findViewById(R.id.name)
        nameField.text = name
    }

    private fun getIntentData() {
        val extras = intent.extras
        if (extras != null) {
            url = extras.getString(Constants.ROCKET_URL).toString()
            name = extras.getString(Constants.ROCKET_NAME).toString()
        }
    }

    private class MyWebViewClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            view.loadUrl(request.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}