package com.jcalvopinam.domain;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;
import java.util.UUID;

public class AppSequenceGenerator extends SequenceStyleGenerator {


    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(type, params, serviceRegistry);
    }

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        System.out.println("AppSequenceGenerator CALLED!!!!!!");
        return UUID.randomUUID().toString();
    }

}
