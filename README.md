# zeebe cluster with zeebe-simple-monitor

> add prometheus demo 0.21.1

## prepare

* install 

```code
yum update -y
yum install -y yum-utils git nano telnet mlocate sysstat maven unzip python3-pip
yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
yum install -y docker-ce
curl -sSL https://get.daocloud.io/daotools/set_mirror.sh | sh -s http://099430a4.m.daocloud.io
pip3 install docker-compose
```
* settings.xml

```code
<?xml version="1.0" encoding="UTF-8"?>

<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <mirrors>
    <mirror>
    <id>nexus-aliyun</id>
    <mirrorOf>central</mirrorOf>
    <name>Nexus aliyun</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
     </mirror>
  </mirrors>
  <profiles>
  <profile>
   <id>nexus-my</id>
   <!--Enable snapshots for the built in central repo to direct -->
   <!--all requests to nexus via the mirror -->
   <repositories>
     <repository>
       <id>central</id>
       <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
       <releases><enabled>true</enabled></releases>
       <snapshots><enabled>true</enabled></snapshots>
     </repository>
   </repositories>
  <pluginRepositories>
     <pluginRepository>
       <id>central</id>
       <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
       <releases><enabled>true</enabled></releases>
       <snapshots><enabled>true</enabled></snapshots>
     </pluginRepository>
   </pluginRepositories>
 </profile>
  </profiles>

  <activeProfiles>
    <activeProfile>central</activeProfile>
  </activeProfiles>
  </settings>
```

## how to running

* start service

```code
docker-compose up -d
```

* deploy 

> use zbctl

```code
./zbctl --insecure deploy flow.bpmn
```

* create instance

> use zbctl

```code
./zbctl --insecure create instance   demoProcess

```