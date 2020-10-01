package mail_protection;

public class AttemptCounter {
    private static AttemptCounter instance;
    private int count;

    private AttemptCounter() {
        count = 0;
    }

    public static synchronized AttemptCounter getInstance() {
        if (instance == null) {
            instance = new AttemptCounter();
        }
        return instance;
    }


    public int Counter() throws TooManyLoginAttemptsException {
        if (count == 5) {
            throw new TooManyLoginAttemptsException("Слишком много попыток входа!");
        }
        count += 1;
        return count;
    }

    public void setCount(int i) {
        count = i;
    }
}
