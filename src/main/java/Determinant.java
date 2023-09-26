import java.util.List;

class Determinant {

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