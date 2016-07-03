package ecg.imaginatio.subin.miniecg;


public class filter2 {
    void fil(final double a[], final double b[], final double N[], double p
            []) {
        double b_b[] = new double[3];
        double b_a[] = new double[3];
        int k;
        double dbuffer[] = new double[3];
        int j;
        for (k = 0; k < 3; k++) {
            b_b[k] = b[k];
            b_a[k] = a[k];
        }


        for (k = 0; k < 3; k++) {
            b_b[k] /= a[0];
        }

        for (k = 0; k < 2; k++) {
            b_a[k + 1] /= a[0];
        }

        b_a[0] = 1.0;


        for (k = 0; k < 2; k++) {
            dbuffer[k + 1] = 0.0;
        }

        for (j = 0; j < 2000; j++) {
            for (k = 0; k < 2; k++) {
                dbuffer[k] = dbuffer[k + 1];
            }

            dbuffer[2] = 0.0;
            for (k = 0; k < 3; k++) {
                dbuffer[k] += N[j] * b_b[k];
            }

            for (k = 0; k < 2; k++) {
                dbuffer[k + 1] -= dbuffer[0] * b_a[k + 1];
            }

            p[j] = dbuffer[0];
        }
    }
}
