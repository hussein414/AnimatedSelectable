package com.example.animatedselectable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatedselectable.ui.theme.AnimatedSelectableTheme
import com.example.animatedselectable.utils.AnimatedSelectable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedSelectableTheme {
                // A surface container using the 'background' color from the theme
                var selected by remember { mutableStateOf(false) }
                var selected2 by remember { mutableStateOf(false) }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(80.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AnimatedSelectable(selected = selected, title = "Im Do it :)", onClick = {
                        selected = !selected
                    })
                    Spacer(modifier = Modifier.height(20.dp))

                    AnimatedSelectable(
                        selected = selected2,
                        title = "I cant ):",
                        subtitle = "You need motivation to try, but there is no motivation in you",
                        onClick = { selected2 = !selected2 }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimatedSelectableTheme {

    }
}