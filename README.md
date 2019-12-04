# zeebe cluster with zeebe-simple-monitor

> add prometheus demo 0.21.1


## how to running

* start service

```code
docker-compose up -d
```

* deploy 

> use zbctl  for mac

```code
./zbctl.darwin --insecure deploy flow.bpmn
```

* create instance

> use zbctl  for mac

```code
./zbctl.darwin --insecure create instance   demoProcess

```