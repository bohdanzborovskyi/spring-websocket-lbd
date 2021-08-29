package com.zbodya.Service;

import java.math.BigDecimal;


public class MessageDTO 
{
	private BigDecimal valueOne;
	private BigDecimal valueTwo;
	private String color;
	private int decimalPlaces;
	private int multiplier;
	
	
	public  MessageDTO (MessageService service) 
	{
		this.valueOne = service.getValueOne();
		this.valueTwo = service.getValueTwo();
		this.color = service.getColor();
		this.decimalPlaces = service.getDecimalPlaces();
		this.multiplier = service.getMultiplier();		
	}


	public BigDecimal getValueOne() {
		return valueOne;
	}


	public void setValueOne(BigDecimal valueOne) {
		this.valueOne = valueOne;
	}


	public BigDecimal getValueTwo() {
		return valueTwo;
	}


	public void setValueTwo(BigDecimal valueTwo) {
		this.valueTwo = valueTwo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getDecimalPlaces() {
		return decimalPlaces;
	}


	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}


	public int getMultiplier() {
		return multiplier;
	}


	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
	
	
}

