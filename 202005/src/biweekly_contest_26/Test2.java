package biweekly_contest_26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Test2 t=new Test2();
        System.out.println(t.simplifiedFractions(6).toString());
    }
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
