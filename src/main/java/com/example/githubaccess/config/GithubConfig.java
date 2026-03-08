
package com.example.githubaccess.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubConfig {

    @Value("${github.token}")
    private String token;

    @Value("${github.org}")
    private String org;

    @Value("${github.api}")
    private String api;

    public String getToken() {
        return token;
    }

    public String getOrg() {
        return org;
    }

    public String getApi() {
        return api;
    }
}
