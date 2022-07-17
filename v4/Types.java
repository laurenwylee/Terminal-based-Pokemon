public interface Types {
  public int getHP();
  public int getAttack();
  public int getDefense();
  public int getMana();
  public boolean isAlive();
  public void display();
  public void displayMove();
  public void move(String moveName, Pokemon name);
}
