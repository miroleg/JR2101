package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] net1 = new byte[4];
         for ( int i=0; i<4; i++) {
            net1[i] = (byte) (ip[i] & mask[i]);
        }

        return net1;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++){
            System.out.print(toBits(bytes[i]));
            System.out.print(" ");
        }
        System.out.println();
    }
    public static String toBits(final byte val) {
        final StringBuilder result = new StringBuilder();
        for (int i=0; i<8; i++) {
            result.append((int)(val >> (8-(i+1)) & 0x0001));
        }
        return result.toString();
    }
}
