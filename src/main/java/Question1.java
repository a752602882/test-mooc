
public class Question1
{
    //编写一个Java程序在屏幕上输出1！+2！+3！+„„+10！的和。（p64,例2-2）
    public  void  test1(){

        int sum=0;
        for(int i = 1;i<10;i++){
            for(int j = 1;i<j;i++){
              sum=sum+i*j;
            }
        }
    }
}
