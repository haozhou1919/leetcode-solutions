import java.util.Arrays;

class solution_121 {
  public int maxProfit_b(int[] prices) {
    int prof = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      if(prices[i]< min) min = prices[i];
      prof = prices[i]-min > prof ? prices[i]-min : prof;
    }
    return prof;
  }

  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 1)
      return 0;
    else {
      int[] left = Arrays.copyOfRange(prices, 0, n / 2);
      int[] right = Arrays.copyOfRange(prices, n / 2, n);
      int lmin = findMin(left);
      int rmax = findMax(right);
      int pfc = rmax - lmin > 0 ? rmax - lmin : 0;
      return Math.max(Math.max(pfc, maxProfit(right)), maxProfit(left));
    }
  }

  public int findMax(int[] a) {
    int m = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] > m)
        m = a[i];
    }
    return m;
  }

  public int findMin(int[] a) {
    int m = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < m)
        m = a[i];
    }
    return m;
  }
}