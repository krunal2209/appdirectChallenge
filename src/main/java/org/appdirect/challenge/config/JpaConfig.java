package org.appdirect.challenge.config;


import org.appdirect.challenge.model.SubscriptionModel;
import org.appdirect.challenge.util.EntityManagerFactoryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
public class JpaConfig {

	private static String[] ENTITY_PACKAGES = { SubscriptionModel.class.getPackage().getName() };

    @Bean
    public JpaVendorAdapter eclipselink() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
        return EntityManagerFactoryProvider.get(ds, ENTITY_PACKAGES);
    }

}
