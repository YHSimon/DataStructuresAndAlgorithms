##笔记  
1. 用list集合保存各种情况的结果，再进行排序，取出最值  伪代码： 
```java
   /*
     if(list.size()<=0) return 0;
     Collections.sort(list);
     return list.get(list.size()-1);
    */
   
```  
2. 采用阵地攻守的思想：
   第一个数字作为第一个士兵，守阵地；count = 1；
   遇到相同元素，count++;
   遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
   再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
  
3. 排序
集合： 
降序  
Collections.sort(list，Collections.reverseOrder())//list:8 7 6 5 4 2 1  
逆序  
Collections.reverse(list)//list：4 1 8 6 2 7 5  

数组：  
降序(一定要注意调用Collections.reverseOrder()需要是Integer[],而不是int[])  
Integer[] a={5 7 2 6 8 1 4}   
Arrays.sort(a，Collections.reverseOrder())//a： 8 7 6 5 4 2 1  

将数组转成list  
Arrays.asList(数组);  
List<Integer>list =new ArrayList<Integer>(Arrays.asList(a));   