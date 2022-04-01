# Tell, Don't Ask!
This is a repository I created for a blog post about "Tell, Don't Ask" (TDA) at https://careforcode.com/

I wrote this code to show how you can use TDA to increase the encapsulation of your code.
The repository you see here is just a sample of a super mario game.
It also contains dummy parts in the game class that help me to draw some boundaries on the scope.
Especially the fields inside the game class and the methods how they are filled or not at all good practices.
They just help me to make my tests work, before I can create meaningful tests for the mario class, after I used TDA.

In here you will find a game and a mario class.
In the main branch, the game class manages everything while the mario class is just there to hold its state and give it to the game class.
In the first iteration branch, I used TDA to move the necessary logic from the game class to the mario class.
In the second iteration branch, I cleaned up, so the code is much more readable.

Either way, if you want to try it out, or just look at my perspective, I hope you take something out of it!
