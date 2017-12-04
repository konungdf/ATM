public class Cartridge {
    private int denomination, quantity, readyToTake = 0;

    Cartridge(int denomination, int quantity) {
        this.denomination = denomination;
        this.quantity = quantity;
    }

    public int getDenomination() {
        return denomination;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReadyToTake() {
        return readyToTake;
    }

    public void setReadyToTake(int readyToTake) {
        this.readyToTake = readyToTake;
    }

    public void takeBanknotes(int quantity) {
        this.quantity -= quantity;
        readyToTake = 0;
    }
}
