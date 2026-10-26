package com.example.androidapidemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidapidemo.ui.theme.AndroidApiDemoTheme

@Composable
fun MainScreen(
    onNext: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var text = rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        OutlinedTextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text(stringResource(R.string.input_label)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
            keyboardActions = KeyboardActions(onGo = { onNext(text.value) }),
        )
        Button(onClick = { onNext(text.value) }) {
            Text(stringResource(R.string.next_screen))
        }
    }
}

@Composable
fun DetailScreen(
    text: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        Text(stringResource(R.string.detail_screen))
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    AndroidApiDemoTheme { MainScreen(onNext = {}) }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    AndroidApiDemoTheme { DetailScreen(text = "Hello") }
}