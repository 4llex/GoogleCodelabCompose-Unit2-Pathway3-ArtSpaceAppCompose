package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceAppLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceAppLayout() {
    var currentStep by remember { mutableIntStateOf(6) }

    val imgContent = getState(currentStep)

    Column(
        modifier = Modifier
            //.statusBarsPadding()
            .padding(horizontal = 24.dp),
            //.border(4.dp, Color.Magenta)
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp, 8.dp, 16.dp, 4.dp)
                .weight(5.0f, true),
                //.border(4.dp, Red),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ArtWorkWall(imgContent.imageResource, imgContent.imgContentDescription)
        }
        Row(
            modifier = Modifier
                .padding(16.dp, 4.dp, 16.dp, 4.dp)
                .weight(2.0f, true),
                //.border(4.dp, Red)
        ) {
            ArtworkDescriptor(imgContent.artworkTitle, imgContent.artworkArtist)
        }
        Row(
            modifier = Modifier
                .padding(16.dp, 4.dp, 16.dp, 12.dp)
                .weight(1.0f, true),
                //.border(4.dp, Red)
        ) {
            DisplayController(
                { currentStep = if (currentStep == 7) 1 else currentStep.plus(1) },
                { currentStep = if (currentStep == 1) 7 else currentStep.dec() }
            )
        }

    }
}

@Composable
fun ArtWorkWall(
    imageResource: Int,
    imgContentDescription: Int,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 64.dp),
    ) {
        Image(
            //modifier = Modifier
                //.padding(16.dp, 8.dp, 16.dp, 16.dp),
                //.border(2.dp, Black),
            painter = painterResource(imageResource),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = imgContentDescription)
        )
    }
}

@Composable
fun ArtworkDescriptor(artworkTitle: Int, artworkArtist: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color(0xFFEAE0FF), RoundedCornerShape(12.dp))
            .padding(16.dp, 16.dp)
            .fillMaxSize(),
            //.border(2.dp, Black),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                //.border(1.dp, Color.Gray)
                .fillMaxWidth(),
            text = stringResource(id = artworkTitle),
            textAlign = TextAlign.Center,
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            modifier = Modifier
                //.border(1.dp, Color.Gray)
                .fillMaxWidth(),
            text = stringResource(id = artworkArtist),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DisplayController(
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
            //.border(2.dp, Black),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier
                .weight(1f)
                .padding(12.dp, 8.dp)
            //.border(2.dp, Color.Blue)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = onNextClick,
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

fun getState(currentStep: Int): ImageObject {
    val imgObj = ImageObject()

    when (currentStep) {
        1 -> {
            imgObj.imageResource = R.drawable.img1
            imgObj.imgContentDescription = R.string.desc_img1
            imgObj.artworkTitle = R.string.title_img1
            imgObj.artworkArtist = R.string.img_artist1
        }

        2 -> {
            imgObj.imageResource = R.drawable.img2
            imgObj.imgContentDescription = R.string.desc_img2
            imgObj.artworkTitle = R.string.title_img2
            imgObj.artworkArtist = R.string.img_artist2
        }

        3 -> {
            imgObj.imageResource = R.drawable.img3
            imgObj.imgContentDescription = R.string.desc_img3
            imgObj.artworkTitle = R.string.title_img3
            imgObj.artworkArtist = R.string.img_artist3
        }

        4 -> {
            imgObj.imageResource = R.drawable.img4
            imgObj.imgContentDescription = R.string.desc_img4
            imgObj.artworkTitle = R.string.title_img4
            imgObj.artworkArtist = R.string.img_artist4
        }

        5 -> {
            imgObj.imageResource = R.drawable.img5
            imgObj.imgContentDescription = R.string.desc_img5
            imgObj.artworkTitle = R.string.title_img5
            imgObj.artworkArtist = R.string.img_artist5
        }

        6 -> {
            imgObj.imageResource = R.drawable.img6
            imgObj.imgContentDescription = R.string.desc_img6
            imgObj.artworkTitle = R.string.title_img6
            imgObj.artworkArtist = R.string.img_artist6
        }

        else -> {
            imgObj.imageResource = R.drawable.img7
            imgObj.imgContentDescription = R.string.desc_img7
            imgObj.artworkTitle = R.string.title_img7
            imgObj.artworkArtist = R.string.img_artist7
        }
    }
    return imgObj
}