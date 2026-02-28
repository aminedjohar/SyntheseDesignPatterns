package net.youssfi.designpatterns.singleton;

public class BankConfiguration {
    // 1. Instance statique privée
    private static BankConfiguration instance;
    private String bankName;

    // 2. Constructeur privé
    private BankConfiguration() {
        this.bankName = "Ma Banque Centrale";
    }

    // 3. Méthode d'accès globale
    public static BankConfiguration getInstance() {
        if (instance == null) {
            instance = new BankConfiguration();
        }
        return instance;
    }

    public String getBankName() {
        return bankName;
    }
}
