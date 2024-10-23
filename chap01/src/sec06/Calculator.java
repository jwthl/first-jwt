package sec06;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        // 사용자 입력 받기
        System.out.println("첫 번째 숫자를 입력하세요: ");
        num1 = scanner.nextDouble();

        System.out.println("연산자를 입력하세요 (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        System.out.println("두 번째 숫자를 입력하세요: ");
        num2 = scanner.nextDouble();

        // 연산 수행
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("결과: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("결과: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("결과: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("결과: " + result);
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                System.out.println("유효하지 않은 연산자입니다.");
        }

        scanner.close();
    }
}