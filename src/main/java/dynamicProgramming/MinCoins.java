package dynamicProgramming;

public class MinCoins {

    static int minCoins(int[] coins, int coinsTerm, int sum) {
        if (coins[coinsTerm - 1] > sum) {
            return 0;
        } else {
            coinsTerm--;
            return 1 + minCoins(coins, coinsTerm, sum - coins[coinsTerm]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the minCoins change problem.");
        int[] coins = {2, 3, 1};
        int   sum   = 5;

        System.out.println(minCoins(coins, coins.length, sum));
    }
}
