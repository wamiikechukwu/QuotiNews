package dev.iamwami.app.quotinews.ui.splashscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.iamwami.app.quotinews.R
import dev.iamwami.app.quotinews.util.Fonts

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier.background(Color.Magenta),
        verticalArrangement = Arrangement.Center,) {

        Column(
            modifier.weight(1.5f),
//        Use to specify the arrangement of the layout children (inside the layout)
            verticalArrangement = Arrangement.Center,
//        use to specify the arrangement of the column within the parent
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                stringResource(id = R.string.app_name),
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontFamily = Fonts.syneFontFamily,
                modifier = modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Explore trending news",
                modifier = modifier.padding(bottom = 24.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.splash_screen_two),
                contentDescription = "a splash screen picture",
                modifier = modifier.size(size = 300.dp)
            )

        }

        Column(
            modifier = modifier.padding(bottom = 60.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(onClick = onButtonClick) {
                Text(text = "Get Started")

            }
        }
    }


}

@Preview(showBackground = true, showSystemUi = true, name = "Splash Screen")
@Composable
fun ComposablePreview() {
    SplashScreen(onButtonClick = {})
}