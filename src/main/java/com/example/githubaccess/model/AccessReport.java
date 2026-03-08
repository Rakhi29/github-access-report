
package com.example.githubaccess.model;

import java.util.List;

public class AccessReport {

    private String user;
    private List<RepoAccess> repositories;

    public AccessReport() {}

    public AccessReport(String user, List<RepoAccess> repositories) {
        this.user = user;
        this.repositories = repositories;
    }

    public String getUser() {
        return user;
    }

    public List<RepoAccess> getRepositories() {
        return repositories;
    }
}
