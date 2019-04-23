/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Random;
public class Bank {
	private double probability = 0.98;
    private Random rand;
    public Bank(double p){
    	probability = p;
    	rand = new Random();
    }
    public Bank() {
    	rand = new Random();
    }
	public boolean verify(){
	    int prob = rand.nextInt(100);
	    if (prob <= (int)(probability*100))
	      return true;
	    return false;
	  }
}


