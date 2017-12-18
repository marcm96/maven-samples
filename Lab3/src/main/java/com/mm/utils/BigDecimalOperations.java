package com.mm.utils;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BigDecimalOperations {

    public static BigDecimal computeSum(List<BigDecimal> bigDecimals){
        return bigDecimals.stream()
                          .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal computeAverage(List<BigDecimal> input) {
        return computeSum(input).divide(BigDecimal.valueOf(input.size()), RoundingMode.UP);
    }

    public static List<BigDecimal> topTen(List<BigDecimal> input) {
        List<BigDecimal> temp =
                input.stream().sorted((o1, o2) -> o1.compareTo(o2) * -1).
                        collect(toList());
        return temp.stream()
                .limit((long) (temp.size() * 0.1)).collect(toList());
    }

    public static void serializeItems(List<BigDecimal> input, String fileOutput) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("/tmp/" + fileOutput);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            for ( BigDecimal item : input) {
                out.writeObject(item);
            }
            out.close();
            fileOutputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void deserializeItems(List<BigDecimal> readDecimals, String inputFile) {
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/" + inputFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            for ( int i = 0; i < 9999; i++) {
                readDecimals.add((BigDecimal) in.readObject());
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("BigDecimals class not found");
            c.printStackTrace();
        }
    }
}
