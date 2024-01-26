public class RomanToDecimal {
    private static final char[] romanNumerals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static final int[] decimalValues = {1, 5, 10, 50, 100, 500, 1000};

    public static int romanToDecimal(String roman) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentIndex = indexOf(romanNumerals, currentChar);
            int currentValue = decimalValues[currentIndex];

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    private static int indexOf(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String romanNumber = "LXI";
        int decimalNumber = romanToDecimal(romanNumber);

        System.out.println("Roman Number: " + romanNumber);
        System.out.println("Decimal Number: " + decimalNumber);
    }
}
