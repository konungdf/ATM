/**
 * Created by kdf on 27.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        int[][] banknotes = {{5000, 2,}, {1000, 5}, {500, 2}, {100, 2}};

        Atm atm = new Atm(banknotes);

        //int pan = atm.requestPan();
        int amount = atm.requestAmount();
        atm.withdraw(amount);
    }
}
