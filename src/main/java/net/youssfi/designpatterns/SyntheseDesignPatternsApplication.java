package net.youssfi.designpatterns;

import net.youssfi.designpatterns.model.BankAccount;
import net.youssfi.designpatterns.model.AccountStatus;
import net.youssfi.designpatterns.model.AccountType;
import net.youssfi.designpatterns.singleton.BankConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SyntheseDesignPatternsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SyntheseDesignPatternsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== TEST DU SINGLETON ===");
		BankConfiguration config1 = BankConfiguration.getInstance();
		BankConfiguration config2 = BankConfiguration.getInstance();
		System.out.println("Même instance ? " + (config1 == config2));

		System.out.println("\n=== TEST DU BUILDER ===");
		BankAccount account1 = BankAccount.builder()
				.accountId("ACC-1234")
				.balance(5000)
				.currency("MAD")
				.type(AccountType.CURRENT_ACCOUNT)
				.status(AccountStatus.ACTIVATED)
				.build();
		System.out.println(account1);

		System.out.println("\n=== TEST DU PROTOTYPE ===");
		BankAccount account2 = account1.clone();
		account2.setAccountId("ACC-9999");
		System.out.println("Compte original : " + account1);
		System.out.println("Compte cloné    : " + account2);
	}
}