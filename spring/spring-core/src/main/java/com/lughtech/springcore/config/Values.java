package com.lughtech.springcore.config;

import com.lughtech.springcore.domain.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class Values {

    @Value("${poc.values.app-name}")
    String appName;

    @Value("${poc.values.max-retries}")
    Integer maxRetries;

    @Value("${poc.values.timeout}")
    Long timeout;

    @Value("${poc.values.tax-rate}")
    Double taxRate;

    @Value("${poc.values.feature-enabled}")
    Boolean featureEnabled;

    @Value("${poc.values.supported-languages}")
    List<String> supportedLanguages;

    @Value("#{${poc.values.headers}}")
    Map<String, String> headers;

    @Value("${poc.values.environment}")
    Environment environment;

    public String getAppName() {
        return appName;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public Long getTimeout() {
        return timeout;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public Boolean getFeatureEnabled() {
        return featureEnabled;
    }

    public List<String> getSupportedLanguages() {
        return supportedLanguages;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Environment getEnvironment() {
        return environment;
    }

    @Override
    public String toString() {
        return "Values{" +
                "appName='" + appName + '\'' +
                ", maxRetries=" + maxRetries +
                ", timeout=" + timeout +
                ", taxRate=" + taxRate +
                ", featureEnabled=" + featureEnabled +
                ", supportedLanguages=" + supportedLanguages +
                ", headers=" + headers +
                ", environment=" + environment +
                '}';
    }
}
