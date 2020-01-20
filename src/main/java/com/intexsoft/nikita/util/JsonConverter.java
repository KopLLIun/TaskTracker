package com.intexsoft.nikita.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.nikita.entity.Task;

import java.io.IOException;
import java.util.List;

public class JsonConverter {

    public static String toJSON(List<Task> taskList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("json created!");
        return mapper.writeValueAsString(taskList);
    }
/*
    public static Task toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Task.class);
    }*/
}
