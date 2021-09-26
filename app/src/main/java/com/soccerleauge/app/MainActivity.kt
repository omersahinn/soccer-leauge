package com.soccerleauge.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soccerleauge.app.repository.TeamRepository
import com.soccerleauge.app.ui.theme.SoccerleaugeTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           /* val repository = TeamRepository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            viewModel.getTeams()
            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful){
                    Log.d("Response: ", response.code().toString())
                }

            }) */

            SoccerleaugeTheme(
                darkTheme = false
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar() {
                            Text(text = "Soccer Leauge")
                        }
                    },
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Box(
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxHeight(fraction = 0.9f)
                                    .height(500.dp)
                                    .verticalScroll(rememberScrollState())
                            ) {
                                for (i in 1..50) {
                                    Row(

                                    ) {
                                        Text(text = "$i",
                                            fontSize = 24.sp)
                                        Spacer(modifier = Modifier.width(55.dp))
                                        Text(text = "Beşiktaş",
                                            fontSize = 24.sp)
                                    }
                                   
                                }
                            }
                        }
                        Column(
                            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(onClick = {})
                            { Text("Draw Fixture") }
                        }



                    }
                }
            }
        }


    }
}
