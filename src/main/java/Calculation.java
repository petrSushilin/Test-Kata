import java.util.ArrayList;
import java.util.List;

class Calculation {
    private String[] inputStrings;
    private List<String> numerals = new ArrayList<>();
    private List<Integer> arabicPerformance = new ArrayList<>();
    private List<String> functions = new ArrayList<>();
    private Calculator calculator = new Calculator();
    private Converter converter = new Converter();
    private Determinant determinant = new Determinant();

    String start (String inputString) {
        inputStrings = inputString.split(" ");

        if (inputStrings.length != 3) throw new IllegalStateException("Length is not correct");

        for (int i = 0; i < inputStrings.length; i++) {
            if (i % 2 == 0) {
                if (determinant.isNumeral(inputStrings[i])) numerals.add(inputStrings[i]);
            } else {
                if (determinant.isFunction(inputStrings[i])) functions.add(inputStrings[i]);
            }
        }

        if (!determinant.isCorrectFormatNumerals(numerals))
                                            throw new NumberFormatException("The numerals type are different");

        if (determinant.isRoman(numerals.get(0))) {
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

}
