<<<<<<< HEAD
package com.westernacher.training.usersystem.configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import static java.util.Collections.singletonList;

/**
 * @author Kristiyan SLavov
 */
public class ApplicationContextEventTestsAppConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "user_account";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {

        builder
                .credential(MongoCredential.createCredential("kris", "user_account", "123qwe".toCharArray()))
                .applyToClusterSettings(settings  -> {
                    settings.hosts(singletonList(new ServerAddress("localhost:27017", 27017)));
                });
    }
}
=======
package com.westernacher.training.usersystem.configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import static java.util.Collections.singletonList;

/**
 * @author Kristiyan SLavov
 */
public class ApplicationContextEventTestsAppConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "user_account";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {

        builder
                .credential(MongoCredential.createCredential("kris", "user_account", "123qwe".toCharArray()))
                .applyToClusterSettings(settings  -> {
                    settings.hosts(singletonList(new ServerAddress("localhost:27017", 27017)));
                });
    }
}
>>>>>>> b74f18ba09c654dfca642dd884af12d791583ada
