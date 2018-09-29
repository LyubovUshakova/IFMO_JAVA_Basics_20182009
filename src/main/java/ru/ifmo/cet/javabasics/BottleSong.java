package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {
    private int bottleTakenAtOnce;

    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce=bottleTakenAtOnce;
        //TODO
    }

    public String getBottleSongLyrics() {
        if ((bottleTakenAtOnce>0)&&(bottleTakenAtOnce<100)) {
            String text = "99 bottles of beer on the wall, 99 bottles of beer.\n";
            int bottles = 99;
            String s = bukovki(bottleTakenAtOnce);
            while (bottles > bottleTakenAtOnce) {
                bottles -= bottleTakenAtOnce;
                text = text + "Take " + s + " down and pass around, " + Integer.toString(bottles) + " bottles of beer on the wall.\n"
                        + Integer.toString(bottles) + " bottles of beer on the wall, " + Integer.toString(bottles) + " bottles of beer.\n";
            }
            text += "Take " + bukovki(bottles) + " down and pass around, no more bottles of beer on the wall.\n" +
                    "No more bottles of beer on the wall, no more bottles of beer.\n" +
                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
            return text;

        }else


            //TODO
            throw new UnsupportedOperationException();
    }
    public String bukovki(int chiselki){
        String s = "";
        if ((chiselki > 9) && (chiselki < 20)) {

            switch (chiselki) {

                case 10:
                    s = "ten";
                    break;
                case 11:
                    s = "eleven";
                    break;
                case 12:
                    s = "twelve";
                    break;
                case 13:
                    s = "thirteen";
                    break;
                case 14:
                    s = "fourteen";
                    break;
                case 15:
                    s = "fifteen";
                    break;
                case 16:
                    s = "sixteen";
                    break;
                case 17:
                    s = "seventeen";
                    break;
                case 18:
                    s = "eighteen";
                    break;
                case 19:
                    s = "nineteen";
                    break;
            }

        } else {
            int div = chiselki / 10;
            int mod = chiselki % 10;
            String s1 = "";
            String s2 = "";
            //if (a>=2)
            switch (div) {
                case 2:
                    s1 = "twenty";
                    break;
                case 3:
                    s1 = "thirty";
                    break;
                case 4:
                    s1 = "fourty";
                    break;
                case 5:
                    s1 = "fifty";
                    break;
                case 6:
                    s1 = "sixty";
                    break;
                case 7:
                    s1 = "seventy";
                    break;
                case 8:
                    s1 = "eighty";
                    break;
                case 9:
                    s1 = "ninty";
                    break;
            }
            switch (mod) {
                case 1:
                    s2 = "one";
                    break;
                case 2:
                    s2 = "two";
                    break;
                case 3:
                    s2 = "three";
                    break;
                case 4:
                    s2 = "four";
                    break;
                case 5:
                    s2 = "five";
                    break;
                case 6:
                    s2 = "six";
                    break;
                case 7:
                    s2 = "seven";
                    break;
                case 8:
                    s2 = "eight";
                    break;
                case 9:
                    s2 = "nine";
                    break;
            }
            s = s1 +" "+ s2;
        }
        return s;
    }
}

