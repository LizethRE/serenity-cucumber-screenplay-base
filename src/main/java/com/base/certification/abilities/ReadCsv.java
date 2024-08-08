package com.base.certification.abilities;

import au.com.bytecode.opencsv.CSVReader;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ReadCsv implements Ability {
    private static List<String[]> data;

    public ReadCsv(String filePath) {
        setFile(filePath);
    }

    public static ReadCsv as(Actor actor) {
        return actor.abilityTo(ReadCsv.class);
    }

    public void setFile(String filePath) {
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
            data = csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCell(int rowNumber, int columnNumber) {
        return data.get(rowNumber)[columnNumber];
    }

    public static ReadCsv from(String filePath) {
        return new ReadCsv(filePath);
    }
}
