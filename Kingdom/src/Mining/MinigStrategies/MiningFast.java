package Mining.MinigStrategies;

import Mining.GemMine;
import Mining.Gems.Gem;

import java.util.Random;

public class MiningFast implements MiningStrategies
{
  public MiningFast()
  {

  }

  @Override public Gem mineGem()
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
    }
    return GemMine.getGem();

  }
}

