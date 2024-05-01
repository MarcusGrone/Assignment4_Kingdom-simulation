package Mining.MinigStrategies;

import Mining.GemMine;
import Mining.Gems.Gem;

import java.util.Random;

public class MiningSlow implements MiningStrategies
{

  public MiningSlow()
  {

  }

  @Override public Gem mineGem()
  {

    try
    {
      Thread.sleep(5000);
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
    }
    return GemMine.getGem();

  }
}
