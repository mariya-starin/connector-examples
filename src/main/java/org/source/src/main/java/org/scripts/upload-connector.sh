#! /bin/bash


curl -s -X POST -H 'Content-Type: application/json' -d '{ "name": "connect-increment-source", "config": { "connector.class": "org.source.IncrementSourceConnector", "confluent.topic.bootstrap.servers": "kafka:9092", "confluent.license": "", "key.converter": "org.apache.kafka.connect.storage.StringConverter", "max.interval": 100, "tasks.max": "2", "increments": "1,100", "topic.prefix": "seq_"} }' http://connect:8083/connectors | jq .

#curl connect:8083/connectors | jq

#curl connect:8083 | jq

#curl connect:8083/connectors/connect-increment-source/config | jq


#curl -s -X PUT -H "Content-Type:application/json" http://localhost:8083/admin/loggers/org.apache.kafka.connect.runtime.WorkerSourceTask -d '{"level": "DEBUG"}' | jq '.'

#curl -Ss http://localhost:8083/admin/loggers/org.apache.kafka.connect.runtime.WorkerSourceTask | jq
#curl -Ss http://localhost:8083/admin/loggers | jq