package com.nepflow;

import org.neo4j.driver.Driver;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jOperations;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.core.mapping.Neo4jMappingContext;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;

/**
 * A custom Configuration necessary if data neo4 and spring data jpa are used.
 * See <a href="https://github.com/spring-projects/spring-data-neo4j/issues/2931">Issue</a>
 */
@Configuration
public class Neo4jTemplateManualAdder {

    @Bean({"neo4jTemplate"})
    @ConditionalOnMissingBean({Neo4jOperations.class})
    public Neo4jTemplate neo4jTemplate(
            Neo4jClient neo4jClient,
            Neo4jMappingContext neo4jMappingContext,
            Driver driver, DatabaseSelectionProvider databaseNameProvider, ObjectProvider<TransactionManagerCustomizers> optionalCustomizers
    ) {
        Neo4jTransactionManager transactionManager = new Neo4jTransactionManager(driver, databaseNameProvider);
        optionalCustomizers.ifAvailable((customizer) -> {
            customizer.customize(transactionManager);
        });
        return new Neo4jTemplate(neo4jClient, neo4jMappingContext, transactionManager);
    }

}
