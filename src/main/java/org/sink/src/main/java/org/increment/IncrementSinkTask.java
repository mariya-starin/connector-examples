package org.increment;

import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.Map;
import java.io.PrintStream;

public class IncrementSinkTask extends SinkTask {

    private static final Logger log = LoggerFactory.getLogger(IncrementSinkTask.class);

    PrintStream outputStream;

    public IncrementSinkTask(){}

    @Override
    public String version() {
        return new IncrementSinkConnector().version();
    }

    @Override
    public void start(Map<String, String> props) {
        outputStream = System.out;
        log.info("starting");
    }

    @Override
    public void put(Collection<SinkRecord> records) {
        for(SinkRecord record : records) {
            outputStream.println(record.value());
        }
    }

    @Override
    public void stop() {
        if (outputStream != null)
            outputStream.close();
    }
}
