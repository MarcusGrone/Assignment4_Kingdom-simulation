package Mining.Gems;

public class Ruby implements Gem
{
  private String name;
  private int value;

  public Ruby()
  {
    this.name = "Ruby";
    this.value =2000;
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
