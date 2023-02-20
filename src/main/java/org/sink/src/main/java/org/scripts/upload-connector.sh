#! /bin/bash

curl -s -X POST -H 'Content-Type: application/json' -d '{ "name": "connect-increment-sink", "config": { "connector.class": "org.increment.IncrementSinkConnector", "topics": "seq_1,seq_100", "confluent.topic.bootstrap.servers": "kafka:9092", "confluent.license": "", "key.converter": "org.apache.kafka.connect.storage.StringConverter", "tasks.max": "2" } }' http://connect:8083/connectors | jq .

#curl connect:8083/connectors/connect-increment-sink/status | jq
#curl -X DELETE localhost:8083/connectors/connect-increment-sink/
#curl connect:8083/connectors/connect-increment-sink/pause | jq