package org.csbs.configurationservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ConfigurationProperties(prefix = "app-config")

@Configuration
@Component("appConfig")
public class AppConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);
    
    private String appName;
    private String systemUser;
    private String systemPassword;
    private String envLbl;
    
    public String getAppName() {
        return appName;
    }
    public AppConfig setAppName(String appName) {
        this.appName = appName;
        return this;
    }
    public String getSystemUser() {
        return systemUser;
    }
    public AppConfig setSystemUser(String systemUser) {
        this.systemUser = systemUser;
        return this;
    }
    public String getSystemPassword() {
        return systemPassword;
    }
    public AppConfig setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
        return this;
    }
    public String getEnvLbl() {
        return envLbl;
    }
    public AppConfig setEnvLbl(String envLbl) {
        this.envLbl = envLbl;
        return this;
    }
    public static Logger getLogger() {
        return LOGGER;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((appName == null) ? 0 : appName.hashCode());
        result = prime * result + ((envLbl == null) ? 0 : envLbl.hashCode());
        result = prime * result + ((systemPassword == null) ? 0 : systemPassword.hashCode());
        result = prime * result + ((systemUser == null) ? 0 : systemUser.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AppConfig other = (AppConfig) obj;
        if (appName == null) {
            if (other.appName != null)
                return false;
        } else if (!appName.equals(other.appName))
            return false;
        if (envLbl == null) {
            if (other.envLbl != null)
                return false;
        } else if (!envLbl.equals(other.envLbl))
            return false;
        if (systemPassword == null) {
            if (other.systemPassword != null)
                return false;
        } else if (!systemPassword.equals(other.systemPassword))
            return false;
        if (systemUser == null) {
            if (other.systemUser != null)
                return false;
        } else if (!systemUser.equals(other.systemUser))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "AppConfig [appName=" + appName + ", systemUser=" + systemUser + ", systemPassword=" + systemPassword
                + ", envLbl=" + envLbl + "]";
    }
}
