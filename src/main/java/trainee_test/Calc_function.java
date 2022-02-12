package trainee_test;

public class Calc_function {
    /*where the calculation will happen dont use the math library
    * Mortage formula:
    E = Fixed monthly payment
    b = Interest on a monthly basis
    U = Total loan
    p = Number of payments
    E = U[b(1 + b)^p]/[(1 + b)^p - 1]
    *  */
    public int Mortage_calc(int E, int b, int U, int p){

        int temp_A = b*(1+b)^p;
        int temp_B = (1+b)^p - 1;

        E = U*(temp_A)/(temp_B);

        return E;
    }
}
