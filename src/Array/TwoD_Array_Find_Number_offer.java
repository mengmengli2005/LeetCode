package Array;

public class TwoD_Array_Find_Number_offer {
    private static boolean Find(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) return false;
        int M = array.length;
        int N = array[0].length;

        int i = 0, j = N - 1;
        while (i < M && j >= 0) {
            if (target == array[i][j]) return true;
            if (target < array[i][j]) j--;
            else if (target > array[i][j]) i++;
        }
        return false;
    }

    public static void main(String[] args) {
        // [[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int[][] in = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        boolean ans = Find(5, in);
        System.out.println(ans);
    }
}
