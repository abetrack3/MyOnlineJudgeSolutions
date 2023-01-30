import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Solution {

    public static void main(String[] args) {
        
        // case variables
        int[] cells;
        
        
        // case 1
        cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println(Arrays.toString(new Solution().prisonAfterNDays(cells, 7)));

        // case 2
        cells = new int[]{1, 0, 0, 1, 0, 0, 1, 0};
        System.out.println(Arrays.toString(new Solution().prisonAfterNDays(cells, 1000000000)));

    }

    public static int toNum(int[] cells) {
        int num = 0;
        for(int index = 0; index < cells.length; index++) {
            num |= (1 & cells[index]) << index;
        }
        return num;
    }

    public static int[] toCellArray(int num) {
        int[] cells = new int[8];

        for (int index = 0; index < cells.length; index++) {
            cells[index] = (num & (1 << index)) != 0 ? 1 : 0;
        }

        return cells;
    }

    public static int nextPrisonState(int num) {

        int nextNum = 0;
        
        for (int index = 1; index < 7; index++) {

            int leftCell = (1 << (index + 1)) & num;
            int rightCell = (1 << (index - 1)) & num;

            if (leftCell == 0 && rightCell == 0) { // both adjacent bits are zero
                nextNum = setBit(nextNum, index);
            } else if (leftCell != 0 && rightCell != 0) { // both adjacent bits are 1
                nextNum = setBit(nextNum, index);
            }
        }

        return nextNum;
    }

    public static int setBit(int num, int index) {
        return num | (1 << index);
    }

    public int[] prisonAfterNDays(int[] cells, int n) {

        return optimizedSolution(cells, n);

    }

    public int[] bruteForceSolution(int[] cells, int numberOfDays) {

        int prisonState = toNum(cells);

        for (int index = 0; index < numberOfDays; index++) {
            prisonState = nextPrisonState(prisonState);
        }

        return toCellArray(prisonState);

    }


    public int[] optimizedSolution(int[] cells, int numberOfDays) {

        ArrayList<Integer> prisonStateList = new ArrayList<>();
        BitSet prisonStateSet = new BitSet();
        int prisonState = toNum(cells);
        prisonStateList.add(prisonState);
        prisonStateSet.set(prisonState);

        prisonState = nextPrisonState(prisonState);
        while (!prisonStateSet.get(prisonState)) {
            prisonStateList.add(prisonState);
            prisonStateSet.set(prisonState);
            prisonState = nextPrisonState(prisonState);
        }
        
        int stateLoopStartIndex = prisonStateList.indexOf(prisonState);
        int stateLoopSize = prisonStateList.size() - stateLoopStartIndex;

        int finalPrisonStateIndex = stateLoopStartIndex + (numberOfDays - stateLoopStartIndex) % stateLoopSize;

        return toCellArray(prisonStateList.get(finalPrisonStateIndex));
    }

}