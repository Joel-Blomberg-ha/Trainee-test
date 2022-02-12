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
    public double Mortage_calc(double E, double b, double U, double p){
        // with the mortage calc the problem is that java doesn't like the circumflex symbol ^ because it supposedly has a use case and specific meaning
        // that I'm unaware of and I couldn't find a suitable solution in time since i was still working on reading in the information

       // double temp_A = b*(1+b)^p;
       // double temp_B = (1+b)^p - 1;

       // E = U*(temp_A)/(temp_B);

        return E;
    }
}
