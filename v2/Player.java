public class Player {
  String _name;
  boolean _gender;
  int _numPokemon;
  int _numPokeball;
  int _numBerries;

  public Player(){
    _name = "Dawn";
    _gender = true;
    _numPokemon = 0;
    _numPokeball = 0;
    _numBerries = 0;
  }

  public Player(String name, boolean gender){
    this();
    _name = name;
    _gender = gender;
  }

/**
  public void displayPokedex(){

    }
    **/

    public void displayInventory(){
      System.out.println("In your bag:");
      System.out.println("Pokeballs: " + _numPokeball);
      System.out.println("Berries: " + _numBerries);
    }
}
