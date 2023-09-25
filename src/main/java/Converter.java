class Converter {
    Integer romanToArabic(String romanNumber) {
        int summary = 0;
        int currentNumber = 0;

        for (int x = romanNumber.length() - 1; x >= 0 ; x--) {
            char currentSymbol = romanNumber.charAt(x);
            switch (currentSymbol) {
                case 'X' -> {
                    summary = convertingToArabic(10, currentNumber, summary);
                    currentNumber = 10;
                }
                case 'V' -> {
                    summary = convertingToArabic(5, currentNumber, summary);
                    currentNumber = 5;
                }
                case 'I' -> {
                    summary = convertingToArabic(1, currentNumber, summary);
                    currentNumber = 1;
                }
                default -> {}
            }
        }
        return summary;
    }

    private int convertingToArabic(int digit, int currentNumber, int summary) {
        if (currentNumber > digit) {
            return summary - digit;
        } else {
            return summary + digit;
        }
    }

    String arabicToRoman(int arabicNumber) {
        StringBuilder summary = new StringBuilder();
        while (arabicNumber != 0) {
            String s = convertingToRoman(arabicNumber);
            switch (s) {
                case "M" -> arabicNumber -= 1000;
                case "CM" -> arabicNumber -= 900;
                case "D" -> arabicNumber -= 500;
                case "CD" -> arabicNumber -= 400;
                case "C" -> arabicNumber -= 100;
                case "XC" -> arabicNumber -= 90;
                case "L" -> arabicNumber -= 50;
                case "XL" -> arabicNumber -= 40;
                case "X" -> arabicNumber -= 10;
                case "IX" -> arabicNumber -= 9;
                case "V" -> arabicNumber -= 5;
                case "IV" -> arabicNumber -= 4;
                case "I" -> arabicNumber -= 1;
                default -> {}
            }
            summary.append(s);
        }
        return String.valueOf(summary);
    }

    private String convertingToRoman(int arabicNumber) {
        if (arabicNumber >= 1000)   return "M";
        if (arabicNumber >= 900)    return "CM";
        if (arabicNumber >= 500)    return "D";
        if (arabicNumber >= 400)    return "CD";
        if (arabicNumber >= 100)    return "C";
        if (arabicNumber >= 90)     return "XC";
        if (arabicNumber >= 50)     return "L";
        if (arabicNumber >= 40)     return "XL";
        if (arabicNumber >= 10)     return "X";
        if (arabicNumber == 9)      return "IX";
        if (arabicNumber >= 5)      return "V";
        if (arabicNumber == 4)      return "IV";
        if (arabicNumber >= 1)      return "I";
        else                        return "";
    }
}
