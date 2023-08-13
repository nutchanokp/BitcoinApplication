package com.nut.cdev.fibonacci

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nut.cdev.fibonacci.ext.generateFibonacciAt
import com.nut.cdev.fibonacci.ext.generateFibonacciList
import com.nut.cdev.fibonacci.ui.theme.BitcoinApplicationTheme
import com.nut.cdev.fibonacci.ui.theme.Purple80
import java.math.BigInteger
import java.text.DecimalFormat


@Preview
@Composable
fun ResultViewPreview() {

    BitcoinApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = Purple80
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ResultLastView(100, Modifier)
                ResultView(100, Modifier)

            }
        }
    }
}


@Composable
fun ResultLastView(number: Int, modifier: Modifier) {

    var result = generateFibonacciAt(number - 1)
    Card(
        modifier = Modifier
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
                text = if (number <= 0) "ค่าที่ - คือ" else "ค่าที่ $number คือ",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = if (number <= 0) "-" else "$result",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun ResultView(number: Int, modifier: Modifier) {

    var result = generateFibonacciList(number - 1)
    Card(
        modifier = Modifier
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
                text = "ผลลัพธ์ทั้งหมด คือ",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = if (number <= 0) "-" else "$result",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )
        }
    }
}