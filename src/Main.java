import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Готов начать Игру? (Напиши: ДА или НЕТ)");
        String answer = scanner.nextLine();
        switch (answer.toLowerCase()) {
            case "да":
                System.out.println("Начнем игру!");
                break;
            case "нет":
                System.out.println("Бай-бай!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Ты можешь поменять величину букв, но не сами буквы :)");
                System.exit(0);

        }

        System.out.println("Выбери уровень сложности (НАПИШИ ЧИСЛО ОТ 1 ДО 3)");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Это не целое число или не число вовсе.");
            System.exit(0);
        }
        int difficulty = scanner.nextInt();
        if (difficulty >= 1 && difficulty <= 3) {
            System.out.println("Ты выбрал " + difficulty + " сложность");
        } else {
            System.out.println("я сказал от 1 до 3, НИ БОЛЬШЕ И НИ МЕНЬШЕ!");
            System.exit(0);
        }
        Random l = new Random();
        int size = l.nextInt(5, 7);
        String[][] board = new String[size][size];
        int step = 1;
        Person person = new Person(size);
        Random r = new Random();
        int castleX = r.nextInt(size) + 1;
        int castleY = (1);
        String castleImage = "\uD83C\uDFEF";

        int monsterCount = (size * size) * (difficulty);
        monster[] monsters = new monster[monsterCount];
        for (int i = 0; i < monsterCount; i++) {
            int type = r.nextInt(5);
            if (type == 0) monsters[i] = new monster(size);
            else if (type == 1) monsters[i] = new BigBOOMBANG(size);
            else monsters[i] = new smallMonsterMEOW(size);
            }
        boolean game = true;

        while(game) {
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    board[y][x] = " ";

                }
            }
            for (monster m : monsters) {
                if (m != null && m.getX() > 0 && m.getY() > 0) {
                    board[m.getY() - 1][m.getX() - 1] = m.getImage();
                }
            }
            board[castleY -1][castleX - 1] = castleImage;
            board[person.getY() - 1][person.getX() - 1] = person.getImage();

            System.out.println("\nХод: " + step + " | Жизни:" + person.getLive());
            String wall = "+====".repeat(size) + "+";
            for (int i = 0; i < size; i++) {
                System.out.println(wall);
                for (int j = 0; j < size; j++) {
                    System.out.print("| " + board[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println(wall);

            if (person.getLive() <= 0) {
                System.out.println("Ты помер :(");
                System.exit(0);
            }

            System.out.println("Текущие координаты: X =" + person.getX() + ", Y =" + person.getY());
            System.out.println("Введите новые координаты героя (x и y через пробел)");

            int nextX = scanner.nextInt();
            int nextY = scanner.nextInt();

            if (nextX < 1 || nextX > size || nextY < 1 || nextY > size) {
                System.out.println("Вы хотите выйти за границы и сломать мою игру? Нетушки!");
                continue;
            }

            if(person.isMoveCorrect(nextX, nextY)) {
                String nextCell = board[nextY - 1][nextX - 1];

                if (nextCell.equals(castleImage)) {
                    System.out.println("ЕЕЕЕ!!! ТЫ СМОГ ВЫЖИТЬ И ДОБРАТЬСЯ ДО ЗАМКА!!!! ТЫ ПОБЕДИИИИИИИИИИИИИИИИИИЛ!!!!");
                    System.exit(0);

                } else if (!nextCell.equals(" ")) {
                    for (int i = 0; i < monsters.length; i++) {
                        if (monsters[i] != null && monsters[i]. getX() == nextX && monsters[i].getY() == nextY ) {
                            boolean success = monsters[i].taskMonster(difficulty);
                            if (success) {
                                monsters[i] = null;
                                person.move(nextX, nextY);
                            } else {
                                person.downLive();
                            }
                            break;
                        }
                    }
                } else {
                    person.move(nextX, nextY);
                }
                step++;
            } else {
                System.out.println("Неверный ход");
            }
        }
    }
}