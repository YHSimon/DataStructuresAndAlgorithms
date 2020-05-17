package biweekly_contest_26;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Test2 t=new Test2();
        System.out.println(t.simplifiedFractions(6).toString());
    }

    /**
         * 29ms
         * 辗转相除法
         */
        public List<String> simplifiedFractions2(int n){
            List<String> list=new ArrayList<>();
            if(n==1){
                return list;
            }
            for(int i=2;i<=n;i++){
                for(int j=1;j<i;j++){
                    if(j==1||gcd(i,j )==1){
                        list.add(j+"/"+i);
                    }
                }
            }
        return list;
    }

    //辗转相除计算最大公约树
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    /**
     *40ms
     */
    public List<String> simplifiedFractions(int n) {
        List<String> list=new ArrayList<>();
        Map<Double,Integer> map=new HashMap<>();
        if(n==1) return list;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(j!=1&&map.containsKey((j/(i*1.0)))){
                    continue;
                }
                map.put(j/(i*1.0), 1);
                list.add(j+"/"+i);
            }
        }
        return list;
    }
}
