package Mining.Gems;

public class GoldNugget implements Gem
{
  @Override public String getName()
  {
      return "GoldNugget";
  }

  @Override public int getValue()
  {
    return 5000;
  }
}
