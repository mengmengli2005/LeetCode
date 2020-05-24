package Array;

public class First_Bad_Version_278 {
    public int firstBadVersion(int n) {
        if (n <= 1) {
            if (isBadVersion(n)) return n;
            return -1;
        }
        int min = 1, max = n;
        while (max >= min) {
            int mid = min + (max - min) / 2;
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) return mid;
            if (!isBadVersion(mid)) min = mid + 1;
            else max = mid - 1;
        }
        return min;
    }

    private boolean isBadVersion(int n) {
        int firstBadVersion = 1702766719;
        if (n >= firstBadVersion) return true;
        return false;
    }

    public static void main(String[] args) {
        First_Bad_Version_278 s = new First_Bad_Version_278();
        int Excepted = 1702766719;
        int Actual = s.firstBadVersion(2126753390);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
