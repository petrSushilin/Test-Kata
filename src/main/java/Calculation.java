import java.util.ArrayList;
import java.util.List;

class Calculation {
    private String[] inputStrings;
    private List<String> numerals = new ArrayList<>();
    private List<Integer> arabicPerformance = new ArrayList<>();
    private List<String> functions = new ArrayList<>();
    private Calculator calculator = new Calculator();
    private Converter converter = new Converter();

    String start (String inputString) {
        inputStrings = inputString.split(" ");

        if (inputStrings.length != 3) throw new IllegalStateException("Length is not correct");

        for (int i = 0; i < inputStrings.length; i++) {
            if (i % 2 == 0) {
                if (isNumeral(inputStrings[i])) numerals.add(inputStrings[i]);
            } else {
                if (isFunction(inputStrings[i])) functions.add(inputStrings[i]);
            }
        }

        if (!isCorrectFormatNumerals(numerals)) throw new NumberFormatException("The numerals type are different");

        if (isRoman(numerals.get(0))) {
            numerals.forEach(numeral -> arabicPerformance.add(converter.romanToArabic(numeral)));

            if (functions.get(0).equals("-") && arabicPerformance.get(1) > arabicPerformance.get(0)) {
                throw new RuntimeException("It can't be negative");
            }

            int answer = calculate();

            return String.valueOf(converter.arabicToRoman(answer));
        } else {
            numerals.forEach(numeral -> arabicPerformance.add(Integer.parseInt(numeral)));

            return String.valueOf(calculate());
        }
    }

    // if once we will need to make more than 1 operation here we make cycle with priorities and black jack :)
    private int calculate() {
        return calculator.arithmetic(functions.get(0), arabicPerformance.get(0), arabicPerformance.get(1));
    }

    boolean isCorrectFormatNumerals(List<String> numerals) {
        boolean isArabic = false;
        boolean isRoman = false;

        for (String numeral : numerals) {
            if (isArabic(numeral)) isArabic = true;
            if (isRoman(numeral)) isRoman = true;
        }

        return isArabic ^ isRoman;
    }

    boolean isFunction(String string) {
        return string.matches("[-*/+]+");
    }

    boolean isArabic(String string) {
        return string.matches("[0-9]+");
    }

    boolean isRoman(String string) {
        return string.matches("[IVXLCDM]+");
    }

    boolean isNumeral(String string) {
        return isArabic(string) || isRoman(string);
    }

}
