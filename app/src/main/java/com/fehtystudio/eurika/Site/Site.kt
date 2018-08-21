package com.fehtystudio.eurika.Site

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.site.*
import java.io.File


class Site : android.support.v4.app.Fragment() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var forwardPage: ImageButton
    private lateinit var backPage: ImageButton
    private var url: String = "http://eureka-school.ru"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView: View = inflater.inflate(R.layout.site, container, false)

        val toolbarTop = rootView.findViewById(R.id.toolbar_top) as android.support.v7.widget.Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbarTop)
        toolbarTop.title = null
        return rootView
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        progressBar = view.findViewById(R.id.progressBar)
        forwardPage = view.findViewById(R.id.forwardPage)
        backPage = view.findViewById(R.id.backPage)

        File(activity?.getExternalFilesDir(null), "fileName.html")
        webView = view.findViewById(R.id.webView)
        webView.settings.setSupportZoom(true)

        webView.settings.setAppCachePath(activity?.cacheDir?.absolutePath)
        webView.settings.allowFileAccess = true
        webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webView.settings.javaScriptEnabled = true
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.settings.loadWithOverviewMode = true
        webView.settings.setAppCacheEnabled(true)
        webView.settings.setAppCachePath(activity?.cacheDir?.absolutePath)
        webView.settings.allowFileAccess = true
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
        webView.settings.javaScriptCanOpenWindowsAutomatically = true

        webView.webViewClient = MyWebViewClient()
        webView.webChromeClient = MyWebChromeClient()

        webView.loadUrl(url)

        WebAction()

        backPage.setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            }
        }

        reloadPage.setOnClickListener {
            webView.reload()
        }

        forwardPage.setOnClickListener {
            if (webView.canGoForward()) {
                webView.goForward()
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        webView.restoreState(savedInstanceState)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun WebAction() {
        webView.settings.javaScriptEnabled = true
        webView.settings.setAppCacheEnabled(true)
        webView.loadUrl(url)
        webView.webViewClient = object : WebViewClient() {

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
                Toast.makeText(activity, "Проверьте доступ к сети Интернет", Toast.LENGTH_SHORT).show()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressBar.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE

                if (!webView.canGoForward()) {
                    forwardPage.setImageResource(R.drawable.forward_page_disabled)
                    forwardPage.isEnabled = false
                }
                if (!webView.canGoBack()) {
                    backPage.setImageResource(R.drawable.back_page_disabled)
                    backPage.isEnabled = false
                }
                if (webView.canGoForward()) {
                    forwardPage.setImageResource(R.drawable.forward_page)
                    forwardPage.isEnabled = true
                }
                if (webView.canGoBack()) {
                    backPage.setImageResource(R.drawable.back_page)
                    backPage.isEnabled = true
                }

                super.onPageFinished(view, url)
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
    }

    private inner class MyWebChromeClient : WebChromeClient() {
        override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
            super.onShowCustomView(view, callback)
        }
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }
    }

}