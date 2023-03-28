package dev.iamwami.app.quotinews.ui.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.iamwami.app.quotinews.R
import dev.iamwami.app.quotinews.navigation.BookmarkScreen
import dev.iamwami.app.quotinews.navigation.HomeScreen
import dev.iamwami.app.quotinews.ui.theme.Fonts


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    modifier: Modifier = Modifier,
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToBookmark: () -> Unit,
    closeDrawer: () -> Unit,
) {

    ModalDrawerSheet(modifier = modifier){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name), fontFamily = Fonts.syneFontFamily, fontSize = 30.sp, color = MaterialTheme.colorScheme.primary

            )
        }

        Divider(modifier = modifier.fillMaxWidth(), thickness = 3.dp, color = MaterialTheme.colorScheme.primaryContainer)

        NavigationDrawerItem(
            label = { Text(text = "Home")},
            selected = currentRoute == HomeScreen.route,
            icon = { Icon(Icons.Outlined.Home, "home") },
            onClick = { navigateToHome(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            label = { Text(text = "Bookmarks")},
            selected = currentRoute == BookmarkScreen.route,
            icon = { Icon(Icons.Outlined.FavoriteBorder, "bookmark") },
            onClick = { navigateToBookmark(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }


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
        modifier = modifier
            .padding(start = 8.dp, top = 8.dp, end = 8.dp)
            .height(45.dp)
            .clickable {
                action()
            },
        color = navItemBgColor,
        shape = androidx.compose.material.MaterialTheme.shapes.small
    ) {

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                modifier = modifier.padding(start = 5.dp),
                imageVector = icon,
                contentDescription = "navigation drawer icon",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(navItemIconColor),
            )
            Spacer(modifier = modifier.width(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview
@Composable
fun NavigationDrawerPreview() {
    Surface {
        NavigationDrawer(
            modifier = Modifier,
            navigateToBookmark = {},
            navigateToHome = {},
            currentRoute = "home",
            closeDrawer = {}
        )
    }
}
