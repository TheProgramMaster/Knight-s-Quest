# Knight-s-Quest
  This is an RPG-style java-based game in which the player will be allotted the opportunity to partake in battles with monsters as well as a final boss. The game will be in an 8-bit style retro format.

## Inspiration
  I was inspired to work on this through me experiences in my advanced object-oriented programming course. The professor of the course in question has a specific interest in game development and, thus, made sure to incorporate the practice into every aspect of our course study.
## What it does
  The program allows the player to control a knight sprite up and down in a vertical manner by hitting the up and down keys. (NOTE: Horizontal functionality not operable yet. Moving left and right causes program to mess up GUI components). The player can move up from two different maps, encounter a goblin, and initiate a battle between player party and goblin enemy.
## How we built it
  I built this project using purely the Java programming language. The overwhelming majority of this content was built using Java Graphical User Interface (GUI) components. I also made extensive use of the java.net.* library in order to import images from websites into the application for user consumption. 
## Challenges we ran into
  I ran into significant challenges concerning how best to allow the sprite to move, as well as how best to style the title screen in which the user will meet with upon initially starting the game. I was able to solve the problem concerning user movement in a vertical manner by making use of a grid Layout Manager in the context of the JPanel in which each block sprite of the 8-bit retro-style RPG game was situated. I was then able to solve the problem concerning user consumption at title screen by simply disposing of the JFrame upon clicking either the Story button, in which the user will be met with a JTextArea read from the text file containing the story in the game (to which there is a back button to go back to the title screen of the game), or the play button, which will also dispose the JFrame in the same manner and thereupon create an object of the first map in the game.
## Accomplishments that we're proud of
  I am most proud of making use of my education over the past to year to be able to successfully create a graphical game for user consumption.
## What we learned
  I learned how include JButtons in the context of JFrame components in such a manner that they can be included in a multiplicative manner, and I also learned how to animate my sprite in accordance with the necessities of my application. I also finally learned how to make correct use of github statements in order to keep track of my work through the duration of the project.
## What's next for Knight's Quest
  I could potentially continue to work on this project in order to allow the user to move in a horizontal manner. I would also like to see the project continue to completion such that the user's party will have the capability to battle the final boss (i.e. "The Goblin King"). In doing so, I would like to implement more common RPG-style techniques, including allowing the player to enter the castle at the beginning of the game, and to potentially enter towns upon entering the same square as a town or castle.
