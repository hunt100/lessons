package org.example.homework2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class TaskTwo {

    private static final ObjectMapper objectMapper = configureObjectMapper();

    private static ObjectMapper configureObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(System.getProperty("file.encoding"));
        File file = getFileByName("data.json");
        List<Student> students = objectMapper.readValue(file, new TypeReference<>() {});
        students.forEach(student -> System.out.println(student.toString()));

    }

    private static File getFileByName(String name) throws URISyntaxException {
        URL resource = TaskTwo.class.getClassLoader().getResource(name);
        if (resource == null) {
            throw new IllegalArgumentException("File " + name + " not found");
        }
        return new File(resource.toURI());
    }

}
