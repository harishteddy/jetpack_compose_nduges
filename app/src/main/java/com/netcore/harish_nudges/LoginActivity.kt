package com.netcore.harish_nudges

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.netcore.android.Smartech
import com.netcore.harish_nudges.ui.theme.Harish_nudgesTheme
import io.hansel.compose.SmtCompose
import io.hansel.compose.smtTag
import io.hansel.hanselsdk.Hansel
import io.hansel.hanselsdk.HanselDeepLinkListener
import io.hansel.ujmtracker.HanselInternalEventsListener
import io.hansel.ujmtracker.HanselTracker
import java.lang.ref.WeakReference

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SmtCompose.screenName = "LoginActivity"

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
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LoginScreen(
                        onLoginSuccess = {
                            // Navigate to ListScreen after successful login
                            val intent = Intent(this, ListScreenActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .smtTag(screenName = "MainActivity", tag = "label_1")
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Username Input
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
                .smtTag(screenName = "MainActivity", tag = "label_2")
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Input
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),

            modifier = Modifier.fillMaxWidth()
                .smtTag(screenName = "MainActivity", tag = "label_3")
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Error Message (if login fails)
        errorMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Login Button
        Button(
            onClick = {
                // Basic validation for demo purposes
                if (username == "harish" && password == "harish") {
                    onLoginSuccess()
                } else {
                    errorMessage = "Invalid username or password"
                }
            },
            modifier = Modifier.fillMaxWidth()
                .smtTag(screenName = "MainActivity", tag = "label_4")
        ) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Harish_nudgesTheme {
        LoginScreen(onLoginSuccess = {})
    }
}
