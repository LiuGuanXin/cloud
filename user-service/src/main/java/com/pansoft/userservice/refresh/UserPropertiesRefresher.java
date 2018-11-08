package com.pansoft.userservice.refresh;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class UserPropertiesRefresher implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory.getLogger(UserPropertiesRefresher.class);

  private ApplicationContext applicationContext;

  @ApolloConfigChangeListener
  public void onChange(ConfigChangeEvent changeEvent) {
    for (String changedKey : changeEvent.changedKeys()) {
      logger.info("改变的属性为:"+ changedKey);
      refreshUserProperties(changeEvent);
    }
  }

  private void refreshUserProperties(ConfigChangeEvent changeEvent) {
    this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
