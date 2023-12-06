package net.youapps.calcyou

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Carpenter
import androidx.compose.material.icons.rounded.Coffee
import androidx.compose.material.icons.rounded.GraphicEq
import androidx.compose.material.icons.rounded.Scale
import androidx.compose.material.icons.rounded.SdStorage
import androidx.compose.material.icons.rounded.Speed
import androidx.compose.material.icons.rounded.Square
import androidx.compose.material.icons.rounded.Thermostat
import androidx.compose.ui.graphics.vector.ImageVector
import net.youapps.calcyou.data.converters.AreaConverter
import net.youapps.calcyou.data.converters.DigitalStorageConverter
import net.youapps.calcyou.data.converters.FrequencyConverter
import net.youapps.calcyou.data.converters.LengthConverter
import net.youapps.calcyou.data.converters.MassConverter
import net.youapps.calcyou.data.converters.SpeedConverter
import net.youapps.calcyou.data.converters.TemperatureConverter
import net.youapps.calcyou.data.converters.UnitConverter
import net.youapps.calcyou.data.converters.VolumeConverter

sealed class Destination(open val route: String) {
    object Calculator : Destination("calculator")

    object Converters : Destination("converters")
    sealed class Converter(
        override val route: String,
        @StringRes val resId: Int,
        val icon: ImageVector,
        val converter: UnitConverter
    ) :
        Destination(route) {
        object Temperature :
            Converter(
                "temperature", R.string.temperature, Icons.Rounded.Thermostat,
                TemperatureConverter()
            )

        object Area :
            Converter(
                "area", R.string.area, Icons.Rounded.Square,
                AreaConverter()
            )

        object DigitalStorage :
            Converter(
                "digital_storage", R.string.digital_storage, Icons.Rounded.SdStorage,
                DigitalStorageConverter()
            )

        object Frequency :
            Converter(
                "frequency", R.string.frequency, Icons.Rounded.GraphicEq,
                FrequencyConverter()
            )

        object Length :
            Converter(
                "length", R.string.length, Icons.Rounded.Carpenter,
                LengthConverter()
            )

        object Mass :
            Converter(
                "mass", R.string.mass, Icons.Rounded.Scale,
                MassConverter()
            )

        object Speed :
            Converter(
                "speed", R.string.speed, Icons.Rounded.Speed,
                SpeedConverter()
            )

        object Volume :
            Converter(
                "volume", R.string.volume, Icons.Rounded.Coffee,
                VolumeConverter()
            )

        companion object {
            val values: Array<Converter> =
                arrayOf(Temperature, Area, DigitalStorage, Frequency, Length, Mass, Speed, Volume)
        }
    }
}