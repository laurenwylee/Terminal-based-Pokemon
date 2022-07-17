public class Player {
  String _name;
  boolean _gender;
  static int _numPokemon;
  static int _numPokeball;
  static int _numBerries;
  static Pokemon[] _pokedex;
  static int _pokedexSize;

  public Player(){
    _name = "Dawn";
    _gender = true;
    _numPokemon = 0;
    _numPokeball = 0;
    _numBerries = 0;
    _pokedex = new Pokemon[_numPokemon];
    _pokedexSize = 0;
  }

  public Player(String name, boolean gender){
    this();
    _name = name;
    _gender = gender;
  }

  private static void expand()
  {
    Pokemon[] temp = new Pokemon[ _pokedex.length * 2 ];
    for( int i = 0; i < _pokedex.length; i++ ) {
      temp[i] = _pokedex[i];
    }
    _pokedex = temp;
  }

  public static void add( Pokemon newPokemon )
  {
    if (_pokedexSize + 1 > _pokedex.length) {
    	expand();
    }
    _pokedex[_pokedexSize] = newPokemon;
    _pokedexSize += 1;
  }


  public static void displayPokedex(){
    for (Pokemon p : _pokedex) {
      p.display();
    }
  }

    public static void displayInventory(){
      System.out.println("In your bag:");
      System.out.println("Pokeballs: " + _numPokeball);
      System.out.println("Berries: " + _numBerries);
    }
}
