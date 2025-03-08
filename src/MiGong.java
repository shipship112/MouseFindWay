public class MiGong {
    public static void main(String[] args) {
        //0：可以走。1：障碍物。
        int[][]map=new int[8][7];
        //将最上面和最下面设置为1
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //将最右边和最左边设置为1
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        //单独设置的障碍物
        map[3][1]=1;
        map[3][2]=1;
        //输出地图
        System.out.println("---当前地图---");
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
       //使用findWay
        T t1=new T();
        t1.findWay(map,1,1);

        System.out.println("===情况如下===");
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

}

class T{
    //寻找出迷宫的路径
    //0：可以走。1：障碍物。2：确定可以走 3：确定是死路
    //当map[6][5]==2，说明找到
    //策略：下->右->上->左
    public boolean findWay(int[][]map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else{
            if(map[i][j]==0){//可以走
                map[i][j]=2;
                //使用策略，来确定是否真的可以走通
                if(findWay(map,i+1,j)){
                    return true;
                }else if(findWay(map,i,j+1)){
                    return true;
                }else if(findWay(map,i-1,j)){
                    return true;
                }else  if(findWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }

            }else{//1,2,3
                return false;
            }
        }
    }
}

