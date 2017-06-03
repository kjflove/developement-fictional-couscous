package banking;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.LinkedList;
import java.util.List;

/**
 * Class description ...
 * Included in banking
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 31. Mai 2017
 */
public class MoneyThread extends Thread {

    public static BankAccount account;
    private int valueAdd, iterations;

    public MoneyThread(int valueAdd, int iterations){
        this.valueAdd = valueAdd;
        this.iterations = iterations;
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < this.iterations; i++) {
            MoneyThread.account.addValue(valueAdd);
        }
    }

    public static void main(String[] args) {
        MoneyThread.account = new BankAccount();
        int countThreads = 5;
        int sumMoney = 0;
        List<MoneyThread> moneyThreads = new LinkedList<>();

        System.out.println("Generating money in " + countThreads + " Threads for you.");

        for (int i = 0; i < countThreads; i++) {
            int value = (int)(Math.random() * 30) + 5;
            int it = (int)(Math.random() * 100_000) + 1000;
            moneyThreads.add(new MoneyThread(value, it));
            System.out.println("Thread " + moneyThreads.size() +
                    " started with money value addition " + value +
                            " and " + it + " iterations.");
            sumMoney += value * it;
        }

        moneyThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("The precalculated Sum is:    " + sumMoney);
        System.out.println("The actual Account sum is:   " + MoneyThread.account.getValue());
    }
}
