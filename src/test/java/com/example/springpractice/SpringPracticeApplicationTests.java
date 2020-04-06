package com.example.springpractice;

import com.example.springpractice.entity.TestEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.beans.binding.ObjectBinding;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

class SpringPracticeApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(SpringPracticeApplication.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    void unknown_properties_test() throws JsonProcessingException {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TestEntity test = new TestEntity("test");

        String result = OBJECT_MAPPER.writeValueAsString(test);

        log.info("result : {}", result);

        String json = "{\"value\":\"test\", \"value2\":\"test2\"}";
//        String json = "{\"value\":\"test\"}";

        TestEntity object = OBJECT_MAPPER.readValue(json, TestEntity.class);

        assertThat(object).isEqualTo(new TestEntity("test"));
    }
}
