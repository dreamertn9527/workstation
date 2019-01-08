package top.dreamertn9527.workstation.framework.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@Configuration
@Data
public class MongoConfig {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private Integer port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public ServerAddress address() {
        return new ServerAddress(host, port);
    }

    @Bean
    public MongoClient client(ServerAddress serverAddress, MongoClientOptions options){
        return new MongoClient(serverAddress, options);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory factory) {
        return new MongoTemplate(factory);
    }

    @Bean
    public MongoDbFactory factory(MongoClient client){
        return new SimpleMongoDbFactory(client, database);
    }

    @Bean
    public MongoClientOptions mongoOptions() {
        return MongoClientOptions.
        builder().
                connectionsPerHost(2000).
                minConnectionsPerHost(10).
                connectTimeout(10000).
                maxWaitTime(300000).
                threadsAllowedToBlockForConnectionMultiplier(10).
                build();
    }
}
