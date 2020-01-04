# Katanever-core-model
model of katanever's core

<a href="https://github.com/jtutzo/katanever-core-model"><img alt="GitHub Actions status" src="https://github.com/jtutzo/katanever-core-model/workflows/on-push-ci/badge.svg"></a>
<a href="https://github.com/jtutzo/katanever-core-model"><img alt="GitHub Actions status" src="https://github.com/jtutzo/katanever-core-model/workflows/on-push-tag-ci/badge.svg"></a>

## Compile
```bash
mvn compile
```

## Package
```bash
mvn package
```

## Test
```bash
mvn test
```

## How deploy new version on github packages ?

Update version on `pom.xml`
```xml
<project>
    ...
    <groupId>com.jtutzo.katanever</groupId>
    <artifactId>katanever-core-model</artifactId>
    <version>x.x.x</version>
    ...
</project>
```

Create new version tag
```bash
git tag -a vx.x.x -m "Minor revision"
git push origin vx.x.x
```

## How use dependency in my project ?

Create or update `~/.m2/setting.xml` file
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                       http://maven.apache.org/xsd/settings-1.0.0.xsd">
 
   <activeProfiles>
     <activeProfile>github</activeProfile>
   </activeProfiles>
 
   <profiles>
     <profile>
       <id>github</id>
       <repositories>
         <repository>
           <id>central</id>
           <url>https://repo1.maven.org/maven2</url>
           <releases><enabled>true</enabled></releases>
           <snapshots><enabled>false</enabled></snapshots>
         </repository>
         <repository>
           <id>github-katanever-core-model</id>
           <name>GitHub jtutzo Apache Maven Packages for katanever-core-model</name>
           <url>https://maven.pkg.github.com/jtutzo/katanever-core-model</url>
         </repository>
       </repositories>
     </profile>
   </profiles>
 
 </settings>
```

Add dependency in `pom.xml` of your project
```xml
<project>
    ...
    <dependencies>
        <dependency>
            <groupId>com.jtutzo.katanever</groupId>
            <artifactId>katanever-core-model</artifactId>
            <version>x.x.x</version>
        </dependency>
    </dependencies>
    ...
</project>
```
