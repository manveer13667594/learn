package com.example.learn.topics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginForm(){
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showPasswordCheckBox by rememberSaveable { mutableStateOf(false) }
    Column{

        Text("Login/Register Form", modifier = Modifier
            .padding(25.dp,25.dp,25.dp,0.dp),
        fontSize = 25.sp
        )
        Text("Please login/register to continue", modifier = Modifier
            .padding(25.dp,10.dp,25.dp,25.dp),
            )
        TextField(
            value = username,
            onValueChange = {username= it},
            label = { Text("Username") },
            modifier = Modifier.padding(25.dp, 0.dp, 25.dp, 10.dp)
        )
        TextField(
            value = password,
            onValueChange = {password=it},
            label = { Text("Password") },
            visualTransformation = if (showPasswordCheckBox) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            modifier = Modifier.padding(25.dp, 0.dp, 25.dp, 10.dp)
        )
        Row {
            Checkbox(
                checked = showPasswordCheckBox,
                onCheckedChange = {showPasswordCheckBox=it},
                modifier = Modifier.padding(25.dp, 0.dp, 0.dp, 10.dp)
            )
            Text("Show Password", modifier = Modifier.padding(0.dp, 12.dp, 25.dp, 0.dp))
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(25.dp, 0.dp, 25.dp, 0.dp)) {
            Text("Submit")
        }
    }
}