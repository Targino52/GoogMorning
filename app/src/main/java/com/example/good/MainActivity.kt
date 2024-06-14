package com.example.good

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.good.ui.theme.GoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoodTheme {
                MyScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyscreenPreview() {
    GoodTheme {
        MyScreen()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen() {
    var name by remember { mutableStateOf("") } // Estado para o nome
    var nameTextChange by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bom dia") }, // Título dinâmico
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Face,
                            contentDescription = "Localized description"
                        )
                    }
                },

                )
        },

        modifier = Modifier.padding(end = 16.dp)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row (modifier = Modifier.fillMaxWidth().padding(start = 8.dp, bottom = 8.dp)){
                Text(text = "Meu nome é ${name}")
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                verticalAlignment = Alignment.CenterVertically){
                IconButton(modifier = Modifier.align(Alignment.CenterVertically), onClick = {
                    name = nameTextChange })
                {

                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Localized description",
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterVertically)

                    )
                }

                OutlinedTextField(
                    value = name,
                    onValueChange = { nameTextChange = it },
                    //label = { Text("Digite seu nome") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

    }
}
