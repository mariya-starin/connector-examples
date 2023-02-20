#! /bin/bash


kafka-console-consumer --bootstrap-server localhost:9092 --topic seq_1 --from-beginning

kafka-topics --list --bootstrap-server localhost:9092