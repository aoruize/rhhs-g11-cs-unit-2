import java.util.Scanner;

public class TemperatureCalc {

public static void main(String[] args) {
  double f,c;
  Scanner myScanner = new Scanner(System.in);
  System.out.println("Enter the degress F: ");
  f = myScanner.nextDouble();
  c = convertFtoC(f);
  System.out.println("Degrees C: ");
  System.out.println(c);
}

public static double convertFtoC(double fahrenheit) {
  double celsius;
  celsius = (fahrenheit - 30) / 2;
  return celsius;
}
}
