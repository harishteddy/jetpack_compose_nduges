package com.netcore.harish_nudges

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.clickable
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.platform.LocalContext
import com.netcore.android.Smartech
import io.hansel.compose.SmtCompose
import io.hansel.compose.smtTag
import java.lang.ref.WeakReference

@Composable
fun DashboardScreen(onNavigateToList: () -> Unit, onNavigateToProfile: () -> Unit) {
   // SmtCompose.screenName = "DashboardScreen"

    val payload : HashMap<String, Any> = HashMap()
    payload["dashboard"] = "Harish"

    Smartech.getInstance(WeakReference(LocalContext.current)).trackEvent("DashBoardScreen", payload)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.smtTag(screenName = "DASHBOARDSCREEN", tag = "dashboard_text")
        )

        // Card for navigating to items list
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .smtTag(screenName = "DASHBOARDSCREEN", tag = "card")
                .clickable { onNavigateToList() },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
                    .smtTag(screenName = "DASHBOARDSCREEN", tag = "row"),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "List Icon" // Provide content description for accessibility
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "View Items List",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // Card for navigating to profile
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .smtTag(screenName = "DASHBOARDSCREEN", tag = "profile_card")
                .clickable { onNavigateToProfile() },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
                .smtTag(screenName = "DASHBOARDSCREEN", tag = "row2"),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile Icon" // Provide content description for accessibility
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
