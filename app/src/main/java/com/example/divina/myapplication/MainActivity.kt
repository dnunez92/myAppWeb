package com.example.divina.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview.settings.javaScriptEnabled = true
        webview.settings.setSupportZoom(false)
        webview.webChromeClient = WebChromeClient()
        webview.webViewClient =object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }
//
//        val preferences = PreferenceManager.getDefaultSharedPreferences(this.baseContext)
//
//        val mpreferences = preferences.getString("mpreferences", "DEFAULT")

        val text = edtUrl
        val boton = btnIr

//        boton.setOnClickListener {
//            fun onclick (Client: WebViewClient) {
//                PreferenceManager.getDefaultSharedPreferences(this@MainActivity).edit()
//                val editor = preferences.edit()
//                editor.putString("mpreferences", edtUrl.text.toString())
//                editor.commit()
//            }
//        }


        // Get the support action bar
        setSupportActionBar(include_toolbar as Toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val contenido = this

        // Set the action bar title, subtitle and elevation


        supportActionBar?.elevation = 4.0F

        btnIr.setOnClickListener {
            webview.loadUrl("https://"+ edtUrl.text.toString())
        }

        btnAtras.setOnClickListener{
            if (webview.canGoBack())
                webview.goBack()
            else
                Toast.makeText(contenido, "No hay historial disponible", Toast.LENGTH_SHORT).show()
        }

        btnSiguiente.setOnClickListener{
            if (webview.canGoForward())
                webview.goForward()
            else
                Toast.makeText(contenido, "No hay historial disponible", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.favoritos -> {

                return true
            }
            R.id.pestanhas -> {

                return true
            }
            R.id.ajustes -> {

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


//     override fun onResume() {
//         var preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
//         var info_preferencias = preferencias.getString("info_actividad", "Sin informacion");
//         Toast.makeText(this, info_preferencias, Toast.LENGTH_LONG).show();
//    }




}


























