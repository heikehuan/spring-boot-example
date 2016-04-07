package com.springboot.example.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author <a href="mailto:jean@eastcode.org">Jean Seurin</a>
 * @since 25/08/15 - 11:37
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration extends AbstractConfiguration {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        logger.debug("Configuring Datasource");
        super.resolver = new RelaxedPropertyResolver(super.env, "datasource.");
        if (resolver.getProperty("url") == null) {
            logger.error("Your database connection pool configuration is incorrect! The application" +
                            " cannot start. Please check your Spring profile, current profiles are: {}",
                    Arrays.toString(env.getActiveProfiles()));
            throw new ApplicationContextException("Database connection pool is not configured correctly");
        }
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(resolver.getProperty("dataSourceClassName"));
        config.addDataSourceProperty("url", resolver.getProperty("url"));
        config.setUsername(resolver.getProperty("username"));
        config.setPassword(resolver.getProperty("password"));
        //MySQL optimizations, see https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration
        if ("com.mysql.jdbc.jdbc2.optional.MysqlDataSource".equals(resolver.getProperty("datasource.dataSourceClassName"))) {
            config.addDataSourceProperty("cachePrepStmts", resolver.getProperty("cachePrepStmts", "true"));
            config.addDataSourceProperty("prepStmtCacheSize", resolver.getProperty("prepStmtCacheSize", "250"));
            config.addDataSourceProperty("prepStmtCacheSqlLimit", resolver.getProperty("prepStmtCacheSqlLimit", "2048"));
        }
        return new HikariDataSource(config);
    }

}
