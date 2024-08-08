package org.demo.seminar17_20240809.ioc;

import java.util.HashMap;
import java.util.Map;

// ToDo: 
// создайте и зарегистрируйте новый сервис
// Продемонстрируйте его работу

public class Program {
    public static void main(String[] args) {
        IoCContainer container = new IoCContainer();
        container.register(Service.class, ServiceImplementation.class);
        Service service = container.resolve(Service.class);
        service.execute();
    }
}

class IoCContainer {
    private Map<Class<?>, Class<?>> registeredTypes = new HashMap<>();

    public <TInterface, TImplementation> void register(Class<TInterface> interfaceType,
            Class<TImplementation> implementationType) {
        registeredTypes.put(interfaceType, implementationType);
    }

    public <TInterface> TInterface resolve(Class<TInterface> interfaceType) {
        Class<?> implementationType = registeredTypes.get(interfaceType);
        if (implementationType != null) {
            try {
                return interfaceType.cast(implementationType.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Не удалось создать экземпляр " + implementationType.getName(), e);
            }
        }
        throw new IllegalArgumentException("Type " + interfaceType.getName() + " не зарегистрирован.");
    }
}

interface Service {
    void execute();
}

class ServiceImplementation implements Service {
    @Override
    public void execute() {
        System.out.println("ServiceImplementation is executing.");
    }
}

class AnotherServiceImplementation implements Service {
    @Override
    public void execute() {
        System.out.println("AnotherServiceImplementation is executing.");
    }
}
