
The class structure is fairly simple. A Player controls a Board made of Squares, and a Game has two Players. Most actions done to the Board are done through a Player, who places Ships and fires at Squares (through the board). The game ends when one of the players has destroyed all ships.

The intent of the Game class is encapsulate this behaviour so that simple tasks can come from the GUI. This is something I have had much trouble in creating, because the actionListeners seem to work in a way that escapes my understanding. 