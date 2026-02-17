package com.example.tempapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tempapp.ui.theme.TempAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            var text1 by remember { mutableStateOf("0")}
            var text2 by remember { mutableStateOf("0")}
            var text3 by remember { mutableStateOf("0")}

            val num1 = text1.toFloat()
            val num2 = text2.toFloat()
            val num3 = text3.toFloat()

            val subTotal = num1 + num2 + num3
            val tax = subTotal * 0.06
            val total = tax + subTotal

            TempAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(32.dp)
                    ) {
                    Item(
                        modifier = Modifier.padding(innerPadding),
                        1,
                        onValueChange = { text1 = it },
                        text = text1
                    )
                    Item(
                        modifier = Modifier.padding(innerPadding),
                        2,
                        onValueChange = { text2 = it },
                        text = text2
                    )
                    Item(
                        modifier = Modifier.padding(innerPadding),
                        3,
                        onValueChange = { text3 = it },
                        text = text3
                    )

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.padding(top=300.dp)

                        ){

                        Text(
                            text="Subtotal:",
                            fontSize = 32.sp
                        )
                            Text(
                                text="$$subTotal",
                                fontSize = 32.sp
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {


                            Text(
                                text = "Tax (6%):",
                                fontSize = 32.sp
                            )
                            Text(
                                text = "$$tax",
                                fontSize = 32.sp
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.padding(top=20.dp)

                        ) {

                            Text(
                                text = "Total:",
                                fontSize = 32.sp,
                            )
                            Text(
                                text = "$$total",
                                fontSize = 32.sp
                            )
                        }
                    }




                }
            }
        }
    }
}

@Composable
fun Item(modifier: Modifier = Modifier, itemNumber: Number, text: String, onValueChange: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Item #$itemNumber:",
            modifier = modifier,
            fontSize = 32.sp
        )
        TextField(
            value = text,
            onValueChange = onValueChange,
        )
    }
}

