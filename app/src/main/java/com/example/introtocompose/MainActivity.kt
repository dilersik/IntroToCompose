package com.example.introtocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var moneyCounter by remember { mutableIntStateOf(0) }

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF546E7A)) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$$moneyCounter",
                style = TextStyle(color = Color.White, fontSize = 42.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(moneyCounter = moneyCounter) {
                moneyCounter = it
            }

            if (moneyCounter > 25) {
                Text(text = "Lots of money!")
            }
        }
    }
}

@Composable
fun CreateCircle(moneyCounter: Int = 0, updateMoneyCounter: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                updateMoneyCounter(moneyCounter + 1)
            },
        shape = CircleShape,
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "TAP", style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroToComposeTheme {
        MyApp()
    }
}