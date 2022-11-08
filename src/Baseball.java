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
    private boolean strikeCheck(final char userDigit, int position) {
        for (int i = 0; i < 3; i++) {
            if (userDigit == computerNumber.charAt(i) && position == i) {
                return true;
            }
        }
        return false;
    }

    private boolean ballCheck(final char userDigit) {
        for (int i = 0; i < 3; i++) {
            if (userDigit == computerNumber.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public String analyze() {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            char userDigit = userNumber.charAt(i);
            if (strikeCheck(userDigit, i)) {
                strikeCount++;
            } else if (ballCheck(userDigit)) {
                ballCount++;
            }
        }
        return getResult(ballCount, strikeCount);
    }
    private String getResult(int ballCount, int strikeCount) {
        if (strikeCount == 3) {
            return Message.GAME_CLEAR;
        } else if (ballCount == 0 && strikeCount == 0) {
            return Message.NOTHING;
        } else if (ballCount == 0) {
            return strikeCount + Message.STRIKE;
        } else if (strikeCount == 0) {
            return ballCount + Message.BALL;
        }
        return ballCount + Message.BALL + " " + strikeCount + Message.STRIKE;
    }
}
