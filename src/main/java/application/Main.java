package main.java.application;

public class Main {

	public static void main(String[] args) {
		
		// Testes: criar conta
		BankDB dbBB = BankDB.getInstance();
		
		Bank bb = new Bank();
		bb.setAgencia("1234");
		bb.setNumero("12000");
		dbBB.addBank(bb);
		
		// Teste: deposita
		System.out.println("\nSaldo anterior de banco: R$ " + dbBB.saldo("1234", "12000"));
		dbBB.deposita("1234", "12000", 1500.00);
		System.out.println("Saldo atual de banco: R$ " + dbBB.saldo("1234", "12000"));

		//Teste: saca
		System.out.println("\nSaldo anterior de banco: R$ " + dbBB.saldo("1234", "12000"));
		dbBB.saca("1234", "12000", 1000.00);
		System.out.println("Saldo atual de banco: R$ " + dbBB.saldo("1234", "12000"));
		
		// Testes: criar outra conta
		dbBB = BankDB.getInstance();
		
		Bank bdn = new Bank();
		bdn.setAgencia("5678");
		bdn.setNumero("13000");
		dbBB.addBank(bdn);

		// Testes: transfere
		dbBB = BankDB.getInstance();
		System.out.println("\nSaldo anterior de banco: R$ " + dbBB.saldo("1234", "12000"));
		System.out.println("\nSaldo anterior de banco: R$ " + dbBB.saldo("5678", "13000"));
		dbBB.transfere("1234", "12000", "5678", "13000", 400.00);
		System.out.println("Saldo atual de banco: R$ " + dbBB.saldo("1234", "12000"));
		System.out.println("Saldo atual de banco: R$ " + dbBB.saldo("5678", "13000"));
		
		// Testes: listar bancos
		dbBB = BankDB.getInstance();
		System.out.println(dbBB.listarBancos());
		
		
		
		
		

		
/*
 * 			// instância da classe de negócio
			ContaCorrenteDB dbBanco = ContaCorrenteDB.getInstance();
			ContaCorrente conta = new ContaCorrente();

			ContaCorrente contaUm = new ContaCorrente();
			contaUm.setAgencia("1234");
			contaUm.setNumero("12000");
			dbBanco.addContaCorrente(contaUm);
 */
		
		

	}

}
