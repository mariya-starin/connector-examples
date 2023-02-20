kafka-producer-perf-test \
--producer.config java.config \
--throughput 200 \
--record-size 1000 \
--num-records 3000 \
--topic perf-test-topic \
--producer-props linger.ms=0 batch.size=16384 \
--print-metrics | grep \
"3000 records sent\|\
producer-metrics:outgoing-byte-rate\|\
producer-metrics:bufferpool-wait-ratio\|\
producer-metrics:record-queue-time-avg\|\
producer-metrics:request-latency-avg\|\
producer-metrics:batch-size-avg"


