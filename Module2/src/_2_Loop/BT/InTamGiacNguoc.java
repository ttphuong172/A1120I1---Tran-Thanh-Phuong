package _2_Loop.BT;
import java.util.Scanner;
public class InTamGiacNguoc {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap vao kich thuoc");
        int size=scanner.nextInt();
        for (int i=size;i>=1;i--){
            for (int j=1;j<=i;j++){
                System.out.print('*');
            }
            System.out.println("\n");
        }
    }
}
