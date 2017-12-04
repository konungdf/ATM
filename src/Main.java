public class Main {
    public static void main(String[] args) {
        int[][] banknotes = {{500, 2,}, {1000, 5}, {5000, 2}, {100, 2}};

        Atm atm = new Atm(banknotes);

        //int pan = atm.requestPan();
        int amount = atm.requestAmount();
        atm.withdraw(amount);
    }
}
