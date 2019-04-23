/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class bookCart{
	Map <Integer, Integer> cart;
    bookCart(){
        this.cart = new HashMap<Integer, Integer>(); 
    }
    
    public void pushToCart(int index, int quantity) {
    	this.cart.put(index, quantity);
    }
    
    public Set<Integer> getCartItems() {
    	return this.cart.keySet();
    }
    public void clearCart() {
    	this.cart = new HashMap<Integer, Integer>();
    }
    public void removeFromCart(int index) {
    	this.cart.remove(index);
    }
    public void subAmountCart(int index, int quantity) {
    	int op1 = this.cart.get(index) - quantity;
    	this.cart.remove(index);
    	this.cart.put(index, op1);
    }
}