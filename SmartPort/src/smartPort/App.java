package smartPort;

import java.io.File;
import static java.lang.Float.parseFloat;
import java.util.Scanner;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws Exception {

        File file = new File("innDataSet/altiein.txt");

        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(file);

        int P = scanner.nextInt();
        System.out.println(P);

        Port[] ports = new Port[P];
        for (int i = 0; i < P; i++) {
            //les inn info om portane
            String[] line = scanner.nextLine().split(",");
            ports[i] = new Port(line[0]);
            for (int j = 0; j < Integer.parseInt(line[1]); j++) {
                ports[i].addItem(line[2 + j]);
            }
        }

        int S = scanner.nextInt();
        Ship[] ships = new Ship[S];
        for (int i = 0; i < S; i++) {
            //les inn info om skipa
            String[] line = scanner.nextLine().split(",");
            ships[i] = new Ship(line[0], line[1], line[2]);
            for (int j = 0; j < Integer.parseInt(line[3]); j++) {
                ports[i].addRequest(line[4 + j]);
            }
        }

        int[][] travelTime = new int[P][P];
        for (int i = 0; i < P; i++) {
            travelTime[i] = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        //handlingTimes
        for (int i = 0; i < 5; i++) {
            String[] line = scanner.nextLine().split(",");
            Items.items.put(line[0], parseFloat(line[1]));

        }
    }
}
