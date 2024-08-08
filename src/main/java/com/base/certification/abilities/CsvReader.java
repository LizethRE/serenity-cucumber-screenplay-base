package com.base.certification.abilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import net.serenitybdd.screenplay.Ability;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvReader implements Ability {
    private static List<String[]> data;

    public CsvReader(String filePath) {
        setFile(filePath);
    }

    private void setFile(String filePath) {
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
            data = csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCsvData(int rowNumber, int columnNumber) {
        return data.get(rowNumber)[columnNumber];
    }

    public static CsvReader from(String filePath) {
        return new CsvReader(filePath);
    }
}
