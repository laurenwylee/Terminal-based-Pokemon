import java.util.*;

public class Pokemon {
    String _name;
    int _lvl;
    int _exp;
    int _hp;
    int _attack;
    int _defense;
    int _mana;


    public Pokemon(){
      _lvl = 0;
      _exp = 0;
      _name = "snorlax";
    }

    public Pokemon(int level, int experience){
      _lvl = level;
      _exp = experience;
    }

    public String toString(){
      if (_name.equals("Turtwig")){
        return ("\nA Grass Type: \nTurtwig, the Tiny Leaf Pokemon. \nIts shell is made of earth and when it absorbs water, it becomes harder.");
      } else if (_name.equals("Piplup")) {
        return ("\nA Water Type: \nPiplup, the Penguin Pokemon. \nPiplup's limited walking skills often cause it to fall down, but that never hurts its pride.");
      } else if (_name.equals("Chimchar")){
        return ("\nA Fire Type: \nChimchar, the Monkey Pokemon. \nChimchar easily climbs the sheerest of walls and lives on mountain tops. \nWhen it sleeps, its flames go out.");
      } else if (_name.equals("Vulpix")){
        return("\nA Fire Type: \nVulpix, a Fox Pokemon. \nIts six tails are extremely beautiful. \nVulpix uses powerful flame attacks.");
      } else if(_name.equals("Slugma")){
        return ("\nA Fire Type: \nSlugma, the Lava Pokemon. \nSlugma have intensely hot magma, which circulates throughout their bodies, carrying nutrients and oxygen to their organs.");
      }else if(_name.equals("Numel")){
        return ("\nA Fire Type: \nNumel, the Numb Pokemon. \nNumel is so complacent that it does not even notice when it is stuck. \nThis Pokemon's body is filled with hot magma, which, when cooled in water, further slows its movement. \nNumel is also unable to bear hunger.");
      }else if(_name.equals("Charmander")){
        return ("\nA Fire Type: \nCharmander. \nA flame burns on the tip of its tail from birth. \nIt is said that a Charmander dies if its flame ever goes out.");
      }else if(_name.equals("Cyndaquil")){
        return ("\nA Fire Type: \nCyndaquil, the Fire Mouse Pokemon. \nNormally mild and even-tempered, Cyndaquil will shoot a scorching flame out of its back when upset.");
      }else if(_name.equals("Torchic")){
        return ("\nA Fire Type: \nA fire burns inside, so it feels very warm to hug. \nIt launches fireballs of 1,800 degrees F.");
      } else if(_name.equals("Feebas")){
        return ("\nA Water Type: \nFeebas, the Fish Pokemon. \nAlthough extremely ragged, it is a tough Pokemon that can live in almost any kind of water.");
      }else if(_name.equals("Wooper")){
        return ("\nA Water Type: \nWooper, the Water Fish Pokemon. \nThough they prefer to live in cold water, these appealing Pokemon forage for food on land. \nThey are kept warm by a layer of insulating body fluid.");
      }else if(_name.equals("Lotad")){
        return ("\nA Water Type: \nLotad, the Water Weed Pokemon. \nLotad inhabit peaceful wetlands, like lakes and ponds.");
      }else if(_name.equals("Marill")){
        return ("\nA Water Type: \nMarill, the Water Mouse Pokemon. \nIts sensitive ears can detect distant sounds and the round rubbery tip on its tail can expand and contract, assisting Marill in the water. ");
      }else if(_name.equals("Wingull")){
        return ("\nA Water Type: \nWingull, the Seagull Pokemon. \nIt uses its long wings to catch the ocean wind and glide across the sky, and then folds them when resting.");
      }else if(_name.equals("Poliwag")){
        return ("\nA Water Type: \nPoliwag, the Tadpole Pokemon. \nIt has no arms, but its tail makes it a strong swimmer.");
      } else if(_name.equals("Cherubi")){
        return ("\nA Grass Type: \nCherubi, the Cherry Pokemon. \nCherubi's attached small ball holds nutrients.");
      } else if(_name.equals("Seedot")){
        return ("\nA Grass Type: \nSeedot, the Acorn Pokemon. \nSeedot resembles an acorn when hanging by its head from branches. \nIt jumps down suddenly to the surprise of passersby.");
      } else if(_name.equals("Bulbasaur")){
        return ("\nA Grass Type: \nBulbasaur, the seed Pokemon. \nIt bears the seed of a plant on its back from birth. \nThe seed slowly develops. \nResearchers are unsure whether to classify Bulbasaur as a plant or animal. \nBulbasaur are extremely tough and very difficult to capture in the wild.");
      } else if(_name.equals("Chikorita")){
        return ("\nA Grass Type: \nChikorita, the Leaf Pokemon. \nChikorita uses the leaf on its head to scan for warmth and humidity in its surroundings, and loves to sunbathe.");
      } else if(_name.equals("Treecko")){
        return ("\nA Grass Type: \nTreecko, the Wood Gecko Pokemon. \nNumerous tiny spikes cover the bottoms of Treecko's feet, allowing it to walk on ceilings and walls.");
      } else if(_name.equals("Bellsprout")){
        return ("\nA Grass Type: \nBellsprout, the Flower Pokemon. \nBellsprout loves high temperatures and humidity. \nIt can be lightning fast when it extends its vines in order to grab something.");
      } else {
        return ("mistake");
      }
    }

    public int getDefenseMultiplier(){
      return 0;
    }
    public void setName(String name){
      _name = name;
    }
    public String getName(){
      return _name;
    }

    public int getHP(){
      return 0;
    }

    public int getAttack(){
      return 0;
    }

    public int getDefense(){
      return 0;
    }

    public int getMana(){
      return 0;
    }

    public int getLvl(){
      return _lvl;
    }

    public int getExp(){
      return _exp;
    }

    public void displayt(){
      System.out.println(_name + " / Stats:");
      System.out.println("HP: " + _hp);
      System.out.println("Attack: " + _attack);
      System.out.println("Defense:" + _defense);
      System.out.println("Mana: " + _mana);
    }

    public void lvlUp(){
      System.out.println();
    }


    public boolean isAlive(){
      return true;
    }

    public int getHPMultiplier() {
      return 1;
    }

    public void display(){
      System.out.println();
    }

    public void displayMove() {
      System.out.println();
    }

    public void move(String moveName, Pokemon name){
      System.out.println();
    }
    public void moveOther(String moveName, Pokemon name){
      System.out.println();
    }

    public boolean runaway(Pokemon opponent){
        if (opponent.getLvl() <= 10){
          return Math.random() * 10 > opponent.getLvl();
        }
        if (opponent.getLvl() <= 100){
          return Math.random() * 100 > opponent.getLvl();
        }
        else{
          return Math.random() * 1000 > opponent.getLvl();
        }
    }
}
