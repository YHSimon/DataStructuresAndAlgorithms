package competiton11.test02;

/**
 * 【问题描述】
 *
 * 小明要做一个跑步训练。
 *
 * 初始时，小明充满体力，体力值计为 10000。如果小明跑步，每分钟损耗
 *
 * 600 的体力。如果小明休息，每分钟增加 300 的体力。体力的损耗和增加都是
 *
 * 均匀变化的。
 *
 * 小明打算跑一分钟、休息一分钟、再跑一分钟、再休息一分钟……如此循
 *
 * 环。如果某个时刻小明的体力到达 0，他就停止锻炼。
 *
 * 请问小明在多久后停止锻炼。为了使答案为整数，请以秒为单位输出答案。
 *
 * 答案中只填写数，不填写单位。
 */
public class Main {
    public static void main(String[] args) {
        int n=10000;
        int count=0;
        int j=0,sum;
        while(true){
            if(n<600&&j%2==0){ //若最后是在跑步 且体力小于600 分开计算
                sum=n/10;
                break;
            }
            if(j%2==0){
                n-=600;
            }else{
                n+=300;
            }
            count++;
            j++;
        }
        System.out.println(count*60+sum);
    }
}
