public class Arithmetic {

    private final int resolve;

    public Arithmetic(String expression) {
        expression = expression.toUpperCase().replaceAll(" ", "");

        String action = whatOperation(expression);

        String[] arrExpression = expression.split(action);

        RomeNum num1;
        RomeNum num2;

        if (checkForInt(arrExpression[0]) && checkForInt(arrExpression[1])) {
            num1 = new RomeNum(Integer.parseInt(arrExpression[0]));
            num2 = new RomeNum(Integer.parseInt(arrExpression[1]));
        } else {
            num1 = new RomeNum(arrExpression[0]);
            num2 = new RomeNum(arrExpression[1]);
        }

        resolve = operation(num1.toInt(), action, num2.toInt());

        if (num1.isRoman) System.out.println(new RomeNum(resolve).toString());                             //к римскому числу
        else System.out.println(resolve);

    }

    /*Проверяем является ли строка числом*/
    public boolean checkForInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*Извлекаем арифметическую операцию из выражения*/
    public String whatOperation(String expression) {
        String action;
        if (expression.contains("+"))
            action = "\\+";
        else if (expression.contains("-"))
            action = "-";
        else if (expression.contains("/"))
            action = "/";
        else if (expression.contains("*"))
            action = "\\*";
        else
            throw new IllegalArgumentException("Arithmetic operations not found.");
        return action;
    }

    public int operation(int first, String action, int second) {
        switch (action) {
            case "\\+":
                return first + second;
            case "-":
                return first - second;
            case "\\*":
                return first * second;
            case "/": {
                if (second == 0) throw new ArithmeticException("Divided by zero.");
                else return first / second;
            }
            default:
                return -1;
        }
    }
}
