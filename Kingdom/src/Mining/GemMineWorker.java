package Mining;

import Catalogue.Catalogue;
import Mining.Gems.Gem;
import Mining.MinigStrategies.MiningFast;
import Mining.MinigStrategies.MiningNormal;
import Mining.MinigStrategies.MiningSlow;
import Mining.MinigStrategies.MiningStrategies;

public class GemMineWorker implements Runnable
{
  MiningStrategies strategy;
  private GemDeposit gemDeposit;
  private int id;
  private String name;

  public GemMineWorker(GemDeposit gemDeposit, int id)
  {
    this.gemDeposit = gemDeposit;
    this.id = id;
    this.strategy = new MiningNormal();
    updateNameBasedOnStrategy();
  }

  public void setStrategy(MiningStrategies strategy)
  {
    this.strategy = strategy;
    updateNameBasedOnStrategy();
  }

  public void updateNameBasedOnStrategy()
  {
    if (strategy instanceof MiningNormal)
    {
      name = "NormalMiner " + id;
    }
    else if (strategy instanceof MiningFast)
    {
      name = "FastMiner " + id;
    }
    else if (strategy instanceof MiningSlow)
    {
      name = "SlowMiner " + id;
    }
  }

  @Override public void run()
  {
    while (!Thread.currentThread().isInterrupted())
    {
      Gem gemMined = strategy.mineGem();
      Catalogue.addToMiningLogs(
          name + ": mined " + gemMined.getName() + " worth: "
              + gemMined.getValue() + " coins");
      if (gemMined != null)
      {
        gemDeposit.put(gemMined);
      }
    }
  }
}
