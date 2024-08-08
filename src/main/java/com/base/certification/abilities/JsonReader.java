package com.base.certification.abilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Ability;

import java.io.File;
import java.io.IOException;

public class JsonReader implements Ability {
    private static JsonNode jsonNode;

    public JsonReader(String filePath) {
        jsonNode = loadJson(filePath);
    }

    private JsonNode loadJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getJsonData(int index, String key) {
        return jsonNode.get(index).get(key).asText();
    }

    public static JsonReader from(String filePath) {
        return new JsonReader(filePath);
    }
}
