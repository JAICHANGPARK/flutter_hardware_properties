package com.example.flutter_hardware_properties

import android.content.ContentValues.TAG
import android.os.Build
import android.os.HardwarePropertiesManager
import android.util.Log
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result


/** FlutterHardwarePropertiesPlugin */
class FlutterHardwarePropertiesPlugin : FlutterPlugin, MethodCallHandler {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private lateinit var channel: MethodChannel
    private lateinit var hardwarePropertiesManager: HardwarePropertiesManager
    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter_hardware_properties")
        channel.setMethodCallHandler(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hardwarePropertiesManager =
                flutterPluginBinding.applicationContext.getSystemService(
                    HardwarePropertiesManager::class.java
                )
            val cpuUsages = hardwarePropertiesManager.cpuUsages
        }

    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        if (call.method == "getPlatformVersion") {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
        } else if (call.method == "getCpuTemperature") {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val cpuTemp = hardwarePropertiesManager.getDeviceTemperatures(
                    HardwarePropertiesManager.DEVICE_TEMPERATURE_BATTERY,
                    HardwarePropertiesManager.TEMPERATURE_CURRENT
                )
                Log.e(TAG, "onMethodCall: ${cpuTemp}")
                result.success("${cpuTemp}")
            }
        } else {
            result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}
