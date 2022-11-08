import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball {
    private String userNumber;
    private String computerNumber;

    public Baseball() {
        userNumber = "";
        computerNumber = "";
    }
    public void getComputerNumber() {
        computerNumber = createRandomNumber(3);
    }

    private String createRandomNumber(int number) {
        Set<Character> randomNumbers = new HashSet<>();
        String result = "";
        int count = 0;
        while (number > count) {
            char c = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);
            if (randomNumbers.contains(c)) {
                continue;
            }
            randomNumbers.add(c);
            result += c;
            count++;
        }
        return result;
    }

    private String exception() {
        String input = Console.readLine();
        for (int i = 0; i < 3; i++) {
            char zero = input.charAt(i);
            if (zero == '0') {
                throw new IllegalArgumentException();
            }
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        return input;
    }

}
