import java.util.Random;
import java.util.Scanner;

public class smallMonsterMEOW extends monster {

    public smallMonsterMEOW(int size){
        super(size);
        this.image = "\uD83D\uDC7A";
    }

    @Override
    public boolean taskMonster(int difficulty) {
        Random r = new Random();
        int b = r.nextInt(10);
        int a = r.nextInt(10);//ЭТОМАЛЕНЬКИЙМОНСТРМЯУЧЕГОВЫОЖИДАЛИ?!?!


        System.out.println("Маленький монстр, поражая вас своим маленьким страшным размером, пищит следующее: " + a + " - " + b +" = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if (a - b == ans) {
            System.out.println("Верно, вы правильно решив пример смогли прогнать его");
            return true;
        } else {
            System.out.println("Даже мини пупсика не смог прогнать\uD83D\uDE23");
            return false;
        }
    }
}