package com.shahott.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahott.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppTheme {
                val context = LocalContext.current
                MyView()
            }
        }
    }
}

@Composable
fun MyView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primary))
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(colorResource(id = R.color.secondry), RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.video_tape),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "Watch the tape !", color = Color.White, fontSize = 26.sp)
            Text(
                text = stringResource(id = R.string.desc),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.text_color),
                fontSize = 20.sp
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                MyIndicator(R.color.white)
                MyIndicator(R.color.secondry)
            }

            Button(modifier = Modifier
                .fillMaxWidth()
                .size(60.dp)
                .clip(RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.button_color)), // Set the background color here
                onClick = {}) {
                Text(
                    text = "Watch Now", color = Color.White, fontSize = 18.sp,
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MyViewPreview() {
    FirstAppTheme {
        MyView()
    }
}

@Composable
fun MyIndicator(colorId: Int) {
    FirstAppTheme {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(colorResource(id = colorId))
        )
    }
}