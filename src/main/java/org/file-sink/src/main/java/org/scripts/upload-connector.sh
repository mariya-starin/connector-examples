#! /bin/bash

curl -s -X POST -H 'Content-Type: application/json' -d '{ "name": "connect-file-sink", "config": { "connector.class": "org.sink.FileStreamSinkConnector", "topics": "seq_1,seq_100", "confluent.topic.bootstrap.servers": "kafka:9092", "confluent.license": "", "key.converter": "org.apache.kafka.connect.storage.StringConverter", "tasks.max": "2", "file": "newfile" } }' http://connect:8083/connectors | jq .

#curl connect:8083/connectors/connect-file-sink/status | jq
#curl -X DELETE localhost:8083/connectors/connect-file-sink/
