import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_hardware_properties/flutter_hardware_properties.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_hardware_properties');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FlutterHardwareProperties.platformVersion, '42');
  });
}
