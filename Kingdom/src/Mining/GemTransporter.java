package Mining;

import java.util.ArrayList;
import java.util.Random;

import Catalogue.Catalogue;
import Government.TreasureRoomDoor;
import Mining.Gems.Gem;

public class GemTransporter implements Runnable
{
  private Random random = new Random();
  private String name;
  private GemDeposit gemDeposit;
  private TreasureRoomDoor treasureRoomDoor;
  private ArrayList<Gem> gemsToTransport;

  public GemTransporter(GemDeposit gemDeposit, int id,
      TreasureRoomDoor treasureRoomDoor)
  {
    this.gemDeposit = gemDeposit;
    this.name = "Transporter " + id;
    this.treasureRoomDoor = treasureRoomDoor;
    gemsToTransport = new ArrayList<>();
  }

  public String getName()
  {
    return name;
  }

  @Override public void run()
  {
    while (!Thread.currentThread().isInterrupted()) {
      int minValueToTransport = random.nextInt(3001) + 1000; // Extended the original interval from 50 to 200, to 1000 to 4000
      int totalValue = 0;

      while(totalValue < minValueToTransport) {

        Gem gemToTransport = (Gem) gemDeposit.get();
        if (gemToTransport != null) {
          gemsToTransport.add(gemToTransport);
          totalValue += gemToTransport.getValue();
        }
      }

      try {
        Catalogue.addToMiningLogs(name + " is transporting " + gemsToTransport.size() + " gems with a total value of " + totalValueOfTransport());
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      treasureRoomDoor.acquireWriteAccess(name);
      for (Gem gem : gemsToTransport) {
        treasureRoomDoor.addValuable(gem);
      }

      Catalogue.addToTreasureRoom(totalValue);
      gemsToTransport.clear();
      treasureRoomDoor.releaseWriteAccess(name);

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public int totalValueOfTransport()
  {
    int totalValue = 0;
    for (Gem gem : gemsToTransport)
    {
      totalValue += gem.getValue();
    }
    return totalValue;
  }

}