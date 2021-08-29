package com.zbodya.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;


@Service
public class MessageService 
{
	
	private BigDecimal valueOne;
	private BigDecimal valueTwo;
	private static String color = "grey";
	private static int decimalPlaces  = 2;
	private static int multiplier = 1;
	
	
	
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

	public static String getColor() {
		return color;
	}

	public static void setColor(String newColor) {
		color = newColor;
	}

	public static int getDecimalPlaces() {
		return decimalPlaces;
	}

	public static void setDecimalPlaces(int newDecimalPlaces) {
		decimalPlaces = newDecimalPlaces;
	}

	public static int getMultiplier() {
		return multiplier;
	}

	public static void setMultiplier(int newMultiplier) {
		multiplier = newMultiplier;
	}

	public MessageService()
	{
		super();		
	}
	
	private void calculateValues() 
	{
		this.valueOne = new BigDecimal(Math.random()*this.multiplier).setScale(this.decimalPlaces, RoundingMode.HALF_UP);
		this.valueTwo =	new BigDecimal(Math.random()*this.multiplier).setScale(this.decimalPlaces, RoundingMode.HALF_UP);
	}
	
	public static MessageService generateMessage() 
	{
		MessageService message = new MessageService();
		message.setMultiplier(getMultiplier());
		message.setDecimalPlaces(getDecimalPlaces());
		message.calculateValues();
		return message;
	}
	

}
