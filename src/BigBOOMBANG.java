import java.util.Random;
import java.util.Scanner;

public class BigBOOMBANG extends monster {

    public BigBOOMBANG(int size){
        super(size);
        this.image = "\uD83D\uDC79";
    }


    @Override
    public boolean taskMonster(int difficulty) {
        Random r = new Random();
        int b = r.nextInt(50);
        int a = r.nextInt(b + 5);
        int e = r.nextInt(a + b );
        int c = r.nextInt(a * b - difficulty + e );


        System.out.println("Большой монстр, пугая почти до смрети вас своим гигантским размером, кричит следующее: ( " + a + " * " + b +" ) - " + c  + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if (a * b == ans) {
            System.out.println("Верно, вы правильно решив пример смогли пронзить его сдохли его");
            return true;
        } else {
            System.out.println("Неверно! вас Большой монстр чуть не раздавил своей рукой\u2620\uFE0F");
            return false;
        }
    }
}