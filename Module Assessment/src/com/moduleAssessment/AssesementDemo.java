package com.moduleAssessment;

import java.util.Scanner;
import java.io.IOException;

public class AssesementDemo {
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	static void openingMenu(Assessment newAccount) {
		System.out.println(
				"\t\tWelcome to our Bank \n\t\tPlease avail following options to create and manage your account\n");
		System.out.println("1. Create account");
		System.out.println("0. Exit");
		Scanner sc = new Scanner(System.in);
		int switchChoice = sc.nextInt();
		switch (switchChoice) {
		case 1:
			clearScreen();
			newAccount.createNewAccount();
			promptEnterKey();
			clearScreen();
			ManageAccMenu(newAccount);
			break;

		case 0:
			break;
		}
	}

	static void ManageAccMenu(Assessment newAccount) {
		clearScreen();
		System.out.println("Manage your account\n");
		System.out.println("1. Deposit money");
		System.out.println("2. Withdraw money");
		System.out.println("3. Display account details");
		System.out.println("4. Close account");
		System.out.println("0. Exit from account");
		Scanner sc = new Scanner(System.in);
		int switchChoice = sc.nextInt();
		switch (switchChoice) {
		case 1:
			clearScreen();
			newAccount.depositeAmount();
			promptEnterKey();
			ManageAccMenu(newAccount);

		case 2:
			clearScreen();
			newAccount.withDrawAmount();
			promptEnterKey();
			ManageAccMenu(newAccount);

		case 3:
			clearScreen();
			newAccount.displayAccountDetails();
			promptEnterKey();
			ManageAccMenu(newAccount);

		case 4:
			clearScreen();
			newAccount.closeAccount();
			promptEnterKey();
			break;

		case 0:
			break;
		}
	}

	static void promptEnterKey() {
		System.out.println("Press \"ENTER\" to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

	}

	public static void main(String[] args) {
		Assessment newAccount = new Assessment();

		openingMenu(newAccount);
		// ManageAccMenu(newAccount);

	}

}
