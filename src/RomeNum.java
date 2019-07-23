public class RomeNum {

    private final int decimal;      //Хранит преобразованное значение

    private static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static String[] letters = {"M", "CM", "D", "CD" , "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public RomeNum(int valueIN){
        if (valueIN < 0)
            throw new NumberFormatException("Rome number must be positive");

        if (valueIN > 3999)
            throw new NumberFormatException("Rome number must be under 3999");

        decimal = valueIN;
    }


    public RomeNum(String valueIN) {
        if (valueIN.length() == 0)
            throw new NumberFormatException("Input is empty.");

        valueIN = valueIN.toUpperCase();

        int i = 0;
        int decimal = 0;    //Римское число в десятичном виде, итоговое  число в перспективе

        while (i < valueIN.length()) {

            int number = letterToInt(valueIN.charAt(i));    //Десятичная интерпритация римской цифры

            if (number < 0)
                throw new NumberFormatException("Illegal character \"" + valueIN.charAt(i) + "\" in rome number.");

            i++;

            if (i == valueIN.length()) {
                decimal += number;
            } else {
                int nextNumber = letterToInt(valueIN.charAt(i));
                if (nextNumber > number) {
                    decimal += (nextNumber - number);
                    i++;
                } else {
                    decimal += number;
                }
            }
        }

        if (decimal > 3999)
            throw new NumberFormatException("Roman number must have only under 3999.");

        this.decimal = decimal;
    }

    public int letterToInt(char letter) {
        switch (letter) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return -1;
        }
    }

    @Override
    public String toString() {
        StringBuilder roman = new StringBuilder();
        int valueIN = decimal;
        for (int i = 0; i < numbers.length; i++) {
            while (valueIN >= numbers[i]){
                roman.append(letters[i]);
                valueIN -= numbers[i];
            }
        }
        return roman.toString();
    }

    public int toInt(){
        return this.decimal;
    }
}
