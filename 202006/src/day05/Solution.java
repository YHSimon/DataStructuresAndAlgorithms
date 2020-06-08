package day05;

/**  990.等式方程的可满足性
 *
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(equationsPossible2(new String[]{"a==b","e==c","b==c","a!=e"}));
    }
    //直观方法  1ms
    public static boolean equationsPossible2(String[] equations) {
        int[] arr = new int[26];
        int count = 1;
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int start = str.charAt(0) - 'a';
                int end = str.charAt(3) - 'a';
                if (arr[start] == 0 && arr[end] == 0) {
                    //都没出现过
                    arr[start] = arr[end] = count++;
                } else if (arr[start] == 0 || arr[end] == 0) {
                    //只有一个出现个，则把权值设置一样
                    int max = Math.max(arr[start], arr[end]);
                    arr[start] = arr[end] = max;
                } else {
                    //都出现过，两个集合相交， 把所有等于他俩值的权值设置同一个值。
                    int v1 = arr[start];
                    int v2 = arr[end];
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == v1 || arr[i] == v2) {
                            arr[i] = v1;
                        }
                    }
                }
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int start = s.charAt(0) - 'a';
                int end = s.charAt(3) - 'a';
                if (start == end) {//同一个字母
                    return false;
                }
                if (arr[start] != 0 && arr[end] != 0) {
                    if (arr[start] == arr[end]) {
                        return false;//矛盾
                    }
                }
            }
        }
        return true;
    }


    //并查集 1ms
    public boolean equationsPossible(String[] equations) {
        int len = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }

        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }


}
