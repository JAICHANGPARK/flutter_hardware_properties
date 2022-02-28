#include "include/flutter_hardware_properties/flutter_hardware_properties_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "flutter_hardware_properties_plugin.h"

void FlutterHardwarePropertiesPluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  flutter_hardware_properties::FlutterHardwarePropertiesPlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
