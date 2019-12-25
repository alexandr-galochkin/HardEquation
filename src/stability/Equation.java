package stability;

public class Equation {
    double valueCauchy;
    double coeff;
    public  Equation(double t, double y, double a){
        valueCauchy = Math.exp(-a*t)*y;
        coeff = a;
    }

    double valueFunction(double y){
        return coeff*y;
    }

    double valueSolution(double t){
        return Math.exp(coeff*t)*valueCauchy;
    }

    @Override
    public String toString(){
        return ("правая часть уравнения: " + + coeff + "*y\nЗначение C при задаче Коши y(0) = 1: " + valueCauchy);
    }
}
