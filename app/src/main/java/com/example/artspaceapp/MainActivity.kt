package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceAppLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceAppLayout() {

    Column(
        modifier = Modifier
            //.statusBarsPadding()
            .padding(horizontal = 24.dp)
            .border(4.dp, Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp, 8.dp, 16.dp, 4.dp)
                .weight(5.0f, true)
                .border(4.dp, Red),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ArtWorkWall()
        }
        Row(
            modifier = Modifier
                .padding(16.dp, 4.dp, 16.dp, 4.dp)
                .weight(2.0f, true)
                .border(4.dp, Red)
        ) {
            ArtworkDescriptor()
        }
        Row(
            modifier = Modifier
                .padding(16.dp, 4.dp, 16.dp, 12.dp)
                .weight(1.0f, true)
                .border(4.dp, Red)
        ) {
            DisplayController()
        }

    }
}

@Composable
fun ArtWorkWall() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 64.dp),
    ) {
        Image(
            modifier = Modifier
                .padding(16.dp, 8.dp, 16.dp, 16.dp)
                .border(2.dp, Black),
            painter = painterResource(id = R.drawable.img6),
            contentScale = ContentScale.Crop,
            contentDescription = null//TODO: need to be set for each image description
        )
    }
}

@Composable
fun ArtworkDescriptor() {
    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .fillMaxSize()
            .border(2.dp, Black),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .border(1.dp, Color.Gray)
                .fillMaxWidth(),
            text = "Artwork Title",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            modifier = Modifier
                .border(1.dp, Color.Gray)
                .fillMaxWidth(),
            text = "Artwork Artist (Year)",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DisplayController() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .border(2.dp, Black),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(12.dp, 8.dp)
                //.border(2.dp, Color.Blue)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(12.dp, 8.dp)
                //.border(2.dp, Color.Blue)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceAppLayout()
    }
}