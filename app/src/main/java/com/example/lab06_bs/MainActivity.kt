package com.example.lab06_bs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab06_bs.ui.theme.Lab06_bsTheme
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab06_bsTheme {
                CustomScaffold()
            }
        }
    }
}

@Composable
fun CustomScaffold() {
    val navController = rememberNavController()

    var clickCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = { CustomFAB { clickCount++ } },
        content = { padding ->
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { CustomContent(padding, clickCount) }
                composable("profile") { ProfileScreen() }
                composable("buildScreen") { BuildScreen() }
                composable("menuScreen") { MenuScreen() }
                composable("favoriteScreen") { FavoriteScreen() }
                composable("deleteScreen") { DeleteScreen() }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: androidx.navigation.NavHostController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu")
            }
        },
        title = { Text(text = "Laboratorio N° 6") },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search")
            }
            IconButton(onClick = {
                navController.navigate("profile")
            }) {
                Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "Profile")
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: androidx.navigation.NavHostController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { navController.navigate("buildScreen") }) {
                Image(
                    painter = painterResource(id = R.drawable.herramientas),
                    contentDescription = "Build description"
                )
            }
            IconButton(onClick = { navController.navigate("menuScreen") }) {
                Image(
                    painter = painterResource(id = R.drawable.corazon),
                    contentDescription = "Menu description"
                )
            }
            IconButton(onClick = { navController.navigate("favoriteScreen") }) {
                Image(
                    painter = painterResource(id = R.drawable.__lineas),
                    contentDescription = "Favorite description"
                )
            }
            IconButton(onClick = { navController.navigate("deleteScreen") }) {
                Image(
                    painter = painterResource(id = R.drawable.eliminar),
                    contentDescription = "Delete description"
                )
            }
        }
    }
}

@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Text(text = "+")
    }
}

@Composable
fun CustomContent(padding: PaddingValues, clickCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contenido de la pagina principal")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "FAB presionado $clickCount veces")
    }
}


@Composable
fun BuildScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Build Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun MenuScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Menu Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun FavoriteScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Favorite Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun DeleteScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Delete Screen", style = MaterialTheme.typography.headlineMedium)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCustomScaffold() {
    Lab06_bsTheme {
        CustomScaffold()  // Tu scaffold completo
    }
}
