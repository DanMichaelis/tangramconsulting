package org.csbs.configurationservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@EnableJpaAuditing
@EnableTransactionManagement
@Qualifier

public class JpaConfig {

    
    
}
