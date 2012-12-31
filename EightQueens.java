/*
 * Author: Jordan Carney
 * Disclaimer: There is no error checking. Don't enter stupid input. 
 * This program determines a possible combination of eight queens on a chessboard based on an initial user input. 
 * filename: EightQueens.java
 */

import java.util.Scanner;

public class EightQueens {
	
	public static void printSolution(int[] rows) {
		System.out.println("A solution based on the initial queen position entered is:");
		System.out.print("[");
		for (int i = 0; i < rows.length; i++) {
			if (i < 0)
				System.out.println(",");
			for (int j = 0; j < rows.length; j++) {
				if (rows[i] == j) 
                	System.out.print("(" + i + "," + j + ")");
			}
		}
		System.out.println("]");
	}
	
	public static boolean isPlausiblePosition(int[] rows, int num) {
		for (int i = 0; i < num; i++) {
			if (rows[i] == rows[num] || rows[i] - rows[num] == num - i || rows[num] - rows[i] == num - i) {
				return false;
			}
		}
		return true;
	}
	
	public static void attempt(int[] rows, int num, int r, int c) {
		if (num == rows.length) {
			if (rows[r] == c) {
				printSolution(rows);
				System.exit(0);
			}
		} else {
			for (int i = 0; i < rows.length; i++) {
				rows[num] = i;
				if (isPlausiblePosition(rows, num))
					attempt(rows, num+1, r, c);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Starting queen row value (0-7): ");
		int necessaryRow = scan.nextInt();
		System.out.println("Starting queen column value (0-7): ");
		int necessaryCol = scan.nextInt();
		int[] rows = new int[8];
		attempt(rows, 0, necessaryRow, necessaryCol);
	}
}
