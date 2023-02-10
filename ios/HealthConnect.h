
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNHealthConnectSpec.h"

@interface HealthConnect : NSObject <NativeHealthConnectSpec>
#else
#import <React/RCTBridgeModule.h>

@interface HealthConnect : NSObject <RCTBridgeModule>
#endif

@end
