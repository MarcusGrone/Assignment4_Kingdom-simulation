package Mining;

import Catalogue.Catalogue;
import Mining.Gems.Gem;
import Mining.List.MyArrayList;

public class GemDepositQueue<T> implements GemDeposit
{
  private MyArrayList<Gem> deposit;

  private int capacity;

  public GemDepositQueue(int capacity)
  {
    this.capacity = capacity;
    deposit = new MyArrayList<Gem>();
  }

  @Override public void put(Gem gem)
  {
    while (deposit.size() == capacity)
    {
      try
      {
        Catalogue.addToMiningLogs(
            "Deposit is full, waiting for transporter to take gems");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    deposit.add(gem);
    if (deposit.size() == 1)
      notifyAll();
  }

  @Override public Gem get()
  {
    while (deposit.isEmpty())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    Gem gem = deposit.remove(0);
    if (deposit.size() == capacity - 1)
      notifyAll();
    return gem;
  }
}
