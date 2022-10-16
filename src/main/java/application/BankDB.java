package main.java.application;

import java.util.ArrayList;

import java.text.DecimalFormat;


public class BankDB {
	
	private ArrayList<Bank> banco;
	private static BankDB bdBanco;
	
	public BankDB() {
		banco = new ArrayList<Bank>(); 
	}
	
	public static BankDB getInstance() {
		if(bdBanco == null) {
			bdBanco = new BankDB();
		}
		return bdBanco;
	}

	public ArrayList<Bank> getBanco(){
		return banco;
	}
	
	public void addBank(Bank cc) {
		banco.add(cc);
		//Teste:
		System.out.println("\nBanco add com sucesso!" + " Agencia: " + cc.getAgencia() + ", Conta: " + cc.getNumero());		
	}
	
	public void deposita(String agencia, String numero, double valor) {
		Bank cc = new Bank();
		cc = buscaBank(agencia, numero);
		
		// Teste:
		//Boolean teste = getBanco().contains(numero);
		
		if(valor > 0 && cc.getNumero() != "0") {
			cc.setSaldo(cc.getSaldo() + valor);
			System.out.printf("Deposito de R$ %.2f em Ag.: [%s], Conta: [%s] efetuado com sucesso!\n", valor, cc.getAgencia(), cc.getNumero());
		} else if (cc.getNumero().equalsIgnoreCase("0")) {
			System.out.printf("\nConta Bancária Agência: [%s], Conta: [%s] não existe!\n\n", cc.getAgencia(), cc.getNumero());
		} else {
			System.out.println("Valor igual ou menor que zero!");
		}
	}

	
	public Double saldo(String agencia, String numero) {
		Bank cc = new Bank();
		cc = buscaBank(agencia, numero);
		return cc.getSaldo();
	}
	
	
	public boolean saca(String agencia, String numero, double valor) {
		Bank cc = new Bank();
		cc = buscaBank(agencia, numero);
		
		if(valor > 0 && cc.getSaldo() >= valor && cc.getNumero() != "0") {
			cc.setSaldo(cc.getSaldo() - valor);
			System.out.printf("Saque de R$ %.2f em Agência: [%s], Conta: [%s] efetuado com sucesso!\n", valor, cc.getAgencia(), cc.getNumero());
			return true;
		} else if (cc.getNumero().equalsIgnoreCase("0")) {
			System.out.printf("\nConta Bancária Agência: [%s], Conta: [%s] não existe!\n\n", cc.getAgencia(), cc.getNumero());
			return false;
		} else {
			System.out.println("Saldo insuficiente ou valor menor que zero!");
			return false;
		}
	}

	public boolean transfere(String agOrigem, String numOrigem, String agDestino, String numDestino, double valor) {
		
		Bank ccOrig = new Bank();
		ccOrig = buscaBank(agOrigem, numOrigem);
		Bank ccDest = new Bank();
		ccDest = buscaBank(agDestino, numDestino);		
		
		if(ccOrig.getNumero() != "0" && ccDest.getNumero() != "0") {
			if (ccOrig.getSaldo() >= valor) {
				System.out.printf("Transferindo R$ %.2f de Agência: [%s], Conta: [%s] para Agência: [%s], Conta: [%s]\n", valor, ccOrig.getAgencia(), ccOrig.getNumero(), ccDest.getAgencia(), ccDest.getNumero());
				saca(agOrigem, numOrigem, valor);
				deposita(agDestino, numDestino, valor);
				return true;
			} else if(valor < 0) {
				System.out.println("Valor menor que 0!");
				return false;
			} else {
				System.out.println("Conta Bancária sem saldo suficiente!");
				return false;
			}						
		} else {
			if(ccOrig.getNumero().equalsIgnoreCase("0"))
				System.out.println("Conta Bancária de origem não existe!");
			else if(ccDest.getNumero().equalsIgnoreCase("0"))
				System.out.println("Conta Bancária de destino não existe!");
			return false;
		}
	}
	
	public String listarBancos() {
		String str = "";
		for(Bank cc : banco) {
			String saldoFormat = new DecimalFormat("#,##0.00").format(cc.getSaldo());
			str += "Agência: " + cc.getAgencia() + "\n" +
				   "Conta corrente: " + cc.getNumero() + "\n" +
				   "Saldo: R$ " + saldoFormat + "\n\n";
		}
		return str;
	}
		
	public Bank buscaBank(String agencia, String numero){
		for(Bank cc : banco) {
			if(cc.getAgencia().equalsIgnoreCase(agencia) && cc.getNumero().equalsIgnoreCase(numero)) {
				return cc;
			}
		}
		Bank conta = new Bank();
		conta.setAgencia("0");
		conta.setNumero("0");
		return conta;
	}	
}

