package Mining.Gems;

public class GoldNugget implements Gem
{
  private String name;
  private int value;

  public GoldNugget()
  {
    this.name = "GoldNugget";
    this.value =5000;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getValue() {
    return value;
  }
}
