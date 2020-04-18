package day08;

import java.util.*;

public class Test {
	
	
	/**
	 * 优化 
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray2(int[] array) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0,len=array.length;i<len;i++) {
			int sum=0;
			for(int j=i;j<len;j++) {
				sum+=array[j];
				list.add(sum);
			}
		}
		if(list.size()<=0) {
			return 0;
		}
		Collections.sort(list);
		return list.get(list.size()-1);	
	}
		
	
	
	/**
	 * 自己写的
	 * 
	 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
	 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
	 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0) return -1;
        int i=0,j=array.length-1,res=0;
        int max=getMax(array);
        if(max<0){
            return max;
        }
        while(i<=j){
            int temp=0;
            for(int u=i;u<=j;u++){
                temp+=array[u];
            }
            res=Math.max(res,temp);
            if(array[i]<array[j])  i++;
            else j--;
        }
        return res;
    }
    public int getMax(int[] a){
        int max=a[0];
        for(int i=0,len=a.length;i<len;i++){
            max=Math.max(max,a[i]);
        }
        return max;
    }
	
    
	/**
	 * 方法二  贪心算法
	 * O(n)
	 * @param height
	 * @return
	 */
	public int maxArea2(int[] height) {
		if(height==null||height.length==0)  return -1;
		int i=0 ,j=height.length-1,res=0;
		while(i<j) {
			int h=Math.min(height[i], height[j]);
			res=Math.max(res,h*(j-i)); 
			if(height[i]<height[j]) {
				i++;
			}else {
				j--;
			}
		}
		return res;
	}
	
	
	/**
	 * 方法一 暴力破解
	 * O(n^2)
	 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
	 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
        int max=0;
        int temp=0;
        int len=height.length;
        for(int i=0;i<len;i++) {
        	for(int j=i+1;j<len;j++) {
        		temp=(j-i)*Math.min(height[i], height[j]);
        		if(temp>max) {
        			max=temp;
        		}
        	}
        }
        return max;
    }
	

}
