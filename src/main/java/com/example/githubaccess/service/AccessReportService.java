
package com.example.githubaccess.service;

import com.example.githubaccess.model.AccessReport;
import com.example.githubaccess.model.RepoAccess;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AccessReportService {

    private final GithubService githubService;

    public AccessReportService(GithubService githubService) {
        this.githubService = githubService;
    }

    public List<AccessReport> generateReport() {

        List<Map<String,Object>> repos = githubService.getRepos();
        Map<String, List<RepoAccess>> userAccessMap = new ConcurrentHashMap<>();

        repos.parallelStream().forEach(repo -> {

            String repoName = repo.get("name").toString();
            List<Map<String,Object>> collaborators = githubService.getCollaborators(repoName);

            for(Map<String,Object> user : collaborators){

                String username = user.get("login").toString();
                Map<String,Object> permissions = (Map<String,Object>) user.get("permissions");

                String permission =
                        permissions.get("admin").equals(true) ? "admin" :
                        permissions.get("push").equals(true) ? "write" : "read";

                RepoAccess repoAccess = new RepoAccess(repoName, permission);

                userAccessMap
                        .computeIfAbsent(username, k -> new ArrayList<>())
                        .add(repoAccess);
            }
        });

        List<AccessReport> report = new ArrayList<>();

        for(String user : userAccessMap.keySet()){
            report.add(new AccessReport(user, userAccessMap.get(user)));
        }

        return report;
    }
}
