package org.example;

import org.example.model.Direction;
import org.example.model.Lawn;
import org.example.model.Mower;
import org.example.model.Operation;
import org.example.service.FileReader;
import org.example.service.MowerOperator;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\guru\\LawnMover.txt";
        FileReader fileReader = new FileReader();
        try {
            List<String> dataLines = fileReader.readFile(filePath);
            if (Optional.ofNullable(dataLines).isPresent() && dataLines.size() > 0) {
                String data = dataLines.get(0);
                if (Optional.ofNullable(data).isPresent() && data.length() == 2) {
                    int length = data.charAt(1)-48;
                    int width = data.charAt(1)-48;
                    Lawn lawn = new Lawn(length, width);
                    dataLines.remove(0);
                    processMowerData(dataLines,lawn);
                }
            }
        } catch (IOException ex) {
            System.out.println("Exception occured while reading file");
        }
        catch (Exception  ex) {
            System.out.println("Exception occured while executing Operation");
        }

    }

    private static void processMowerData(List<String> dataLines,Lawn lawn) {
        int index=1;
        Mower mower = null;
        for (String dataLine : dataLines) {
            if(Objects.nonNull(dataLine)){
                if (index % 2 == 1) {
                    String[] str = dataLine.split(" ");
                    if(Objects.nonNull(str) && str.length==2 && str[0].length()==2){
                        int posx = str[0].charAt(0)-48;
                        int posy = str[0].charAt(1)-48;
                        Direction direction = Arrays.stream(Direction.values()).filter(val -> val.toString().equalsIgnoreCase(str[1])).findFirst().orElse(null);
                        mower = new Mower(posx, posy, direction);
                    }
                } else {
                    if(Objects.nonNull(mower)){
                        MowerOperator mowerOperator = new MowerOperator(mower);
                        dataLine.chars()
                                .forEach((val) -> mowerOperator.operate(lawn,(char)val));
                        System.out.println(mower);
                    }
                }
                index++;
            }
        }
    }
}