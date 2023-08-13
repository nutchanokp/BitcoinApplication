package com.nut.cdev.fibonacci

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nut.cdev.fibonacci.ui.theme.BitcoinApplicationTheme
import com.nut.cdev.fibonacci.ui.theme.Purple80
import com.nut.cdev.number_picker.DialogNumberDecimal

@Preview
@Composable
fun CardViewInputPreview() {
    val (weight, weightSelected) = remember { mutableStateOf(0) }
    BitcoinApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = Purple80
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                CardViewInput(
                    "จำนวน", "ระบุจำนวนที่ต้องการ", weight, weightSelected
                )
            }

        }
    }
}

@Composable
fun CardViewInput(
    name: String, detail: String, s: Int, selected: (s: Int) -> Unit, modifier: Modifier = Modifier
) {
    val activity = LocalContext.current as? AppCompatActivity
    var selectedR by remember { mutableStateOf("") }
    Card(
        modifier = modifier
            .padding(top = 20.dp)
            .padding(horizontal = 10.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )

            Button(
                onClick = {
                    activity?.let {
                        dialogChooseNumber(it, s, selected = { selected.invoke(it) })
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent, contentColor = Color.White
                )
            ) {
                selectedR = if ("$s" == "0") detail else "$s"
                Text(
                    text = selectedR ?: detail,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


fun dialogChooseNumber(
    context: AppCompatActivity,
    s: Int,
    selected: (s: Int) -> Unit
) {
    val dialog = DialogNumberDecimal.newInstance(
        mockNumberPickerModel(s)
    )
    dialog.show(context.supportFragmentManager)
    dialog.onSelectHeight { i->
        selected.invoke(i)
    }
}
