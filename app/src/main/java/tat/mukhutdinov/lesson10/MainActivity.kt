package tat.mukhutdinov.lesson10

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tat.mukhutdinov.lesson10.ui.DessertClickerApp
import tat.mukhutdinov.lesson10.ui.DessertViewModel
import tat.mukhutdinov.lesson10.ui.theme.DessertClickerTheme
import tat.mukhutdinov.lesson10.model.DessertClickerUiState
import tat.mukhutdinov.lesson10.R

class MainActivity : ComponentActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: DessertViewModel by viewModels()
        setContent {
            DessertClickerTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                ) {
                    val uiState by viewModel.uiState.collectAsState()
                    DessertClickerApp(
                        uiState = uiState,
                        onDessertClicked = { viewModel.onDessertClicked() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DessertClickerAppPreview() {
    DessertClickerTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
        ) {
            DessertClickerApp(
                uiState = DessertClickerUiState(
                    revenue = 100,
                    dessertsSold = 10,
                    currentDessertPrice = 5,
                    currentDessertImageId = R.drawable.cupcake
                ),
                onDessertClicked = {}
            )
        }
    }
}
