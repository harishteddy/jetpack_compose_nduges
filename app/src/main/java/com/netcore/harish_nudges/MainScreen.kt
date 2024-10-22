package com.netcore.harish_nudges

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.netcore.android.Smartech
import io.hansel.compose.SmtCompose
import io.hansel.compose.smtTag
import java.lang.ref.WeakReference
@Composable
fun MainScreen(onLoginClick: () -> Unit, onSignupClick: () -> Unit) {
    val payload: HashMap<String, Any> = hashMapOf("name" to "Harish")

    // Tracking event with Smartech
    Smartech.getInstance(WeakReference(LocalContext.current)).trackEvent("MainScreen", payload)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Added to center content vertically
    ) {
        Text(
            text = "Welcome to Main Screen",
            style = MaterialTheme.typography.headlineMedium, // Added style for better visibility
            modifier = Modifier.smtTag(screenName = "MAINSCREEN", tag = "text")
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .smtTag(screenName = "MAINSCREEN", tag = "button")
        ) {
            Text(text = "Go to Login Screen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = onSignupClick,
            modifier = Modifier.smtTag(screenName = "MAINSCREEN", tag = "textbutton")
        ) {
            Text(text = "Don't have an account? Sign up")
        }
    }
}






























/*@Composable
fun MainScreen(onLoginClick: () -> Unit, onSignupClick: () -> Unit) {
    val payload : HashMap<String, Any> = HashMap()
    payload["name"] = "Harish"

    Smartech.getInstance(WeakReference(LocalContext.current)).trackEvent("MainScreen", payload)

   // SmtCompose.screenName = "MainScreen"
    

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Main Screen",
            modifier = Modifier.smtTag(screenName = "MAINSCREEN", tag = "text")
        )

        Button(
            onClick = { onLoginClick() },
            modifier = Modifier
                .padding(top = 16.dp)
                .smtTag(screenName = "MAINSCREEN", tag = "button")
        ) {
            Text(text = "Go to Login Screen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = { onSignupClick() },
            modifier = Modifier.smtTag(screenName = "MAINSCREEN", tag = "textbutton")
        ) {
            Text("Don't have an account? Sign up")
        }
    }
}*/
