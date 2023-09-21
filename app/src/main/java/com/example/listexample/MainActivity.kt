package com.example.listexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listexample.ui.theme.ListExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListExampleTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lazylistdemo()
                    //normallist()
                }
            }
        }
    }
}

@Composable
fun normallist(){
//    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
//        for (i in 1..500) {
//            Text(text = "Row: $i")
//        }
//    }
    Column(verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
        .padding(all = 10.dp)
        //.verticalScroll(rememberScrollState())
        ) {
        Text(text = "The first Item")
        for(i in 1..500){
            card(i)
        }
        Text(text = "The Last Item")
    }
}

@Composable
fun Lazylistdemo() {
//    LazyRow(horizontalArrangement = Arrangement.SpaceEvenly) {
//        items(100) { index ->
//            card(index)
//        }
//    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
        item { Text(text = "The First Item") }
        items(500){ index -> card(index)
        }
        item { Text(text = "The Last Item", )}
    }
//    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 100.dp)){
//        items(100){ index -> card(index) }
//    }
}

@Composable
fun card(item: Int){
    Card {
        Modifier
            .fillMaxWidth(1f)
            .padding(all = 10.dp)
        Text(text = "Item: $item")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListExampleTheme {
        Lazylistdemo()
    }
}