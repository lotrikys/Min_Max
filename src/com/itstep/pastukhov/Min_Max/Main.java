package com.itstep.pastukhov.Min_Max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[] mas;
	static int max;
	static int min;
	static int maxindex;
	static int minindex;
	static int mindyblirovanie;
	static int maxdyblirovanie;
	static int result;
	public static void main(String[] args) throws Exception{
		for (;;) {
			System.out.println("Vvedite 1 dly osnovnoy programmy ili 2 dlya dopolnitelnoy:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int input=Integer.parseInt(reader.readLine());
			if (input==1) {
				create_mas();
				calculate();
				if (maxdyblirovanie > 0) {
					System.out.println("Max vstrechayutsa 2 raza");
					continue;
				}
				if (mindyblirovanie > 0) {
					System.out.println("Min vstrechayutsa 2 raza");
					continue;
				}
				result();
			} if (input==2) {
				random_mas();
			}
		}
	}
	public static void create_mas() throws Exception{
		mas=new int[5];
		System.out.println("Vvedite chisla");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0;i<mas.length;i++){
			mas[i] = Integer.parseInt(reader.readLine());
		}
	}
	public static void calculate (){
		min = mas[0];
		max = mas[0];
		mindyblirovanie=0;
		maxdyblirovanie=0;
		minindex=0;
		maxindex=0;
		for (int i=1;i<mas.length;i++){
			if (min > mas[i]){
				min = mas[i];
				mindyblirovanie=0;
				minindex=i;
				continue;
			} if (max < mas[i]){
				max = mas[i];
				maxdyblirovanie=0;
				maxindex=i;
				continue;
			} if (min == mas[i]){
				mindyblirovanie++;
			} if (max == mas[i]){
				maxdyblirovanie++;
			}
		}
	}
	public static void result (){
		result=1;
		if (minindex>maxindex){
			for (;maxindex<=minindex;maxindex++){
				result*=mas[maxindex];
			}
		} else {
			for (;minindex<=maxindex;minindex++){
				result*=mas[minindex];
			}
		}
		System.out.println("Result " + result);
		System.exit(0);
	}
	public static void random_mas() throws Exception{
		ArrayList<Integer> arrayList = new ArrayList<>();
		System.out.println("Vvedite chislo");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int maxnumberinmas = Integer.parseInt(reader.readLine());
		int massize = maxnumberinmas*2+1;
		for (int i=0;i<massize;i++){
			arrayList.add(i,Math.abs(maxnumberinmas));
			maxnumberinmas--;
		}
		for (int i=0;i<arrayList.size();i++){
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println();
	}
}
