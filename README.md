# zeebe cluster with zeebe-simple-monitor

> add prometheus demo 0.21.1


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