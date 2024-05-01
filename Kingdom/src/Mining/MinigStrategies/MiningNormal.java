package Mining.MinigStrategies;

import Mining.GemMine;
import Mining.Gems.Gem;

import java.util.Random;

public class MiningNormal implements MiningStrategies
{


  public MiningNormal()
  {

  }
  @Override
  public Gem mineGem() {
    try
    {
      Thread.sleep(3000);
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
    }
    return GemMine.getGem();

  }
}


