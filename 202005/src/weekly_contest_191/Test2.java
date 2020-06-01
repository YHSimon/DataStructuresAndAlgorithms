package weekly_contest_191;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        Test2 t=new Test2();
        int[] horizontalCuts=new int[]{3};
        int[] verticalCuts=new int[]{3};
        System.out.println(t.maxArea(5,4,horizontalCuts,verticalCuts));
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hLen = horizontalCuts.length, vLen = verticalCuts.length;
        long hMax = horizontalCuts[0];
        long vMax = verticalCuts[0];
        for (int i = 1; i < hLen; i++) {
            hMax = Math.max(hMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < vLen; i++) {
            vMax = Math.max(vMax, verticalCuts[i] - verticalCuts[i - 1]);
        }

        hMax = Math.max(hMax, h - horizontalCuts[hLen - 1]);
        vMax = Math.max(vMax, w - verticalCuts[vLen - 1]);
       return (int)((hMax*vMax)%(1000000007));
    }
}
