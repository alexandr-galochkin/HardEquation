package stability;

import java.util.Arrays;
import java.util.Scanner;

import static stability.Solution.*;

public class Calculation {
    public static void main(String[] args) {
        System.out.println("Задача определения устойчивости жёстких уравнений.");
        Scanner scanner = new Scanner(System.in);
        try {
            Equation equation = new Equation(0, 1, -17);
            double x_0 = 0;
            System.out.println("Рассмотрим уравнение y' = ay, где " + equation.toString());
            System.out.println("Введите 2 числа: количество точек и шаг.");
            int N = scanner.nextInt();
            double h = scanner.nextDouble();
            double[] exactSol = exactSolution(equation,x_0, N, h);
            double[] eulerSol = eulerSolution(equation,x_0, N, h);
            double[] reverseEulerSol = reverseEulerSolution(equation,x_0, N, h);
            double[] extrAdamsSol = extrapolationAdamsSolution(equation,x_0, N, h);

            System.out.println("Точное решение: \n" + Arrays.toString(exactSol) + "\n");
            System.out.println("Приближённое значение методом Эйлера: \n" + Arrays.toString(eulerSol));
            System.out.println(stabilityOfEuler(equation, h) + "\n");
            System.out.println("Приближённое значение обратным методом Эйлера: \n" + Arrays.toString(reverseEulerSol));
            System.out.println(stabilityOfReverseEuler(equation, h) + "\n");
            System.out.println("Приближённое значение экстраполяционным методом Адамса второго порядка: \n" + Arrays.toString(extrAdamsSol));
            System.out.println(stabilityOfExtrapolationAdams(equation, h) + "\n");

        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}
