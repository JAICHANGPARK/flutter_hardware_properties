import Flutter
import UIKit

public class SwiftFlutterHardwarePropertiesPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "flutter_hardware_properties", binaryMessenger: registrar.messenger())
    let instance = SwiftFlutterHardwarePropertiesPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    result("iOS " + UIDevice.current.systemVersion)
  }
}
