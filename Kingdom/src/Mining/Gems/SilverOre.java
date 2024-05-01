package Mining.Gems;

public class SilverOre implements Gem
{
  private String name;
  private int value;

  public SilverOre()
  {
    this.name = "Silver";
    this.value = 500;
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
