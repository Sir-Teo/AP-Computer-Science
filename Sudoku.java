import java.util.Stack;  
  
public class main {  
      
    public static void main(String[] args) {  
        Scanner sc=new Scanner(System.in);  
        while(sc.hasNextInt()){  
            int[][]a=new int[9][9];  
            boolean[][] cols = new boolean[9][9];  
            boolean[][] rows = new boolean[9][9];  
            boolean[][] blocks = new boolean[9][9];//九大宫的九个数字  
  
            for (int i = 0; i < a.length; i++) {  
                for (int j = 0; j < a.length; j++) {  
                    a[i][j]=sc.nextInt();  
                    if(a[i][j]!=0){  
                        int k = i/3*3+ j/3;//划分九宫格,这里以行优先，自己也可以列优先  
                        int val=a[i][j]-1;  
                          rows[i][val] = true;  
                            cols[j][val] = true;  
                            blocks[k][val] = true;  
                    }  
                }  
            }//数据装载完毕     
            DFS(a, cols, rows, blocks);  
            for (int i = 0; i < 9; i++) {  
                for (int j = 0; j < 8; j++) {  
                    System.out.print(a[i][j]+" ");  
                }  
                System.out.println(a[i][8]);  
            }  
        }  
    }  
      
      
      
      
   public static boolean DFS(int[][] a,boolean[][] cols,boolean[][] rows,boolean[][] blocks) {  
        for (int i = 0; i < 9; i++) {  
            for (int j = 0; j < 9; j++) {  
                if(a[i][j]==0){  
                    int k=i/3*3+j/3;  
                    for (int l = 0; l < 9; l++) {  
                        if(!cols[j][l]&&!rows[i][l]&&!blocks[k][l]){//l对于的数字l+1没有在行列块中出现  
                               rows[i][l] = cols[j][l] = blocks[k][l] = true;  
                                a[i][j] = 1 + l;//下标加1  
                                if(DFS(a, cols, rows, blocks)) return true;//递进则返回true  
                                rows[i][l] = cols[j][l] = blocks[k][l] = false;//递进失败则回溯  
                                a[i][j] = 0;    
                        }  
                    }  
                    return false;//a[i][j]==0时，l发现都不能填进去  
                }//the end of a[i][j]==0  
            }  
        }  
        return true;//没有a[i][j]==0,则返回true  
    }  
} 