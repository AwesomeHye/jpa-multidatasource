package dev.hyein.jpamultidatasource.datasource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Profile("multi")
@Configuration
@EnableJpaRepositories(
        basePackages = "dev.hyein.jpamultidatasource.repository.member"
        , entityManagerFactoryRef = MemberDatasource.ENTITY_MANAGER_FACTORY
        , transactionManagerRef = MemberDatasource.TRANSACTION_MANAGER
)
public class MemberDatasource {
    public static final String DATA_SOURCE_NAME = "member";
    public static final String DATA_SOURCE = DATA_SOURCE_NAME + BeanName.DATA_SOURCE; // memberDataSource
    public static final String TRANSACTION_MANAGER = DATA_SOURCE_NAME + BeanName.TRANSACTION_MANAGER; // memberTransactionManager
    public static final String ENTITY_MANAGER_FACTORY = DATA_SOURCE_NAME + BeanName.ENTITY_MANAGER_FACTORY; // memberEntityManagerFactory

//    @Primary
    @Bean(ENTITY_MANAGER_FACTORY) // 다른 데이터소스와 빈 네임 중복되지 않도록 반드시 지정
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(datasource());
        em.setPackagesToScan("dev.hyein.jpamultidatasource.entity.member");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaPropertyMap(
                Map.of(
                        "hibernate.show_sql", "true"
                        , "hibernate.format_sql", "true"
                        , "hibernate.use_sql_comments", "true"
                        , "hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy"
                        , "hibernate.use_query_cache", "false"
                )
        );
        return em;
    }

//    @Primary
    @Bean(DATA_SOURCE)
    @ConfigurationProperties(prefix = "spring.member-datasource")
    public DataSource datasource() {
        return DataSourceBuilder.create().build();
    }

//    @Primary
    @Bean(TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }
}
