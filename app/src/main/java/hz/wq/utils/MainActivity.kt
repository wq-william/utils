package hz.wq.utils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hz.wq.utils.ui.theme.UtilsTheme
import hz.wq.utilslbrary.log.LogUtils
import hz.wq.utilslbrary.log.wqLog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UtilsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = if (BuildConfig.DEBUG) "Android222  LogUtil.isDebug():${LogUtils.isDebug()}" else "release LogUtil.isDebug():${LogUtils.isDebug()}",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        for (i in 0 until 100) {
            "hello".wqLog()
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UtilsTheme {
        Greeting(if (BuildConfig.DEBUG) "Android" else "release")
    }
}