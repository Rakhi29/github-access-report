
# GitHub Repository Access Report Service

This project connects to the GitHub API and generates a report showing which users
have access to which repositories in a GitHub organization.

## Tech Stack
- Java
- Spring Boot
- GitHub REST API
- Maven

## How to Run

1. Clone the repository

git clone https://github.com/your-username/github-access-report.git

2. Navigate to project

cd github-access-report

3. Configure authentication

Edit:
src/main/resources/application.properties

Add:

github.token=YOUR_GITHUB_TOKEN
github.org=YOUR_ORG
github.api=https://api.github.com

4. Run the application

mvn spring-boot:run

Application runs on:
http://localhost:8080

## API Endpoint

GET /api/access-report

Example:

http://localhost:8080/api/access-report

Returns JSON report mapping users to repositories.

## Authentication

Uses GitHub Personal Access Token sent in Authorization header.

## Assumptions

- Token has permission to read organization repositories.
- Organization repositories are accessible through GitHub API.
