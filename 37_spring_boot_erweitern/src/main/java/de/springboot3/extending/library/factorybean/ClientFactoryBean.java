package de.springboot3.extending.library.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ClientFactoryBean implements FactoryBean<Client>, InitializingBean {

    private Client client;

    @Override
    public void afterPropertiesSet() throws Exception {
        // ... complex initialization
        this.client = new Client();
    }

    @Override
    public Client getObject() throws Exception {
        return this.client;
    }

    @Override
    public Class<?> getObjectType() {
        return Client.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
