package com.example.first.screens.loginform

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import com.example.first.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import com.example.first.ui.theme.PureWhite
import com.example.first.ui.theme.SolidBlue


@Composable
fun LoginForm(navController: NavController) {
    var username: String by remember { mutableStateOf("")}
    var password: String by remember { mutableStateOf("")}

    val reusableModifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)

    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.titleWeek3),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = username    ,
            onValueChange = {username = it},
            label = {Text("Email")},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"
                )
            },
            singleLine = true,
            modifier = reusableModifier

        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Password")},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon",
                )
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = reusableModifier

            )

        Button(
            onClick = {
                navController.navigate("loginform")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = SolidBlue,
                contentColor = PureWhite,
            ),
            shape = RoundedCornerShape(12.dp),

            modifier = reusableModifier
                .padding(horizontal = 6.dp)
        ) {
            Text(
                text = stringResource(R.string.loginButton),
                style = MaterialTheme.typography.labelLarge,
                )
        }

    }
}