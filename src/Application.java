
public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        do {
            baseball.getComputerNumber();
            baseball.play();
        } while (baseball.restartCheck());

        System.out.println("게임 종료");
    }
}