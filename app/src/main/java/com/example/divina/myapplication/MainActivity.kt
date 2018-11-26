package com.example.divina.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the support action bar
        val actionBar = supportActionBar
        val contenido = this

        // Set the action bar title, subtitle and elevation
        actionBar!!.title = "Kotlin"
        actionBar.subtitle = "by Divi"
        actionBar.elevation = 4.0F

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
}