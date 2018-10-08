package ru.ifmo.cet.javabasics;

import java.io.*;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.nio.file.Files;
import java.nio.charset.Charset;





public class WarAndPeaceExercise {

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        Map<String,Integer> list=new HashMap<>();
        try {
            for (String words : Files.readAllLines(tome12Path, Charset.forName("windows-1251"))) {
                words = words.replaceAll("[^a-zA-Zа-яА-Я]", " ");
                for (String word : words.split(" ")) {
                    if (word.length() < 4) continue;
                    word = word.toLowerCase();
                    if (list.containsKey(word))
                        list.replace(word, list.get(word) + 1);
                    else
                        list.put(word, 1);
                }
            }
        }catch (IOException e){}
        try {
            for (String words : Files.readAllLines(tome34Path, Charset.forName("windows-1251"))) {
                words = words.replaceAll("[^a-zA-Zа-яА-Я]", " ");
                for (String word : words.split(" ")) {
                    if (word.length() < 4) continue;
                    word = word.toLowerCase();
                    if (list.containsKey(word))
                        list.replace(word, list.get(word) + 1);
                    else
                        list.put(word, 1);
                }
            }
        }catch (IOException e){}

        List<Map.Entry<String,Integer>> sorted = new ArrayList<>(list.entrySet());
        Collections.sort(sorted, new Comparator<Map.Entry<String,Integer>>(){
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue().equals(o2.getValue()))
                            return o1.getKey().compareTo(o2.getKey());
                        else
                            return o2.getValue().compareTo(o1.getValue());
                    }

        });
        String res="";
        for(Map.Entry elem: sorted){
            if ((Integer)elem.getValue()>=10)
                res+=elem.getKey()+" - "+elem.getValue()+"\n";
        }



        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10


        return res.trim();
       // throw new UnsupportedOperationException();

    }

}