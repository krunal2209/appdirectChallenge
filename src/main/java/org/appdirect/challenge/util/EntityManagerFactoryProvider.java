package org.appdirect.challenge.util;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.springframework.instrument.classloading.SimpleLoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class EntityManagerFactoryProvider {

	/**
	 * Based on the given {@link DataSource} instance, create and configure an
	 * EntityManagerFactory. Part of this configuration is that the given
	 * packages are scanned for entity classes, so that the created
	 * EntityManagers know about them.
	 */
	public static LocalContainerEntityManagerFactoryBean get(DataSource dataSource, String... packagesToScan) {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setPackagesToScan(packagesToScan);
		entityManagerFactoryBean.setPersistenceProvider(new PersistenceProvider());
		entityManagerFactoryBean.setLoadTimeWeaver(new SimpleLoadTimeWeaver());
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		entityManagerFactoryBean.setJpaPropertyMap(getJPAProperties(dataSource.getClass().getClassLoader()));
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean;
	}

	/**
	 * Set some basic properties. In our case the database schema is created (or
	 * extended) automatically. Find more properties under
	 * org.eclipse.persistence.config.PersistenceUnitProperties
	 */
	private static Map<String, Object> getJPAProperties(ClassLoader classLoader) {
		Map<String, Object> props = new HashMap<>();
		props.put(PersistenceUnitProperties.CLASSLOADER, classLoader);
		props.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
		props.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_BOTH_GENERATION);
		props.put(PersistenceUnitProperties.WEAVING, "false");
		props.put(PersistenceUnitProperties.LOGGING_LEVEL, "ALL");
		props.put(PersistenceUnitProperties.JPQL_PARSER, "org.eclipse.persistence.queries.ANTLRQueryBuilder");
		props.put(PersistenceUnitProperties.CACHE_SHARED_DEFAULT, "false");
		return props;
	}

}