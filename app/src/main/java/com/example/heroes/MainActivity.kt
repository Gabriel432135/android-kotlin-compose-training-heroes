package com.example.heroes

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.compose.HeroesTheme
import com.example.heroes.model.Hero
import com.example.heroes.model.Hero.HeroesRepository.heroes

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
fun HeroList(modifier: Modifier = Modifier) {
    LazyColumn( modifier = modifier
        .padding(16.dp)) {
        items(heroes){
            HeroItem(hero = it)
        }
    }
}

@Composable
fun HeroItem(modifier: Modifier = Modifier, hero: Hero){


    Card(modifier = modifier
        .height(88.dp)
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.small),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp)
    )

    {
        Row(modifier = Modifier.padding(16.dp)){
            Column {
                Text(text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall)
                Text(text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(Modifier.weight(2f).width(16.dp))

            Image(
                modifier =
                    Modifier
                        .clip(MaterialTheme.shapes.small)
                        .height(72.dp),
                //painter = rememberAsyncImagePainter(painterResource(hero.imageRes)),
                painter = painterResource(hero.imageRes),
                contentDescription = null)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroPreview() {
    HeroesTheme {
        HeroList()
    }
}