package com.prady.algorithms.bit;

public class BitManipulation {
	
	public static void main(String[] args){
		int aBinary 	= 0b10;
		int aDecimal 	= 010;
		int aHexadecimal= 0x000110F;
		int two 	= 2;
		int four 	= 4;
		int six		= 6;
		System.out.println("Binary: " + aBinary);
		System.out.println("Octal: " + aDecimal);
		System.out.println("HexaDecimal: " + aHexadecimal);
		
		System.out.println("Right Bit shift for number 0100: " + (four >> 1));
		System.out.println("Left Bit shift for number 0100: " + (four << 1));
		System.out.println("OR Bit shift for number 0100 and 0010: " + (four | two));
		System.out.println("XOR Bit shift for number 0100 and 0110: " + (six ^ four));
		System.out.println("AND Bit shift for number 0100 and 0110: " + (six & four));
		System.out.println("Logical right shift by 4 bits i.e. 1111 1111 becomes 0000 1111: Decimal= " + (0b11111111>>>four));
	}
}
