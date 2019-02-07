# Intellij IDEA Configuration

![IJ initial screen](screenshots/IJ-global-config.png?raw=true)

## SDK

Configure->Project Defaults-->Project structure

Add JDK 8

![SDK Configuration screen](screenshots/ide_settings/configure-sdks.png?raw=true)

Set default SDK for new projects

![Default SDK Configuration screen](screenshots/ide_settings/configure-default-projects-sdk.png?raw=true)



## Hotelbeds code style

Configure->Project Defaults-->Settings

Import java code style xml file. [You can use this file](../HotelbedsStyle.xml)

![Code Style Configuration screen](screenshots/ide_settings/import-code-style.png?raw=true)



## Maven

Configure your maven installation

![Maven Configuration screen](screenshots/ide_settings/maven-config.png?raw=true)


## Version  control configuration

#### Git

![GIT Configuration screen](screenshots/vcs_config/vcs-configure-git.png?raw=true)


#### Connect GitHub account


![GitHub Account Configuration screen](screenshots/vcs_config/vcs-connect-github-account.png?raw=true)


#### Issue navigation

![Issue navidator configuration screen](screenshots/vcs_config/vcs-jira-issue-navigation-pattern.png?raw=true)

#### Commit dialog

![Commit dialog configuration screen](screenshots/vcs_config/vcs-commit-dialog.png?raw=true)

#### Background tasks

![Version control background tasks configuration screen](screenshots/vcs_config/vcs-background-tasks.png?raw=true)


### Lombok plugin

To work with the lombok annotations, we need to install the lombok support plugin in the IDE

![IDE Lombok plugin configuration screen](screenshots/ide_settings/lombok-plugin.png?raw=true)


### SonarLint plugin

SonarLint is an IDE extension that helps you detect and fix quality issues as you write code. Like a spell checker, SonarLint squiggles flaws so they can be fixed before committing code. If your project is analyzed on SonarQube or on SonarCloud, SonarLint can connect to the server to retrieve the appropriate quality profiles and settings for that project. Java 8 is required to run SonarLint. 

Install SonarLint plugin and configure a SonarQube Server.

![IDE SonarLint plugin configuration screen](screenshots/ide_settings/sonarlint-plugin.png?raw=true)

This token is valid for hotelbeds developers (74edabe75ebbe6b95142be71f75347bdcfda5581). The sonarqube server is only accessible from the internal network.

![IDE SonarLint plugin token configuration screen](screenshots/ide_settings/sonar-lint-dev-token.png?raw=true)

This plugin will accompany you in all your developments, so it is important to take a look at the [documentation](https://www.sonarlint.org/features/) to know its use.

# Next lab

[Quickstart Springboot project](02_generate-project.md)
