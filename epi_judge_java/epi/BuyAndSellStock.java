package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    // TODO - you fill in here.
    double min = prices.get(0);
//    double profit = 0.0;
    double maxProfit = 0.0;
    for (int i = 0; i < prices.size(); i++) {
//      if (prices.get(i) < min) min = prices.get(i);
//      if (prices.get(i).compareTo(min) < 0) min = prices.get(i);
      min = Math.min(prices.get(i), min);
      double profit = Math.max(prices.get(i) - min, 0);
      maxProfit = Math.max(profit, maxProfit);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
