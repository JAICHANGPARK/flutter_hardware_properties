
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterHardwareProperties {
  static const MethodChannel _channel = MethodChannel('flutter_hardware_properties');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String?> get hardwareCpuTemperature async {
    final String? version = await _channel.invokeMethod('getCpuTemperature');
    return version;
  }
}
