package com.app.test;

import com.app.model.Wallet;
import com.app.service.WalletService;

public class TestApp {

	public static void main(String[] args) {
		WalletService ws  = new WalletService();
		
		ws.createWallet(new Wallet("Harry", 100.0));
		ws.createWallet(new Wallet("Ron", 95.7));
		ws.createWallet(new Wallet("Albus", 200.0));
		ws.createWallet(new Wallet("Sam", 30.0));
		
		ws.printOverview();
		System.out.println("-----------------");
		ws.trasnferMoney("Harry", "Ron", 10.0);
		ws.trasnferMoney("Harry", "Albus", 20.0);
		ws.trasnferMoney("Harry", "Sam", 20.0);

		ws.printOverview();
		System.out.println("-----------------");
		
		ws.printStatement("Harry");
		ws.printStatement("Sam");
	}
}
