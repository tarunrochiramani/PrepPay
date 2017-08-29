package com.tr.ctci.bitManipulation;

public class BitManipulation {

    public int getBit(int num, int pos) {
        int mask = 1 << pos;
        int retVal = (num & mask) == 0 ? 0 : 1;

        return retVal;
    }

    public int setBit(int num, int pos) {
        int mask = 1 << pos;
        return (num|mask);
    }

    public int clearBit(int num, int pos) {
        int mask = ~(1 << pos);
        return num & mask;
    }

    public int updateBit(int num, int pos, boolean set1) {
        int clearedBitNum = clearBit(num, pos);
        if (set1) {
            return (clearedBitNum | (1 << pos));
        }

        return clearedBitNum;
    }
}
