#import <Foundation/Foundation.h>

@class SOSCart, SOSCartLine, SOSProduct;

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

-(NSArray<SOSCartLine*>*)getCartLines NS_SWIFT_NAME(getCartLines());
-(void)addCartLineCartLine:(SOSCartLine*)cartLine NS_SWIFT_NAME(addCartLine(cartLine:));
-(double)getTotalPrice NS_SWIFT_NAME(getTotalPrice());
@property NSString* name;
@end;

__attribute__((objc_subclassing_restricted))
@interface SOSCartLine : KotlinBase
-(instancetype)initWithProduct:(SOSProduct*)product quantity:(int32_t)quantity NS_SWIFT_NAME(init(product:quantity:)) NS_DESIGNATED_INITIALIZER;

-(SOSProduct*)getProduct NS_SWIFT_NAME(getProduct());
-(int32_t)getQuantity NS_SWIFT_NAME(getQuantity());
-(double)getTotalPrice NS_SWIFT_NAME(getTotalPrice());
@end;

__attribute__((objc_subclassing_restricted))
@interface SOSProduct : KotlinBase
-(instancetype)initWithName:(NSString*)name price:(double)price description:(NSString*)description productImage:(int32_t)productImage NS_SWIFT_NAME(init(name:price:description:productImage:)) NS_DESIGNATED_INITIALIZER;

-(NSString*)getName NS_SWIFT_NAME(getName());
-(double)getPrice NS_SWIFT_NAME(getPrice());
-(NSString*)getDescription NS_SWIFT_NAME(getDescription());
-(int32_t)getProductImage NS_SWIFT_NAME(getProductImage());
@end;

NS_ASSUME_NONNULL_END
