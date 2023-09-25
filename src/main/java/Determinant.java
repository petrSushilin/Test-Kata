class Determinant {

    boolean isNumeral(String string) {
        return isArabic(string) && isRoman(string);
    }

    boolean isFunction(String string) {
        return string.contains("[+-*/]");
    }

    boolean isArabic(String string) {
        return string.contains("[0-9]");
    }

    boolean isRoman(String string) {
        return string.contains("[IVXLCDM]");
    }

}