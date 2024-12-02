package com.netcore.harish_nudges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.netcore.android.Smartech
import com.netcore.harish_nudges.ui.theme.Harish_nudgesTheme
import io.hansel.compose.SmtCompose
import io.hansel.hanselsdk.Hansel
import io.hansel.hanselsdk.HanselDeepLinkListener
import io.hansel.ujmtracker.HanselInternalEventsListener
import io.hansel.ujmtracker.HanselTracker
import java.lang.ref.WeakReference

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pair the test device with the SDK, using the data string from the intent if available
        Hansel.pairTestDevice(intent.dataString)


        //Create an instance of HanselActionListener
        val hanselActionsListener = object : HanselDeepLinkListener {
            override fun onLaunchUrl(url: String?) {
                //Perform task based on url
            }
        }
        //Register the instance with this line:
        Hansel.registerHanselDeeplinkListener(hanselActionsListener)






        var hanselInternalEventsListener: HanselInternalEventsListener =
            HanselInternalEventsListener { eventName, dataFromHansel ->
                Smartech.getInstance(WeakReference(applicationContext)).trackEvent(eventName,
                    dataFromHansel as HashMap<String, Any>?
                )

            }

        HanselTracker.registerListener(hanselInternalEventsListener)

        setContent {
            Harish_nudgesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigator()  // Setup the navigation system
                }
            }
        }

    }
}


@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    // Listen for navigation changes to update screen names in SmtCompose
 /*   LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            SmtCompose.screenName = destination.route.toString()
        }
    }*/


    navController.addOnDestinationChangedListener { _, destination, _ ->
        SmtCompose.screenName = destination.route.toString()
    }

    NavHost(
        navController = navController,
        startDestination = Screens.MAINSCREEN.toString()
    ) {
        composable(Screens.MAINSCREEN.toString()) {
            MainScreen(
                onLoginClick = { navController.navigate(Screens.LOGINSCREEN.toString()) },
                onSignupClick = { navController.navigate(Screens.SIGNUPSCREEN.toString()) }
            )
        }

        composable(Screens.LOGINSCREEN.toString()) {
            LoginScreen(
                onLoginClick = { username, password ->
                    // Handle login logic here, then navigate to the dashboard
                    navController.navigate(Screens.DASHBOARDSCREEN.toString())
                }
            )
        }

        composable(Screens.SIGNUPSCREEN.toString()) {
            SignupScreen(
                onSignupClick = { username, email, password ->
                    // Handle signup logic, then navigate to login
                    navController.navigate(Screens.LOGINSCREEN.toString())
                }
            )
        }

        composable(Screens.DASHBOARDSCREEN.toString()) {
            DashboardScreen(
                onNavigateToList = { navController.navigate("list") },
                onNavigateToProfile = {
                    // Add profile screen navigation if needed
                    // Example: navController.navigate(Screens.PROFILESCREEN.toString())
                }
            )
        }

        composable("list") {
            ImageListScreen(
                items = listOf(
                    "Item 1" to "https://via.placeholder.com/150",
                    "Item 2" to "https://via.placeholder.com/150"
                )
            )
        }
    }
}














































/*@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    // Listen for navigation changes to update screen names in SmtCompose
  navController.addOnDestinationChangedListener { _, destination, _ ->
        SmtCompose.screenName = destination.route.orEmpty()
    }

    NavHost(navController = navController, startDestination = Screens.MAINSCREEN.toString()) {
        composable(Screens.MAINSCREEN.toString()) {
            MainScreen(
                onLoginClick = { navController.navigate(Screens.LOGINSCREEN.toString()) },
                onSignupClick = { navController.navigate(Screens.SIGNUPSCREEN.toString()) }
            )
        }
        composable(Screens.LOGINSCREEN.toString()) {
            LoginScreen(onLoginClick = { username, password ->
                // Handle login logic here, then navigate to the dashboard
                navController.navigate(Screens.DASHBOARDSCREEN.toString())
            })
        }
        composable(Screens.SIGNUPSCREEN.toString()) {
            SignupScreen(onSignupClick = { username, email, password ->
                // Handle signup logic, then navigate to login
                navController.navigate(Screens.LOGINSCREEN.toString())
            })
        }
        composable(Screens.DASHBOARDSCREEN.toString()) {
            DashboardScreen(
                onNavigateToList = { navController.navigate("list") },
                onNavigateToProfile = { *//* Add profile screen navigation if needed *//* }
            )
        }
        composable("list") {
            ImageListScreen(
                items = listOf(
                    "Item 1" to "https://via.placeholder.com/150",
                    "Item 2" to "https://via.placeholder.com/150"
                )
            )
        }
    }
}*/





