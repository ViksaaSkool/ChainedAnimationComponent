package com.viksaaskool.chainedanimation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.viksaaskool.chainedanimation.R
import com.viksaaskool.chainedanimation.ui.Routes.DEMO1_SCREEN
import com.viksaaskool.chainedanimation.ui.Routes.DEMO2_SCREEN
import com.viksaaskool.chainedanimation.ui.Routes.HOME_SCREEN
import com.viksaaskool.chainedanimation.ui.getPainter
import com.viksaaskool.chainedanimation.ui.getString
import com.viksaaskool.chainedanimation.ui.theme.ChainedAnimationDemoTheme
import com.viksaaskool.chainedanimation.ui.theme.goldenYellow


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = R.string.title_1.getString(),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = R.string.title_2.getString(),
                style = MaterialTheme.typography.titleLarge,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = R.drawable.chain.getPainter(),
                contentDescription = "Top Image",
                modifier = Modifier.padding(horizontal = 48.dp)
            )

        }
        Spacer(modifier = Modifier.height(48.dp))
        Row(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ) {
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = goldenYellow
            ), onClick = { navController.navigate(DEMO1_SCREEN) }) {
                Text(
                    R.string.demo_button_1.getString(),
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = goldenYellow
            ), onClick = { navController.navigate(DEMO2_SCREEN) }) {
                Text(
                    R.string.demo_button_2.getString(),
                    color = Color.Black
                )
            }

        }

    }
}


@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = HOME_SCREEN) {
        composable(HOME_SCREEN) {
            HomeScreen(navController)
        }
        composable(DEMO1_SCREEN) { DemoScreen1() }
        composable(DEMO2_SCREEN) { DemoScreen2() }
    }
}

@Preview
@Composable
fun HomeScreenPreview() = ChainedAnimationDemoTheme(true) {
    HomeScreen(navController = rememberNavController())
}
