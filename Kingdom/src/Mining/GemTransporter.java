package Mining;

import Mining.Gems.Gem;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class GemTransporter implements Runnable {
  private final BlockingQueue<Gem> gemDeposit;
  private final int targetWorthMin;
  private final int targetWorthMax;

  public GemTransporter(BlockingQueue<Gem> gemDeposit, int targetWorthMin, int targetWorthMax) {
    this.gemDeposit = gemDeposit;
    this.targetWorthMin = targetWorthMin;
    this.targetWorthMax = targetWorthMax;
  }

  @Override
  public void run() {
    while (true) {
      int currentWorth = 0;
      int targetWorth = new Random().nextInt(targetWorthMax - targetWorthMin + 1) + targetWorthMin;
      while (currentWorth < targetWorth) {
        try {
          Gem gem = gemDeposit.take();
          currentWorth += gem.getValue();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.println("Transported gems worth: " + currentWorth);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
