package legendsofvalor.utils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class InputCheck {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static double[] Probability_check(Scanner in) {
        double[] result = new double[3];
        System.out.println("Set up your favored world with the probabilities!");
        while (true) {
            try {
                double left = 0.9;
                System.out.println("Each Probability should be bewteen 0.1-0.8; default:(0.2,0.2,0.2):");
                System.out.println("Bush Probability or default: ");
                String s = in.nextLine();
                if (s.equalsIgnoreCase("default")) {
                    result[0] = 0.2;
                    result[1] = 0.2;
                    result[2] = 0.2;
                    return result;
                }
                double p1 = Double.valueOf(s);
                if (p1 < 0.1 || p1 > 0.8) {
                    throw new Exception();
                }
                left -= p1;
                System.out.println("The left Probability is " + df.format(left));
                System.out.println("Cave Probability: ");
                double p2 = Double.valueOf(in.nextLine());
                if (p2 < 0.1 || p2 > left) {
                    throw new Exception();
                }
                left -= p2;
                System.out.println("The left Probability is " + df.format(left));
                System.out.println("Koulou Probability: ");
                double p3 = Double.valueOf(in.nextLine());
                if (p3 < 0.1 || p3 > left) {
                    throw new Exception();
                }
                result[0] = p1;
                result[1] = p2;
                result[2] = p3;
                break;
            } catch (Exception e) {
                String alert = ColorPrint.redString("Not valid settings, input from beginning again. Each Probability should be between(0.1-0.8). " + "In total should not exceed 0.9");
                System.out.println(alert);
            }
        }
        return result;
    }
}
