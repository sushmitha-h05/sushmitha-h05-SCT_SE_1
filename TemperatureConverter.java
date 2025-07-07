import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("Enter the temperature value:");
        double temp = scanner.nextDouble();

        System.out.println("Enter the input scale (C for Celsius, F for Fahrenheit, K for Kelvin):");
        char fromScale = scanner.next().toUpperCase().charAt(0);

        System.out.println("Enter the target scale (C for Celsius, F for Fahrenheit, K for Kelvin):");
        char toScale = scanner.next().toUpperCase().charAt(0);

        double result = convertTemperature(temp, fromScale, toScale);

        System.out.printf("Converted Temperature: %.2f %s\n", result, toScale);
    }

    public static double convertTemperature(double temp, char from, char to) {
        if (from == to) return temp;

        double celsius;
        switch (from) {
            case 'F': celsius = (temp - 32) * 5 / 9; break;
            case 'K': celsius = temp - 273.15; break;
            case 'C': celsius = temp; break;
            default: throw new IllegalArgumentException("Invalid input scale");
        }

        switch (to) {
            case 'F': return (celsius * 9 / 5) + 32;
            case 'K': return celsius + 273.15;
            case 'C': return celsius;
            default: throw new IllegalArgumentException("Invalid target scale");
        }
    }
}
