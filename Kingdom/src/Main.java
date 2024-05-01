import Catalogue.Catalogue;
import Government.Accountant;
import Government.King;
import Government.TreasureRoom;
import Government.TreasureRoomGuard;
import Mining.*;
import Mining.MinigStrategies.MiningFast;
import Mining.MinigStrategies.MiningNormal;
import Mining.MinigStrategies.MiningSlow;
import Mining.MinigStrategies.MiningStrategies;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Catalogue catalogue = Catalogue.getInstance();

    TreasureRoom treasureRoom = new TreasureRoom();
    TreasureRoomGuard treasureRoomGuard = new TreasureRoomGuard(treasureRoom);

    GemDeposit gemDeposit = new GemDepositQueue<>(20);
    GemMine gemMine = GemMine.getInstance();

    int numOfMineWorkers = 13;
    int numOfTransporters = 10;
    int numOfAccountants = 3;

    for (int i = 1; i <= numOfMineWorkers; i++)
    {
      MiningStrategies strategy;
      if (i % 10 == 0)
      {
        strategy = new MiningFast();
      }
      else if (i % 2 == 0)
      {
        strategy = new MiningSlow();
      }
      else
      {
        strategy = new MiningNormal();
      }

      GemMineWorker worker = new GemMineWorker(gemDeposit, i);
      worker.setStrategy(strategy);
      new Thread(worker).start();
    }

    for (int i = 1; i <= numOfTransporters; i++)
    {
      new Thread(new GemTransporter(gemDeposit, i, treasureRoomGuard)).start();
    }

    Thread.sleep(5000);

    for (int i = 1; i <= numOfAccountants; i++)
    {
      new Thread(new Accountant(i, treasureRoomGuard)).start();
    }

    King king = new King(treasureRoomGuard);
    new Thread(king).start();

  }
}
