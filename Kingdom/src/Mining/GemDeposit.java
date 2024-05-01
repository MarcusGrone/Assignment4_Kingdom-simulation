package Mining;

import Mining.Gems.Gem;

public interface GemDeposit {
  void put(Gem gem);
  Gem get();
}