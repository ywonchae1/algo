import java.util.*;

public class Main {
    static void mergesort(int n, int arr[]) {
        if(n <= 1) return;
        
        int leftn = n / 2;
        int rightn = n - leftn;
        
        int[] leftarr = new int[leftn];
        int[] rightarr = new int[rightn];
        
        for(int i = 0; i < leftn; i++) leftarr[i] = arr[i];
        for(int i = leftn; i < n; i++) rightarr[i - leftn] = arr[i];
        
        mergesort(leftn, leftarr);
        mergesort(rightn, rightarr);
        
        merge(leftn, rightn, leftarr, rightarr, arr);
    }
    
    static void merge(int leftn, int rightn, int leftarr[], int rightarr[], int arr[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < leftn && j < rightn) {
            if(leftarr[i] < rightarr[j]) arr[k++] = leftarr[i++];
            else arr[k++] = rightarr[j++];
        }
        
        if(i >= leftn) {
            // leftarr을 다 옮긴 상태
            while(j < rightn) arr[k++] = rightarr[j++];
        } else {
            while(i < leftn) arr[k++] = leftarr[i++];
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
        
        mergesort(N, arr);
        
        for(int i = 0; i < N; i++) System.out.println(arr[i]);
    }
}