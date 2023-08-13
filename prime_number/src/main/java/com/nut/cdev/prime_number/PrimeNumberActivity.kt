package com.nut.cdev.prime_number

import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nut.cdev.number_picker.NumberPickerModel
import com.nut.cdev.prime_number.theme.BitcoinApplicationTheme
import com.nut.cdev.prime_number.theme.Purple80

class PrimeNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BitcoinApplicationTheme {
                PrimeNumberPreview()
            }
        }
    }
}


@Composable
fun PrimeNumberView(modifier: Modifier = Modifier) {

    val (weight, weightSelected) = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        val activity = (LocalContext.current as? Activity)
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { activity?.finish() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            Text(
                text = "Generate ตัวเลข จำนวนเฉพาะ",
                textAlign = TextAlign.Center,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )
        }
        CardViewInput(
            "จำนวน", "ระบุจำนวนที่ต้องการ",
            weight,
            weightSelected
        )

        ResultLastView(weight, Modifier)
        ResultView(weight, Modifier.padding(top = 50.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PrimeNumberPreview() {
    BitcoinApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Purple80
        ) {
            PrimeNumberView()
        }
    }
}

fun mockNumberPickerModel(default: Int?): NumberPickerModel {
    return NumberPickerModel(
        title = "ระบุจำนวน",
        default = default,
        tUnit = ""
    )
}
