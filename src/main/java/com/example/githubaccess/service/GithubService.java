
package com.example.githubaccess.service;

import com.example.githubaccess.config.GithubConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class GithubService {

    private final GithubConfig config;
    private final RestTemplate restTemplate = new RestTemplate();

    public GithubService(GithubConfig config) {
        this.config = config;
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(config.getToken());
        headers.set("Accept", "application/vnd.github+json");
        return headers;
    }

    public List<Map<String,Object>> getRepos() {

        String url = config.getApi() + "/orgs/" + config.getOrg() + "/repos?per_page=100";

        HttpEntity<String> entity = new HttpEntity<>(headers());

        ResponseEntity<List> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                List.class
        );

        return response.getBody();
    }

    public List<Map<String,Object>> getCollaborators(String repo) {

        String url = config.getApi() + "/repos/" +
                config.getOrg() + "/" + repo + "/collaborators?per_page=100";

        HttpEntity<String> entity = new HttpEntity<>(headers());

        ResponseEntity<List> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                List.class
        );

        return response.getBody();
    }
}
