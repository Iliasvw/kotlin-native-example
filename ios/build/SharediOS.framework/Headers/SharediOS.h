#import <Foundation/Foundation.h>

@class SOSCart, SOSOrderLine, SOSProduct;

NS_ASSUME_NONNULL_BEGIN

@interface KotlinBase : NSObject
-(instancetype) init __attribute__((unavailable));
+(instancetype) new __attribute__((unavailable));
+(void)initialize __attribute__((objc_requires_super));
@end;

@interface KotlinBase (KotlinBaseCopying) <NSCopying>
@end;

__attribute__((objc_runtime_name("KotlinMutableSet")))
@interface SOSMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((objc_runtime_name("KotlinMutableDictionary")))
@interface SOSMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

__attribute__((objc_subclassing_restricted))
@interface SOSCart : KotlinBase
-(instancetype)initWithName:(NSString*)name NS_SWIFT_NAME(init(name:)) NS_DESIGNATED_INITIALIZER;

-(NSArray<SOSOrderLine*>*)getProducts NS_SWIFT_NAME(getProducts());
-(void)addOrderLineOrderLine:(SOSOrderLine*)orderLine NS_SWIFT_NAME(addOrderLine(orderLine:));
@property NSString* name;
@end;

__attribute__((objc_subclassing_restricted))
@interface SOSOrderLine : KotlinBase
-(instancetype)initWithProduct:(SOSProduct*)product quantity:(int32_t)quantity NS_SWIFT_NAME(init(product:quantity:)) NS_DESIGNATED_INITIALIZER;

@property (readonly) SOSProduct* product;
@property (readonly) int32_t quantity;
@end;

__attribute__((objc_subclassing_restricted))
@interface SOSProduct : KotlinBase
-(instancetype)initWithName:(NSString*)name NS_SWIFT_NAME(init(name:)) NS_DESIGNATED_INITIALIZER;

-(NSString*)getName NS_SWIFT_NAME(getName());
@end;

NS_ASSUME_NONNULL_END
