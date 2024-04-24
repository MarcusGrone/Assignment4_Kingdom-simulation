package Mining;

import Mining.Gems.Gem;
import Mining.MinigStrategies.MiningStrategies;

import java.util.concurrent.BlockingQueue;

public class GemMineWorker implements Runnable
{
  private final BlockingQueue<Gem> gemDeposit;
  private final MiningStrategies miningStrategies;


  public GemMineWorker(BlockingQueue<Gem> gemDeposit, MiningStrategies miningStrategies) {
    this.gemDeposit = gemDeposit;
    this.miningStrategies = miningStrategies;
  }
  @Override
  public void run() {
    while (true) {
      Gem gem = miningStrategies.mineGem();
      try {
        gemDeposit.put(gem);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
