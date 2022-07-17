# CrabbyChips
 * Crabby Chips -- Lauren Lee & Diana Akhmedova

 * Project Description:
    * Pokemon Shining Pearl is a Pokemon RPG game where players can work through the game to beat three gym leaders in order to win the game. The projects incorporates interfaces, arrayLists, inheritance, and other key concepts covered throughout the semester. Most of the game will be spent walking in which there is a random probability that the player will meet a civilian and get free Pokeballs and berries, meet a wild Pokemon in which they can battle and catch, meet a fellow trainer in which they can battle or run away, or encounter nothing and walk again. The trainer can also choose to battle gym leaders when ready and heal their Pokemon at the local clinic. After beating a gym, the user is automatically "transported" to the next region in which they can continue to walk and battle gyms when ready.

  * How-to-Launch Instructions:
    * Make sure you have all files in your directory. (Woo.java, Fire.java, Water.java, Grass.java, Human.java, Player.java, Type.java, Pokemon.java) and compile them all using ```javac *.java```. You can run Woo by typing ``` java Woo ``` into the terminal. When prompted, input text based on your responses. For the best experience, input valid text.

  * Tutorial:
    * There are three types of Pokemon: Fire, Water and Grass.
    * Each Pokemon has three moves: one that attacks, one that defends, and one that restores your Power Points (PP).
    * After your turn, you will be given a choice to consume a Berry. A Berry restores 20 Hit Points (HP).
    * Then, your opponent will be given a chance to make a move.
    * If all of your Pokemon faint, your opponent has won and your Pokemon will be rushed to the Nurse.
    * If you successfully defeat your opponent, you will be either prompted to another battle, keep walking, or face a gym.
    * There are three gyms in total: Grass, Water, and Fire, respectively.
    * You are currently in the region with the Grass gym, Gardenia.
    * After you beat each gym, you will earn a badge of the respective region's element.
    * If you conquer all three gyms, you will beat the game.
    * That's all you need to know! Have fun and remember to catch them all!

  * Mechanics:
    * Defense shields HP, which means, defense must first be depleted before making damage to the HP. HP must reach 0 before the Pokemon is defeated.
    * Each type has their own respective moves, but moves are not specific to individual Pokemon.
    * Attack moves take 25 PP and Defense moves take 20 PP.
    * There are type advantages. If the opponent is a strength, the attack strength is 1.3 * attack and if the opponent is a weakness, the attack strength is 0.7 of the attack. If same type, attack is equal to attack of the Pokemon.
    * In battle, your starter is the first Pokemon that is used for battle. As your Pokemon faint, the next Pokemon that will appear will be in the order in which the user caught it.
    * Pokemon for battle are generated randomly. Their types are equally as likely, their level is in the range of two less that the starter Pokemon level and two more than the start Pokemon level.
    * Pokemon will level around every five moves. Experience (EXP) increases by 20 every move. When EXP reaches 100, the Pokemon will level up, in which all their stats will be replenished and increased based on level.
    * The clinic replenishes PP, HP, and Defense.
