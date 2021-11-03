package study.piepie.algorithm.skill;

/**
 * @author Robin
 * @date 2021-10-29 09:53
 **/
public class BitMap {
    private int size;
    private static int[] bitArray;

    public BitMap(int size) {
        bitArray = new int[size >> 5 + 1];
    }

    public static boolean getBit(int offset) {
        int arrOffset = offset >> 5; // offset / 32
        int intOffset = offset & ((1 << 4) - 1);// offset % 32 === > %转为求与运算 X % 2^n = X & (2^n – 1)
        return (bitArray[arrOffset] & (1 << intOffset)) != 0;
    }

    public static void setBit(int offset) {
        int arrOffset = offset >> 5;
        int intOffset = offset & 5 + 1;// %转为求与运算
        bitArray[arrOffset] = bitArray[arrOffset] | (1 << intOffset);
    }
}