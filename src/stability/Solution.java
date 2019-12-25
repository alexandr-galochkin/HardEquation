package stability;

public class Solution {
    public static double[] exactSolution(Equation equation, double x_0, int N, double h){
        double[] result = new double[N];
        for (int i = 0; i < N; i++){
            result[i] = equation.valueSolution(x_0 + i*h) ;
        }
        return result;
    }

    public static double[] eulerSolution(Equation equation, double x_0, int N, double h){
        double[] result = new double[N];
        result[0] = equation.valueCauchy;
        for (int i = 1; i < N; i++){
            result[i] = (1 + equation.coeff*h)*result[i-1];
        }
        return result;
    }

    public static String stabilityOfEuler(Equation equation, double h){
        if ((-equation.coeff*h > 0) && (-equation.coeff*h < 2)){
            return "Метод Эйлера абсолютно устойчив.";
        }
        if (h < -2/equation.coeff){
            return "Метод Эйлера устойчив.";
        }
        return "Метод Эйлера неустойчив.";
    }

    public static double[] reverseEulerSolution(Equation equation, double x_0, int N, double h){
        double[] result = new double[N];
        result[0] = equation.valueCauchy;
        for (int i = 1; i < N; i++){
            result[i] = result[i-1]/(1 - equation.coeff*h);
        }
        return result;
    }

    public static String stabilityOfReverseEuler(Equation equation, double h){
        if (equation.coeff < 0){
            return "Обратный метод Эйлера устойчив.";
        }
        return "Обратный метод Эйлера неустойчив.";
    }

    public static double[] extrapolationAdamsSolution(Equation equation, double x_0, int N, double h){
        double[] result = new double[N];
        result[0] = equation.valueCauchy;
        result[1] = (1 + equation.coeff*h)*result[0];
        for (int i = 2; i < N; i++){
            result[i] = (1 + 3*equation.coeff*h/2)*result[i-1] - equation.coeff*h/2*result[i-2];
        }
        return result;
    }

    public static String stabilityOfExtrapolationAdams(Equation equation, double h){
        if (h < -1/equation.coeff){
            return "Экстраполяционный метод Адамса второго порядка устойчив.";
        }
        return "Экстраполяционный метод Адамса второго порядка неустойчив.";
    }
}
