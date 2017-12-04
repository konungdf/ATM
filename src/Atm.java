import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Atm {
    final String PAN_REQUEST = "Введите номер карты: ";
    final String AMOUNT_REQUEST = "Введите сумму: ";
    final String TAKE = "Возьмите %d * %d %c%n";
    final String TOTAL = "Итого:       %d %c%n";
    final char CURRENCY = '\u20BD';
    final String NOT_ENOUGH_BANKNOTES = "В банкомате недостаточно купюр";

    Scanner sc = new Scanner(System.in);

    ArrayList<Cartridge> cartridges = new ArrayList<>();

    Atm(int[][] banknotes) {
        for (int[] cartridge : banknotes) {
            cartridges.add(new Cartridge(cartridge[0], cartridge[1]));
        }
        cartridges.trimToSize();
        cartridges.sort(Comparator.comparing(Cartridge::getDenomination).reversed());
    }

    public int requestPan() {
        System.out.print(PAN_REQUEST);
        return sc.nextInt();
    }

    public int requestAmount() {
        System.out.print(AMOUNT_REQUEST);
        return sc.nextInt();
    }

    public void withdraw(int amount) {

        int sum = amount;

        for (Cartridge cartridge : cartridges) {
            int give = sum / cartridge.getDenomination();
            if (give > cartridge.getQuantity()) {
                give = cartridge.getQuantity();
            }
            sum -= cartridge.getDenomination() * give;
            cartridge.setReadyToTake(give);
        }

        if (sum == 0) {
            for (Cartridge cartridge : cartridges) {
                int ready = cartridge.getReadyToTake();
                if (ready != 0) {
                    System.out.printf(TAKE, ready, cartridge.getDenomination(), CURRENCY);
                }
                cartridge.takeBanknotes(ready);
            }
            System.out.printf(TOTAL, amount, CURRENCY);
        } else {
            System.out.println(NOT_ENOUGH_BANKNOTES);
        }
    }
}
