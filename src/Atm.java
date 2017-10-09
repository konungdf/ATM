import java.util.Scanner;

/**
 * Created by kdf on 27.03.2017.
 */
public class Atm {
    final String PAN_REQUEST = "Введите номер карты: ";
    final String AMOUNT_REQUEST = "Введите сумму: ";
    Scanner sc = new Scanner(System.in);

    public int requestPan() {
        System.out.print(PAN_REQUEST);
        return sc.nextInt();
    }

    public int requestAmount() {
        System.out.print(AMOUNT_REQUEST);
        return sc.nextInt();
    }

    public void giveCash(int amount) {
        System.out.println("Возьмите " + amount + " ₽");
    }

}

