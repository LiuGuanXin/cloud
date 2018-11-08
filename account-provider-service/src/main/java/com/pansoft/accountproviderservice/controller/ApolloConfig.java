package com.pansoft.accountproviderservice.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

public class ApolloConfig {
	private Config apolloConfig;
	public ApolloConfig(){
		apolloConfig = ConfigService.getAppConfig();

	}
	
	public ApolloConfig(String name){
		apolloConfig = ConfigService.getConfig(name);
		apolloConfig.addChangeListener(new ConfigChangeListener() {	
			@Override
			public void onChange(ConfigChangeEvent changeEvent) {
				 System.out.println("Changes for namespace " + changeEvent.getNamespace());
			        for (String key : changeEvent.changedKeys()) {
			            ConfigChange change = changeEvent.getChange(key);
			            System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
			        }
			}
		});
	}
	
	public static Config getConfig(String name){
		return ConfigService.getAppConfig();
	}
	public String getAppName(){
        return getAppName("JZFMISSVR");
	}
	public String getAppName(String serverId){
        return getAppName(serverId,"");
	}	
	public String getAppName(String serverId, String objectName){
        return getAppName(serverId,objectName,"");
	}

	public String getAppName(String serverId, String objectName, String method){
		String key = serverId;
		if(!"".equals(objectName)){
			key = serverId + "." + objectName;
			if(!"".equals(method))
				key = serverId + "." + objectName + "." + method;
		}	
		return apolloConfig.getProperty(key, "");
        
	}
	public String getContext(String appName){
		return apolloConfig.getProperty(appName, "");
	}
}
