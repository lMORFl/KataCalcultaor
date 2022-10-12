import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};

        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();

        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }

        if(actionIndex==-1){
            throw new IllegalArgumentException("Неверный знак выражения");
        }

        String[] data = exp.split(regexActions[actionIndex]);
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (actions[actionIndex]) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "*" -> result = a * b;
                case "/" -> result = a / b;
                default -> throw new Exception("Неверный знак в выражении");
            }
            if(isRoman){
                System.out.println(converter.intToRoman(result));
                throw new NullPointerException("Отрицательных римских чисел нет");
            }
            else{
                System.out.println(result);
            }
        }else{
                throw new Exception("Нельзя использовать арабские и римские числа в одном выражении");
        }


    }
}