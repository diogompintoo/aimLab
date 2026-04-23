# Code organization and conventions
- don't underestimate the effectiveness of organizing the classes in packages
	- it is a form of encapsulation
	- depending on the access modifiers you use, these classes can be invisible from the outside

- pay attention to conventions regarding naming variables and methods
	- following a convention improves readability
	- it is also good practice, since soon you will be following someone else's conventions

- delete classes, properties and methods not being used
	- if you want, maintain them in a different branch

# OOP
- Menu and GameOverScreen both have only two methods, show() and hide()
	- why not create an Interface?
	- you might want to add other screens in the future...

- GameMode and ClassicMode
	- this feels like other game modes will be created!
	- so, is GameMode really a concrete class?

- kudos for encapsulating a lot
	- you have a lot of methods, with very little implementation
	- you have a lot of speacialized classes
	- good job in terms of abstraction: what each entity represents and what it does

# Logic
- the restart feature does not appear to be working on my computer
- check the isHit method, I think you are over complicating it; check how to creat a hit box for a circle; print the coordinates so you can understand what is happening (where exactly the hit works)
- when a target is hit, why is that object removed from the target list, only to be replaced by a new object? why not just translate the object? 


# Design Patterns
- Factory Design Pattern
	- why not create a class with static methods?
	- why is it necessary to create an instance of TargetsFactory

- State Design Pattern
	- it looks like you are trying to implement the State DP in `Game` class
	- you have the idea that the game has distinct modes of behaviour, and you are tracking those using the enum (good job)
	- but the structure of the pattern is missing
		- go back to the materials and check the canonical State pattern structure
		- each state should be encapsulated in its own class, implementing a common interface
		- this way, `Game` doesn't need to know what each state does
		- each state object should manage their own logic, including transitions to other states
		- rigth now, your `Game` holds all this logic, which defeats the purpose of the State DP
		- in case you add more states, consider how the switch case will grow and get more difficult to maintain
	- basically, think how the State DP (that relies in polymorphism) can solve this problem, so you can delete that ugly switch case


# Next steps
- implement the high score board, using the just acquired knowlodge of streams
- organize your classes in packages, check if Interfaces are needed
- implment the State DP

Having said all this, you did a FANTASTIC job! For the most part, you created impressive code - the structure is logical, readable and, of course, it's working! 

