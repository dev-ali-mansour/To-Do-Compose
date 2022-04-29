package dev.alimansour.to_docompose.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import com.google.accompanist.navigation.animation.composable
import dev.alimansour.to_docompose.ui.screen.splash.SplashScreen
import dev.alimansour.to_docompose.util.Constants.SPLASH_SCREEN
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(navigateToListScreen: () -> Unit) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
                animationSpec = tween(300)
            )
        }
    ) {
        SplashScreen {
            navigateToListScreen()
        }
    }
}