package com.blitznihar.restaturants.dbreceipes.configs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MongoConfigTest {

    @Test 
    public void getDatabaseNameTest(){
        MongoConfig config = new MongoConfig();
        assertThat(config.getDatabaseName()).isNotNull();
    }
    
}
