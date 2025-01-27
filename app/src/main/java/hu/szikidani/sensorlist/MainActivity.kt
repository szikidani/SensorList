package hu.szikidani.sensorlist


import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.szikidani.sensorlist.ui.theme.SensorListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorList: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        setContent {
            SensorListTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                ) { innerPadding ->
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        item {
                            for (sensor in sensorList) {
                                MyItem(sensor)
                                HorizontalDivider(thickness = 2.dp)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyItem(sensor: Sensor) {
    println(sensor.toString())

    Text("name: ${sensor.name}")
    Text("vendor: ${sensor.vendor}")
    Text("version: ${sensor.version}")
    Text("stringType: ${sensor.stringType}")
    Text("maximumRange: ${sensor.maximumRange}")
    Text("resolution: ${sensor.resolution}")
    Text("power: ${sensor.power}")
    Text("minDelay: ${sensor.minDelay}")
    Text("fifoMaxEventCount: ${sensor.fifoMaxEventCount}")
    Text("fifoReservedEventCount: ${sensor.fifoReservedEventCount}")
    Text("highestDirectReportRateLevel: ${sensor.highestDirectReportRateLevel}")
    Text("type: ${sensor.type}")
    Text("isAdditionalInfoSupported: ${sensor.isAdditionalInfoSupported}")
    Text("isDynamicSensor: ${sensor.isDynamicSensor}")
    Text("isWakeUpSensor: ${sensor.isWakeUpSensor}")
    Text("maxDelay: ${sensor.maxDelay}")
    Text("reportingMode: ${sensor.reportingMode}")
}