package com.example.heroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.HeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeroesTheme {

            }
        }
    }
}

@Composable
fun HeroItem(modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Text("Olá Mundo")
    }
}

@Preview(showBackground = true)
@Composable
fun HeroPreview() {
    HeroesTheme {
        HeroItem()
    }
}