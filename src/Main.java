/**
 * Created by kdf on 27.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Atm atm = new Atm();

        int pan = atm.requestPan();
        int amount = atm.requestAmount();
        atm.giveCash(amount);
    }
}
