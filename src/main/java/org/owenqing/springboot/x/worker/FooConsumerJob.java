package org.owenqing.springboot.x.worker;

import lombok.val;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.owenqing.springboot.x.config.FooKafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Collections;

@Component
public class FooConsumerJob {
    @Autowired
    FooKafkaConfig kafkaConfig;

    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        val consumer = new KafkaConsumer<String, String>(kafkaConfig.getProps());
        consumer.subscribe(Collections.singleton("kanas"));
        Thread job = new Thread(() -> {
            try {
                for(;;) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                    records.forEach(item -> {
                        System.out.println(item.value());
                        consumer.commitSync();
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                consumer.close();
            }
        });
        job.start();
    }

    @PostConstruct
    private void init() {
        run();
    }
}
