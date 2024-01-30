package com.khtonapp.diostats

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khtonapp.diostats.ui.theme.DioStatsTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DioStatsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainLayout()
                }
            }
        }
    }
}

@Composable
fun MainLayout(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)){
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderElement()
            UserCard()
            aboutApp()
            OptionsGreed()
        }
    }
}

@Composable
fun HeaderElement(){
    Box(modifier = Modifier
        .fillMaxWidth()){
        Text(text = "DioStats",
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun OptionsGreed(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        contentAlignment = Alignment.Center){
        Row() {
            OptionCard(R.drawable.setting, "Setting")
            OptionCard(R.drawable.history, "History")
            OptionCard(R.drawable.closed, "Exit")
        }
    }
}

@Composable
fun OptionCard(iconId:Int, lable:String){
    Box(modifier = Modifier
        .padding(10.dp, 0.dp)
        .size(100.dp)
        ){
        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ))
        {
            Column(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
            ) {
                Image(imageVector = ImageVector.vectorResource(iconId),
                    contentDescription = "setting",
                    Modifier
                        .size(32.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(0.dp, 0.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                )
                Text(
                    text = "$lable",
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(0.dp, 10.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun  UserCard(){
    Box(modifier = Modifier
        .padding(0.dp,20.dp)){
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp
            )
        ) {
            Row(
                Modifier
                    .background(MaterialTheme.colorScheme.onPrimaryContainer)
                    .padding(24.dp)
                    .fillMaxWidth()) {
               Image(modifier = Modifier
                   .background(MaterialTheme.colorScheme.onPrimaryContainer)

                   .size(64.dp),
                   imageVector = ImageVector.vectorResource(R.drawable.user),
                   contentDescription = "gay",

                   colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface))
                Column {
                    Text(text = "Egor Eltyshev",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.surface,
                        modifier = Modifier.padding(24.dp,0.dp))
                    Text(text = "22 age",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.surface,
                        modifier = Modifier.padding(24.dp,12.dp))
                }
            }
        }
    }
}

@Composable
fun aboutApp(){
    Column(){
        Text(text = "Добро пожаловать в DioStats. " +
                "Это мой первый проект как начинающего разработчика.\n" +
                "Данный проект всегда будет бесплатный и в открытом исходном коде" +
                "\nВерсия приложения:0.0.1.alpha",
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.padding(24.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
@Composable
fun Preview_blue() {
    DioStatsTheme {
        MainLayout()
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE
)
@Composable
fun Preview_red() {
    DioStatsTheme {
        MainLayout()
    }
}

//@RequiresApi(Build.VERSION_CODES.S)
//@Preview(showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
//    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE
//)
//@Composable
//fun Preview_green() {
//    DioStatsTheme {
//        MainLayout()
//    }
//}