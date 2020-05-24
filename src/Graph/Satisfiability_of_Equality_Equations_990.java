package Graph;

public class Satisfiability_of_Equality_Equations_990 {
    static final int N = 26;
    int[] ids = new int[N];
    int newID = 1;

    public boolean equationsPossible(String[] equations) {
        for (String s : equations) {
            if (s.charAt(1) == '=') union(s.charAt(0), s.charAt(3));
        }
        for (String s : equations) {
            if (s.charAt(1) == '!' && isConnect(s.charAt(0), s.charAt(3))) return false;
        }
        return true;
    }

    private void union(Character chr1, Character chr2) {
        if (ids[chr1 - 'a'] == 0 && ids[chr2 - 'a'] == 0) {
            ids[chr1 - 'a'] = newID;
            ids[chr2 - 'a'] = newID;
            newID++;
        } else if (ids[chr1 - 'a'] == 0) ids[chr1 - 'a'] = ids[chr2 - 'a'];
        else if (ids[chr2 - 'a'] == 0) ids[chr2 - 'a'] = ids[chr1 - 'a'];
        else {
            int target = ids[chr2 - 'a'];
            for (int i = 0; i < N; i++) {
                if (ids[i] == ids[target - 'a'])
                    ids[i] = ids[chr1 - 'a'];
            }
        }
    }

    private boolean isConnect(Character chr1, Character chr2) {
        if (chr1 == chr2) return true;
        if (ids[chr1 - 'a'] == 0 || ids[chr2 - 'a'] == 0) return false;
        if (ids[chr1 - 'a'] != ids[chr2 - 'a']) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"a==b","e==c","b==c","a!=e"};
        Satisfiability_of_Equality_Equations_990 s = new Satisfiability_of_Equality_Equations_990();
        boolean ans = s.equationsPossible(equations);
    }
}
