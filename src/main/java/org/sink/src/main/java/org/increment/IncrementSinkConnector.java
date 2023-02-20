package org.increment;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;
import org.apache.kafka.common.config.AbstractConfig;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.common.utils.AppInfoParser;

public class IncrementSinkConnector extends SinkConnector {

    private static final Logger log = LoggerFactory.getLogger(IncrementSinkConnector.class);
    private static final ConfigDef CONFIG_DEF = new ConfigDef();
    @Override
    public void start(Map<String, String> props) {
        log.info("STARTING IncrementSinkConnector");
        AbstractConfig parsedConfig = new AbstractConfig(CONFIG_DEF, props);
    }
    @Override
    public Class<? extends Task> taskClass() {
        return IncrementSinkTask.class;
    }
    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        /***********************
         * groupPartitions groups our increments and speads them evenly over our groups
         **********************/
        List<Map<String, String>> taskConfigs = new ArrayList<>();


        Map<String, String> taskProps = new HashMap<>();
        taskProps.put("topic", "seq_1");
        Map<String, String> taskProps1 = new HashMap<>();
        taskProps.put("topic", "seq_100");
        taskConfigs.add(taskProps);
        taskConfigs.add(taskProps1);
        return taskConfigs;
    }
    @Override
    public void stop() {
    }
    @Override
    public ConfigDef config() {
        return CONFIG_DEF;
    }

    @Override
    public String version() {
        return AppInfoParser.getVersion();
    }
}
