class Calculator {

    int arithmetic(String function, int aNumber, int bNumber) {

        return switch (function) {
            case ("+") -> addition(aNumber, bNumber);
            case ("-") -> subtraction(aNumber, bNumber);
            case ("*") -> multiplication(aNumber, bNumber);
            case ("/") -> division(aNumber, bNumber);
            default -> throw new RuntimeException("incorrect function");
        };

    }

    int addition(int aNumber, int bNumber) {
        return aNumber + bNumber;
    }

    int subtraction (int aNumber, int bNumber) {
        return aNumber - bNumber;
    }

    int multiplication (int aNumber, int bNumber) {
        return aNumber * bNumber;
    }

    int division(int aNumber, int bNumber) {
        return aNumber / bNumber;
    }

}
