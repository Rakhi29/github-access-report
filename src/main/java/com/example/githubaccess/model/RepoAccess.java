
package com.example.githubaccess.model;

public class RepoAccess {

    private String repository;
    private String permission;

    public RepoAccess() {}

    public RepoAccess(String repository, String permission) {
        this.repository = repository;
        this.permission = permission;
    }

    public String getRepository() {
        return repository;
    }

    public String getPermission() {
        return permission;
    }
}
