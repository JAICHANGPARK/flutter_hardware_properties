#ifndef FLUTTER_PLUGIN_FLUTTER_HARDWARE_PROPERTIES_PLUGIN_H_
#define FLUTTER_PLUGIN_FLUTTER_HARDWARE_PROPERTIES_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace flutter_hardware_properties {

class FlutterHardwarePropertiesPlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  FlutterHardwarePropertiesPlugin();

  virtual ~FlutterHardwarePropertiesPlugin();

  // Disallow copy and assign.
  FlutterHardwarePropertiesPlugin(const FlutterHardwarePropertiesPlugin&) = delete;
  FlutterHardwarePropertiesPlugin& operator=(const FlutterHardwarePropertiesPlugin&) = delete;

 private:
  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace flutter_hardware_properties

#endif  // FLUTTER_PLUGIN_FLUTTER_HARDWARE_PROPERTIES_PLUGIN_H_
