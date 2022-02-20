package com.bs.weathermobileappui.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bs.weathermobileappui.R
import com.bs.weathermobileappui.presentation.ui.theme.LightPerple
import com.bs.weathermobileappui.presentation.ui.theme.background
import com.bs.weathermobileappui.presentation.ui.theme.SecondBackground
import com.bs.weathermobileappui.presentation.ui.theme.ThirdBackground

@Composable
fun WelcomeScreen(
    onNavigate: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.rainy),
            contentDescription = "rainy",
            modifier = Modifier
                .scale(1.5f)
                .weight(0.6f),
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.4f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(ThirdBackground)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp)
                    .padding(horizontal = 10.dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(SecondBackground)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = buildAnnotatedString {
                            pushStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 25.sp,
                                )
                            )
                            pushStyle(
                                SpanStyle(
                                    color = LightPerple,
                                )
                            )
                            append("Find")
                            pop()
                            append(" your weather predictions in your City")
                        },
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Easy steps to predict the weather and make your day easier",
                        textAlign = TextAlign.Center,
                        color = Color.LightGray,
                    )
                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        onClick = {
                            onNavigate()
                        },
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = LightPerple)
                    ) {
                        Text(
                            text = "Get Start",
                            color = Color.White,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
}