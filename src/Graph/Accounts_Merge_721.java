package Graph;
import java.util.*;
import java.util.Collection;

public class Accounts_Merge_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, Integer> emailToId = new HashMap<>();
        int emailId = 0;
        UF ids = new UF(10001);

        // union email id.
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name.equals("")) {
                    name = email;
                    continue;
                }
                if (!emailToName.containsKey(email)) {
                    emailToName.put(email, name);
                    emailToId.put(email, emailId++);
                }
                ids.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }

        // get List<List<String>> ans from built UF class.
        HashMap<Integer, ArrayList<String>> rootID = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> newAccount;
        for (String email : emailToName.keySet()) {
            int root = ids.find(emailToId.get(email));
            if (!rootID.containsKey(root)) {
                newAccount = new ArrayList<>();
                newAccount.add(emailToName.get(email)); // add name to a new account
                newAccount.add(email);
                rootID.put(root, newAccount);
            } else {
                newAccount = rootID.get(root);
                newAccount.add(email);
                rootID.put(root, newAccount);
            }
        }
        for (ArrayList<String> account : rootID.values()) {
            Collections.sort(account);
            ans.add(account);
        }

        return ans;
    }

    class UF {
        int[] parent;
        UF(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) parent[i] = i;
        }
        void union(int i, int j) {
            parent[find(i)] = find(j);
        }
        int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }
        boolean isConnect(int i, int j) {
            return find(i) == find(j);
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>(), account2 = new ArrayList<>(), account3 = new ArrayList<>(), account4 = new ArrayList<>();
        account1.add("John"); account1.add("johnsmith@mail.com"); account1.add("john_newyork@mail.com");
        account2.add("John"); account2.add("johnsmith@mail.com"); account2.add("john00@mail.com");
        account3.add("Mary"); account3.add("mary@mail.com");
        account4.add("John"); account4.add("johnnybravo@mail.com");
        accounts.add(account1);accounts.add(account2);accounts.add(account3);accounts.add(account4);

        Accounts_Merge_721 s = new Accounts_Merge_721();
        List<List<String>> ans = s.accountsMerge(accounts);
    }
}
