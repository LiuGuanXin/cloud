package com.pansoft.accountproviderservice;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class ApolloAPITest {
    public static void main(String[] args)  {
        Config config = ConfigService.getAppConfig();
        String someKey = "microserviceConfig.microservice-FMIS.JZFMISSVR.context";
        String someDefaultValue = "EnterpriseServer";
        String value = config.getProperty(someKey, someDefaultValue);
    }
}
