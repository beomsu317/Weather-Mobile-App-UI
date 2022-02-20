package com.bs.weathermobileappui.presentation.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bs.weathermobileappui.R

@Composable
fun HomeScreen() {
    var citiesSize by remember {
        mutableStateOf(2)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBarSection()
        SearchSection()
        CitiesWeatherSection(
            listOf(
                CityWeather(
                    name = "Ciemas",
                    resId = R.drawable.cloudy,
                    temp = 30,
                    precipitation = 77,
                    wind = 3
                ),
                CityWeather(
                    name = "Cikaret",
                    resId = R.drawable.rainy,
                    temp = 25,
                    precipitation = 45,
                    wind = 4
                ),
                CityWeather(
                    name = "Seoul",
                    resId = R.drawable.sunny,
                    temp = 30,
                    precipitation = 10,
                    wind = 1
                ),
                CityWeather(
                    name = "Busan",
                    resId = R.drawable.rainy,
                    temp = 20,
                    precipitation = 79,
                    wind = 1
                ),
                CityWeather(
                    name = "New York",
                    resId = R.drawable.cloudy,
                    temp = 30,
                    precipitation = 36,
                    wind = 69
                )
            ),
            displayCitiesSize = citiesSize
        )
        MoreCitiesSection(onButtonClick = {
            citiesSize += 2
        })
        LazyColumn {
            item {
                WeatherDetailSection(
                    precipation = 35,
                    humidity = 30,
                    wind = 160,
                    presure = 450
                )
            }
        }
    }
}

@Composable
fun WeatherDetailSection(
    precipation: Int,
    humidity: Int,
    wind: Int,
    presure: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 20.dp, end = 20.dp),
            elevation = 1.dp,
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color.White
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                WeatherDetail(
                    upperText = "Precipation",
                    upperValue = "${precipation} %",
                    lowerText = "Humidity",
                    lowerValue = "${humidity} %"
                )
                Box(
                    modifier = Modifier
                        .size(width = 1.dp, height = 90.dp)
                        .background(Color.LightGray)
                        .clip(RoundedCornerShape(10.dp))
                )
                WeatherDetail(
                    upperText = "Wind",
                    upperValue = "${wind}",
                    lowerText = "Presure",
                    lowerValue = "${presure}hPa"
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.cloudy),
            contentDescription = "cloudy",
            modifier = Modifier
                .padding(horizontal = 155.dp)
        )
    }
}

@Composable
fun WeatherDetail(
    upperText: String,
    upperValue: String,
    lowerText: String,
    lowerValue: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Text(
            text = "${upperText}",
            textAlign = TextAlign.Center,
            color = Color.LightGray,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "${upperValue}",
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "${lowerText}",
            textAlign = TextAlign.Center,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "${lowerValue}",
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun MoreCitiesSection(
    onButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                onButtonClick()
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(5.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "More Cities",
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "add",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun CitiesWeatherSection(
    citiesWeather: List<CityWeather>,
    displayCitiesSize: Int
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(0.dp, 300.dp)
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        items(if (displayCitiesSize > citiesWeather.size) citiesWeather.size else displayCitiesSize) {
            CityWeatherItem(citiesWeather[it])
        }
    }
}

data class CityWeather(
    val name: String,
    val resId: Int,
    val temp: Int,
    val precipitation: Int,
    val wind: Int
)

@Composable
fun CityWeatherItem(
    cityWeather: CityWeather
) {
    Card(
        modifier = Modifier
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 1.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = cityWeather.name,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.LightGray
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = cityWeather.temp.toString() + " ℃",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Image(
                    painter = painterResource(id = cityWeather.resId),
                    contentDescription = cityWeather.name,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rainy),
                    contentDescription = "ic_rainy",
                    modifier = Modifier.size(15.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${cityWeather.precipitation.toString()} %",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_wind),
                    contentDescription = "ic_wind",
                    modifier = Modifier.size(15.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${cityWeather.wind.toString()} km/h",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun SearchSection() {
    var city by remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "search",
            modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 10.dp),
            tint = Color.LightGray
        )
        OutlinedTextField(
            value = city,
            onValueChange = {
                city = it
            },
            placeholder = {
                Text(
                    text = "Search..."
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.DarkGray,
                disabledTextColor = Color.White,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            maxLines = 1,
            singleLine = true
        )
    }
}

@Composable
fun TopBarSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "arrowback",
                tint = Color.DarkGray
            )
        }

        Text(
            text = "Search for city",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
    }
}
