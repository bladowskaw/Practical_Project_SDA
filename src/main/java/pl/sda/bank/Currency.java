package pl.sda.bank;

public enum Currency {


    PLN("Polish Zloty"), USD("American Dollar"), EUR("Euro");

    private final String currencyName;

    Currency(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyName () {
        return currencyName;
    }
}
