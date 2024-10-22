package com.netcore.harish_nudges

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import io.hansel.compose.SmtCompose
import io.hansel.compose.smtTag

@Composable
fun LoginScreen(onLoginClick: (String, String) -> Unit) {
   // SmtCompose.screenName = "LoginScreen"

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.smtTag(screenName = "LOGINSCREEN", tag = "logintext")
        )

        Spacer(modifier = Modifier.height(16.dp).smtTag(screenName = "LOGINSCREEN", tag = "spacer"))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .smtTag(screenName = "LOGINSCREEN", tag = "username")
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .smtTag(screenName = "LOGINSCREEN", tag = "password")
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Consider adding validation before calling onLoginClick
                if (username.isNotBlank() && password.isNotBlank()) {
                    onLoginClick(username, password)
                } else {
                    // Handle empty fields (e.g., show a Snackbar or Toast)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .smtTag(screenName = "LOGINSCREEN", tag = "button")
        ) {
            Text(text = "Login")
        }
    }
}
