package dev.iamwami.app.quotinews.ui.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.iamwami.app.quotinews.ui.theme.Fonts
import dev.iamwami.app.quotinews.ui.utils.HomeScreen
import dev.iamwami.app.quotinews.ui.utils.SplashScreen


@Composable
fun NavigationDrawer(
    modifier: Modifier,
    currentRoute: String,
    navigateToHome:() -> Unit,
    navigateToBookmark:() -> Unit,
    closeDrawer:() -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Text(
            text = "QuotiNews", fontFamily = Fonts.syneFontFamily, fontSize = 30.sp, color = MaterialTheme.colorScheme.primary

        )
    }

    Divider(modifier = modifier.fillMaxWidth(), thickness = 3.dp, color = MaterialTheme.colorScheme.primaryContainer)


    DrawerItems(icon = Icons.Outlined.Home, title = "Home", isSelected = currentRoute == HomeScreen.route, action = { navigateToHome() })
    DrawerItems(icon = Icons.Outlined.FavoriteBorder, title = "Bookmarks", isSelected = currentRoute == SplashScreen.route, action = { navigateToBookmark() })

}


@Composable
fun DrawerItems(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    isSelected: Boolean,
    action: () -> Unit,
) {

    val navItemBgColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
    val navItemIconColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Black


    Surface(
        modifier = modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp),
        color = navItemBgColor,
        shape = androidx.compose.material.MaterialTheme.shapes.small
    ) {

        TextButton(
            onClick = action, modifier = modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = icon,
                    contentDescription = "navigation drawer icon",
                    contentScale = ContentScale.Inside,
                    colorFilter = ColorFilter.tint(navItemIconColor),
                )
                Spacer(modifier = modifier.width(16.dp))
                Text(text = title)
            }
        }
    }
}

@Preview
@Composable
fun NavigationDrawerPreview() {
    Surface {
        NavigationDrawer(modifier = Modifier,
        navigateToBookmark = {},
        navigateToHome = {},
        currentRoute = "home",
        closeDrawer = {})
    }
}
