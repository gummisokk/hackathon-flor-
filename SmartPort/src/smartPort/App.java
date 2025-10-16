package smartPort;

import java.util.Scanner;

import javax.sound.sampled.Port;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);

        int P = scanner.nextInt();

        Port[] ports = new Port[P];

        for (int i = 0; i < P; i++) {
            //les inn info om portane
            String[] line = scanner.nextLine().split(",");
            ports[i] = new Port(line[0]);
            for (int j = 0; j < Integer.parseInt(line[1]); j++) {
                ports[i].addItem(line[2 + j]);
            }
        }
    }
}
