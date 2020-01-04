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

## Deploy new version on github packages

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
