import java.util.Scanner;

public class Array {

    public static void main(String args[]) {
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        int[] a = new int[n];
        int sum=0;
        for (int i=0;i<n;i++) {
            a[i]=sc.nextInt();
            sum=sum+a[i];
        }

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                if (a[i]>a[j]) {
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        for (int i=0;i<n;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("\n");
        System.out.println(sum);
        double avr=sum/n;
        System.out.println(avr);
    }
}
