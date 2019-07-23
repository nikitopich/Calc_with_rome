import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   //инициализируем прееменную
                                                                                        //для чтения с клавиатуры

        System.out.print("Please enter an expression: ");
        String expression = reader.readLine();
        System.out.print("Result is: ");
        Arithmetic arithmetic = new Arithmetic(expression);                             //выполяем все действия
    }
}
