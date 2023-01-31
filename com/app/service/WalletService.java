package com.app.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.app.model.Transaction;
import com.app.model.Wallet;

public class WalletService {

	private Map<String,Wallet> db = new LinkedHashMap<>();

	public void createWallet(Wallet wallet) {
		boolean exist = db.containsKey(wallet.getUsername());
		if (!exist)
			db.put(wallet.getUsername(),wallet);
		else
			throw new IllegalArgumentException("User exist");
	}
	
	public void trasnferMoney(String acc1, String acc2, Double amt) {
		if(!db.containsKey(acc1)) {
			throw new IllegalArgumentException("USER NOT EXIST "+acc1);
		} if(!db.containsKey(acc2) ) {
			throw new IllegalArgumentException("USER NOT EXIST "+acc2);
		}
		Wallet w1 = db.get(acc1);
		Wallet w2 = db.get(acc2);
		if(w1.getBalance() < amt)
			throw new IllegalArgumentException("INSUFFICIENT BALANCE");
		else {
			w1.setBalance(w1.getBalance()-amt);
			w2.setBalance(w2.getBalance()+amt);
			
			w1.getTransaction().add(new Transaction("Dr", w2.getUsername() ,amt));
			w2.getTransaction().add(new Transaction("Cr", w1.getUsername() ,amt));
			//if both are having same balance
			if(w1.getBalance().compareTo(w2.getBalance())==0) {
				double offerAmt = 10.0;
				w1.setBalance(w1.getBalance()+offerAmt);
				w2.setBalance(w2.getBalance()+offerAmt);
				
				
				w1.getTransaction().add(new Transaction("Cr", "OFFER AMOUNT" ,offerAmt));
				w2.getTransaction().add(new Transaction("Cr", "OFFER AMOUNT" ,offerAmt));
			}
		}
	}

	public void printStatement(String username) {
		if(!db.containsKey(username)) {
			throw new IllegalArgumentException("USER NOT EXIST "+username);
		}
		Wallet wallet = db.get(username);
		System.out.println("Name:" + wallet.getUsername() +", Balance " + wallet.getBalance());
		wallet.getTransaction().stream().map(tx-> tx.getFromUser()+" - "+tx.getType() +" : FR "+tx.getAmount())
		.forEach(System.out::println);
	}
	
	public void printOverview() {
		db.values().stream().map(ov -> ov.getUsername()+" "+ov.getBalance())
		.forEach(System.out::println);
	}
	
}
