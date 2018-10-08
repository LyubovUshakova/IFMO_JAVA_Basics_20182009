package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.charset.Charset;
import static java.nio.file.Files.readAllLines;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;


public class WarAndPeaceExercise {
  //  public static String warAndPeace(){

    public static String warAndPeace() throws IOException {
            final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
            final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

            // TODO map lowercased words to its amount in text and concatenate its entries.
            // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
            // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
            // TODO Also omit any word with lengths less than 4 and frequency less than 10
            Map<String, Integer> dictionary = new HashMap<>();

            throw new UnsupportedOperationException();

        String book = String.join(" ",readAllLines(tome12Path, Charset.forName("windows-1251")));
        book+=String.join(" ",readAllLines(tome34Path, Charset.forName("windows-1251")));
        book=book.replaceAll("[^a-zA-Zа-яА-Я]", " ").toLowerCase();
        Stream<String> words = Stream.of(book.split(" "));
        words.filter(word->word.length()>=4);
        words.forEach((String key) -> dictionary.put(key, dictionary.containsKey(key) ? dictionary.get(key) + 1 : 1));
        List<Map.Entry<String,Integer>> res = new ArrayList<>(dictionary.entrySet());
        res.sort((entry1, entry2)->(entry1.getValue().equals(entry2.getValue())) ?
                entry1.getKey().compareTo(entry2.getKey()) : entry2.getValue().compareTo(entry1.getValue()));
        String result = res.stream().filter(c->c.getValue()>=10)
                .map(a -> a.getKey() + " - " + a.getValue()).map(Object::toString);
        return result;


    }

}