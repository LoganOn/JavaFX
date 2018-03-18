package sample;

public class Search {
    public static String search(String sequance, String pattern) {
        //Tniemy sekwencje na fragmenty w miejscac, gdzie wystepuje wzorzec
        String[] between = sequance.split(pattern);
        //tu bedzie docelowa sekwencja zgodna ze wzorcem
        String result = "";
        if (between.length > 1) {
            //Pobieramy kolejno odcinki wystepujace pomiedzy miejscami wystepowania wzorca, az do przedostatniego
            for (int i = 0;
                 i < between.length - 1; i++) {
                //odgradzamy wzorzec znakami "</>" od reszty tekstu
                if (result.length() == 0) {
                    result = result + between[i] + "<" + pattern + ">" + between[i + 1];
                } else {
                    result = result + "<" + pattern + ">" + between[i + 1];
                }

            }
            //to w przypadku, gdy wzorzec znajduje sie tez na koncu sekwencji
            if (sequance.indexOf(pattern, sequance.length() - pattern.length()) > 0) {
                result = result + "<" + pattern + ">";
            }

        } else {
            result = sequance;
        }

        return result;
    }
}
