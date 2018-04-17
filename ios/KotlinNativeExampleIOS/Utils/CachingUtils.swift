import SharediOS

class CachingUtils {
    private static var cache: NSCache = NSCache<NSString, SOSCart>()
    static func cacheCart(cart: SOSCart) {
        cache.setObject(cart, forKey: "cart")
    }
    
    static func getCartFromCache() -> SOSCart? {
        return cache.object(forKey: "cart")
    }
}
