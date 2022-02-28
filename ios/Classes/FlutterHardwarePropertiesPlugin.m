#import "FlutterHardwarePropertiesPlugin.h"
#if __has_include(<flutter_hardware_properties/flutter_hardware_properties-Swift.h>)
#import <flutter_hardware_properties/flutter_hardware_properties-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_hardware_properties-Swift.h"
#endif

@implementation FlutterHardwarePropertiesPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterHardwarePropertiesPlugin registerWithRegistrar:registrar];
}
@end
