package dev.iamwami.app.quotinews.ui.splashscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.iamwami.app.quotinews.R

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {
    Column(
//        Use to specify the arrangement of the layout children (inside the layout)
        verticalArrangement = Arrangement.Center,
//        use to specify the arrangement of the column within the parent
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(Color.Magenta)

    ) {
        Text(
            stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(text = "Explore trending news")
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Splash Screen")
@Composable
fun ComposablePreview() {
    SplashScreen()
}