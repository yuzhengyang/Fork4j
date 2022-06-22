发布代码到maven仓库

mvn clean deploy -P release -Dmaven.test.skip=true -e

登录并发布内容

https://s01.oss.sonatype.org/#stagingRepositories