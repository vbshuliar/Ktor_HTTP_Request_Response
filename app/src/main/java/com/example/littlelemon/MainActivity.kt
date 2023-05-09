package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient
import io.ktor.client.engine.android.Android

class MainActivity : ComponentActivity() {
    private val responseLiveData = MutableLiveData<String>()
    private val httpClient = HttpClient(Android)
    private suspend fun fetchContent(url: String): HttpResponse {
        return httpClient.get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/littleLemonMenu.json")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    var responseState = responseLiveData.value
                    Column {
                        Button(
                            onClick = {

                            }
                        ) {
                            Text(text = "Download")
                        }
                    }
                }
            }
        }
    }
}
