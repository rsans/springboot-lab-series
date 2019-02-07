# Dockerizing springboot app using Jib

In this lab, we’ll take a look at Jib and how it simplifies containerization of Java applications.

We will take our springboot-lab app and build its Docker image using Jib. And then we’ll also publish the image to a remote registry.

## Requirements

* DockerHub Account
* Private repository named springbootlab-app on your DockerHub account
* Previous labs completed


## Configuration

Add DockerHub credentials to your maven settings.xml:

```
<servers>
    <server>
        <id>registry.hub.docker.com</id>
        <username><DockerHub Username></username>
        <password><DockerHub Password></password>
    </server>
</servers>
```

There are other ways to provide the credentials, but though simply out of scope for this tutorial.

Just keep in mind that whenever you store passwords in the maven settings, it is highly recommend using maven password encryption.


Add jib-maven-plugin to your build section:

```
<project>
    ...
    <build>
        <plugins>
            ...
            <plugin>
                <groupId>com.google.cloud.tools</groupId>
                <artifactId>jib-maven-plugin</artifactId>
                <version>0.9.10</version>
                <configuration>
                    <to>
                        <image>registry.hub.docker.com/[YOUR-DOCKERHUB-ID]/springbootlab-app</image>
                    </to>
                </configuration>
            </plugin>
            ...
        </plugins>
    </build>
    ...
</project>
```


## Build your container image

```
mvn compile jib:build
```

Subsequent builds are much faster than the initial build.


## Bind to a lifecycle

```
 <plugin>
   <groupId>com.google.com.tools</groupId>
   <artifactId>jib-maven-plugin</artifactId>
   ...
   <executions>
     <execution>
       <phase>package</phase>
       <goals>
         <goal>build</goal>
       </goals>
     </execution>
   </executions>
 </plugin>
```

Now to build your container image you can use

```
mvn package
```

## Build an image tarball
You can build and save your image to disk as a tarball. To do it change the goal to buildTar.


# References

[Google Jib](https://github.com/GoogleContainerTools/jib)

[Google Jib Maven Plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin)


# Next lab

[Creating a simple REST controller with Spring MVC](04_simple_spring_mvc_controller.md)
