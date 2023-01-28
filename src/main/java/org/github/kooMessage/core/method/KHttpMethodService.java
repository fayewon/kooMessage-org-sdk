package org.github.kooMessage.core.method;

import org.github.kooMessage.util.PrintMessage;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;


/**
 * 请求注册表
 */
public interface KHttpMethodService {
    Map<Class,KHttpMethodBody> registry = new ConcurrentHashMap();

    default KHttpMethodService executeNewConfig(KHttpMethodBody body){
        registry.put(body.getTemplate(),body);
        return this;
    };

    default KHttpMethodService executeNewConfig(Map<Class,KHttpMethodBody> bodyMap){
        registry.putAll(bodyMap);
        return this;
    };

    default KHttpMethodService executeNewConfig(Collection<KHttpMethodBody> bodyCollection){
        bodyCollection.stream().forEach((body)->{
            registry.put(body.getTemplate(),body);
        });
        return this;
    };

    default KHttpMethodBody getConfig(Supplier<Class> supplier ){
        return registry.get(supplier.get());
    }

    static void printRegistry () {
        PrintMessage.printRegistry(registry);
    }

}
