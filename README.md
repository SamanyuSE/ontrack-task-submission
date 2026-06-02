# OnTrack Task Submission

![Java CI with Maven](https://github.com/YOUR_USERNAME/ontrack-task-submission/actions/workflows/ci.yml/badge.svg)

## Overview
A TDD-developed Task Submission function for the OnTrack platform, built as part of SIT333 – Software Quality and Testing.

## Function
Allows students to submit task files for tutor review. Validates student ID, task ID, file extension, and file size before accepting a submission.

## Tech Stack
- Java 17
- JUnit 5
- Maven
- GitHub Actions (CI)

## Running Tests
```bash
mvn test
```

## Project Structure
```
ontrack-task-submission/
 .github/workflows/ci.yml
 src/main/java/ontrack/TaskSubmission.java
 src/test/java/ontrack/TaskSubmissionTest.java
 pom.xml
```
