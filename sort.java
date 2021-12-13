import java.util.Arrays;
public class sort {
    public static void main(String[] args){
        System.out.println("冒泡排序");
        int[] a1=new int[10];
        for(int i=1;i<a1.length;i++){
            a1[i]=(int)(Math.random()*100);
        }
        System.out.println("排序前的数组为："+Arrays.toString(a1));
        Bubble_sort(a1);
        System.out.println("排序后的数组为："+Arrays.toString(a1));
        System.out.println("-----------------------");
        System.out.println("插入排序");
        int []a2=new int[10];
        for(int i=1;i<a2.length;i++){
            a2[i]=(int)(Math.random()*100);
        }
        System.out.println("排序前的数组为："+Arrays.toString(a2));
        Insert_sort(a2);
        System.out.println("排序后的数组为："+Arrays.toString(a2));
        System.out.println("-----------------------");
        System.out.println("快速排序");
        int []a3=new int[10];
        for(int i=1;i<a3.length;i++){
            a3[i]=(int)(Math.random()*100);
        }
        System.out.println("排序前的数组为："+Arrays.toString(a3));
        Quick_sort(a3,1,9);
        System.out.println("排序后的数组为："+Arrays.toString(a3));
        System.out.println("-----------------------");
        System.out.println("合并排序");
        int []a4=new int[10];
        for(int i=1;i<a4.length;i++){
            a4[i]=(int)(Math.random()*100);
        }
        System.out.println("排序前的数组为："+Arrays.toString(a4));
        Merge_sort(a4,3,7);
        System.out.println("排序后的数组为："+Arrays.toString(a4));
        System.out.println("-----------------------");
        System.out.println("堆排序");
        int []a5=new int[10];
        for(int i=1;i<a5.length;i++){
            a5[i]=(int)(Math.random()*100);
        }
        System.out.println("排序前的数组为："+Arrays.toString(a5));
        Heap_sort(a5);
        System.out.println("排序后的数组为："+Arrays.toString(a5));
        System.out.println("-----------------------");
    }
    public static void Bubble_sort(int[] a){
        int len = a.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){//注意第二重循环的条件
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }

    }
    public static void Insert_sort(int[] a){
        int temp;
        for(int i=1;i<a.length;i++){
            temp = a[i];
            int j = i;
            for(;j>0&&a[j-1]>temp;j--){
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }

    public static void Quick_sort(int[]a,int start,int end){
        if(start<end){
            int baseNum=a[start];
            int midNum;
            int i=start;
            int j=end;
            do{
                while((a[i]<baseNum)&&i<end){
                    i++;
                }
                while((a[j]>baseNum)&&j>start){
                    j--;
                }
                if(i<=j){
                    midNum=a[i];
                    a[i]=a[j];
                    a[j]=midNum;
                    i++;
                    j--;
                }
            }while(i<=j);
            if(start<j){
                Quick_sort(a,start,j);
            }
            if(end>i){
                Quick_sort(a,i,end);
            }
        }
    }
    public  static void Merge_sort(int[] a, int left, int right) {
        int t = 1;
        int size = right - left + 1;
        while (t < size) {
            int s = t;
            t = 2 * s;
            int i = left;
            while (i + (t - 1) < size) {
                Merge(a, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right)
                Merge(a, i, i + (s - 1), right);
        }
    }

    public static void Merge(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1)
            B[k++] = data[t++];
        else
            B[k++] = data[s++];
        for (int i = p; i <= r; i++)
            data[i] = B[i];
    }


    public  static void Heap_sort(int[] a){
        int len=a.length;
        for(int i=0;i<len-1;i++){
            buildMaxHeap(a,len-1-i);
            swap(a,0,len-1-i);
        }
    }

    public static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }

    public static void  buildMaxHeap(int[] data, int lastIndex) {
        for(int i=(lastIndex-1)/2;i>=0;i--){
            int k=i;
            while(k*2+1<=lastIndex){
                int biggerIndex=2*k+1;
                if(biggerIndex<lastIndex){
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                if(data[k]<data[biggerIndex]){
                    swap(data,k,biggerIndex);
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
}
