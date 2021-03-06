CREATE DATABASE web_library;
USE web_library;

CREATE TABLE user (
    id_user INT AUTO_INCREMENT,
    email VARCHAR(45) UNIQUE NOT NULL,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    librarian BOOLEAN NOT NULL,
    admin BOOLEAN NOT NULL,
    blocked BOOLEAN NOT NULL,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY(id_user)
);

CREATE TABLE book (
	id_book INT AUTO_INCREMENT,
    genre VARCHAR(45) NOT NULL,
    urlImg VARCHAR(200),
    author VARCHAR(45) NOT NULL,
	nameOfBook VARCHAR(45) NOT NULL,
	publisher VARCHAR(45) NOT NULL,
    year INT NOT NULL,
    availability INT NOT NULL,
	numberOfPages INT NOT NULL,
    language VARCHAR(45) NOT NULL,
    plot VARCHAR(435),
    isOrder BOOLEAN NOT NULL,
	PRIMARY KEY(id_book)
);

CREATE TABLE subscription (
	id_subscription INT AUTO_INCREMENT,
    penalty INT NOT NULL,
	user_id INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user (id_user),
	PRIMARY KEY(id_subscription)
);

CREATE TABLE subscriptionBook (
	id_subscriptionBook INT AUTO_INCREMENT,
    dateOfPurchase DATE NOT NULL,
	subscription_id INT NOT NULL,
	book_id INT NOT NULL,
	FOREIGN KEY (book_id) REFERENCES book (id_book),
    FOREIGN KEY (subscription_id) REFERENCES subscription (id_subscription),
	PRIMARY KEY(id_subscriptionBook)
);

DROP TABLE subscriptionBook;
DROP TABLE subscription;
DROP TABLE book;
DROP TABLE user;

SELECT* FROM user;
SELECT* FROM book;
SELECT* FROM subscription;
SELECT* FROM subscriptionBook;

INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Detective", "https://m.media-amazon.com/images/I/51hYdKyWYqL.jpg",
"Dan Brown","The Da Vinci Code","US", 2000, 2, 453, "English", "Louvre curator and Priory of Sion grand master Jacques Saunire is fatally shot one night
at the museum by an albino Catholic monk named Silas, who is working on behalf of someone he knows only as the Teacher, who wishes to discover
the location of the keystone, an item crucial in the search for the Holy Grail. After Saunires body is discovered in the pose of the Vitruvian
Man by Leonardo da Vinci.", false);

INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Detective", "https://www.kino-teatr.ru/movie/posters/big/7/97967.jpg",
"Stieg Larsson", "The Girl with the Dragon Tattoo","Swedish", 2009, 2, 624, "Swedish", "Every year for the past 36 years, Henrik Vanger receives an anonymous dried flower
in a picture frame on November 1, his birthday. He has all of the frames displayed on a wall in his house. Every year, he phones his friend, a retired
detective-superintendent, who shares his birthday and his age, and tells him about the latest flower. They can only wonder who sent it and why.
In December 2002, Mikael Blomkvist.", false);

 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Detective", "https://kbimages1-a.akamaihd.net/abd1a262-857c-474f-8135-8808d3eb307d/353/569/90/False/the-adventures-of-sherlock-holmes-236.jpg",
 "Arthur Conan Doyle", "Sherlock Holmes","George Newnes", 1892, 2, 307, "English", "All of the stories within The Adventures of Sherlock Holmes are told in a first-person narrative from
 the point of view of Dr. Watson, as is the case for all but four of the Sherlock Holmes stories. The Oxford Dictionary of National Biography entry for Doyle suggests that the short stories contained
 in The Adventures of Sherlock Holmes tend to point out social injustices.", false);



 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Fantasy", "https://productimages.worldofbooks.com/0007458428.jpg",
 "John Ronald Tolkien", "The Hobbit","English", 1937, 2, 310, "English", "In the early 1930s Tolkien was pursuing an academic career at Oxford as Rawlinson and Bosworth
 Professor of Anglo-Saxon, with a fellowship at Pembroke College. Several of his poems had been published in magazines and small collections, including Goblin Feet and The Cat and the Fiddle:
 A Nursery Rhyme Undone and its Scandalous Secret Unlocked, a reworking of the nursery rhyme Hey Diddle Diddle...", false);

 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Fantasy", "https://images-na.ssl-images-amazon.com/images/I/81YOuOGFCJL.jpg",
 "Joanne Rowling", "Harry Potter and the Ph...","UK", 1997, 4, 310, "English", "Harry Potter has been living a difficult life, constantly abused by his cold aunt and uncle, Vernon and Petunia Dursley
 and bullied by their spoiled son Dudley since the death of his parents ten years prior. His life changes on the day of his eleventh birthday when he receives a letter of acceptance into Hogwarts School.", false);

 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Fantasy", "https://images.penguinrandomhouse.com/cover/9780141321073",
 "Lewis Carroll", "Alice's Adventures in Wonderland","Macmillan", 1865, 4, 141, "English", "Alice, bored on the river bank with her sister, sees a hurrying White Rabbit holding a pocket watch in its paw.
 She follows him down the rabbit hole, falls into it and finds herself in a hall with many locked doors. There she finds the key to a small 15-inch door, behind which is the garden that the girl wants to get into;
 however, the door is too small for her.", false);



 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Horror", "https://images.booksense.com/images/443/206/9781495206443.jpg",
 "Mary Shelley", "Frankenstein","Lackington, Hughes", 1818, 4, 280, "English", "Frankenstein is a frame story written in epistolary form. It documents a fictional correspondence between Captain Robert Walton and his sister, Margaret Walton Saville.
 The story takes place at an unspecified time in the 18th century (the letters' dates are given as 17).Walton is a failed writer who sets out to explore the North Pole in hopes of expanding scientific knowledge", false);

INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Horror", "https://www.wkar.org/sites/wkar/files/styles/medium/public/dracula_book_cover.jpg",
 "Bram Stoker", "Dracula","UK", 1897, 2, 418, "English", "Jonathan Harker, a newly qualified English solicitor, visits Count Dracula at his castle in the Carpathian Mountains to help the Count purchase a house near London. Ignoring the Count's warning,
 Harker wanders the castle. Soon after, Dracula leaves the castle, abandoning Harker to the women; Harker escapes with his life and ends up delirious in a Budapest hospital.
 Dracula takes a ship for England, with boxes from castle.", false);

 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Horror", "https://i.pinimg.com/originals/65/bc/69/65bc69a7bbc7f0e9690599d2c28041b9.jpg",
 "Robert Bloch", "Psycho","Simon & Schuster", 1959, 5, 185, "English", "Norman Bates, a middle-aged bachelor, is dominated by his mother, a mean-tempered, puritanical old woman who forbids him to have a life outside of her.
 They run a small motel together in the town of Fairvale, but business has floundered since the state relocated the highway. In the middle of a heated argument between them, a customer arrives,
 a young woman named Mary Crane.", false);



 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Romance", "https://m.media-amazon.com/images/I/51tiK-eB3JL.jpg",
 "Jane Austen", "Pride and Prejudice","Whitehall", 1813, 4, 185, "English", "The novel is set in rural England in the early 19th century. Mrs. Bennet attempts to persuade Mr. Bennet to visit Mr. Bingley,
 a rich bachelor recently arrived in the neighbourhood. After some verbal sparring with her husband, Mrs. Bennet believes he will not call on Mr. Bingley.
 Shortly afterwards, he visits Netherfield, Mr. Bingley's rented residence, much to Mrs. Bennet's delight..", false);

 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Romance", "https://m.media-amazon.com/images/I/41fcfrag9fL.jpg",
 "Charlotte Brontë", "Jane Eyre","Smith", 1847, 3, 448, "English", "The novel is a first-person narrative from the perspective of the title character.
 The novel's setting is somewhere in the north of England, late in the reign of George III (1760–1820). It goes through five distinct stages: Jane's childhood at Gateshead Hall,
 where she is emotionally and physically abused by her aunt and cousins.", false);

 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Romance", "https://upload.wikimedia.org/wikipedia/en/thumb/d/d9/The_Notebook_Cover.jpg/220px-The_Notebook_Cover.jpg",
 "Nicholas Sparks", "The Notebook","Warner Books", 1996, 6, 214, "English", "The Notebook is a 1996 romantic novel by American novelist Nicholas Sparks.
 The novel was later adapted into a popular film of the same name, in 2004.", false);



 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Psychology", "https://upload.wikimedia.org/wikipedia/en/6/68/Mistakes_were_made_cover_image.jpg",
 "Carol Tavris", "Mistakes Were Made","	Harcourt", 2007, 5, 298, "English", "Mistakes Were Made (But Not by Me) is a non-fiction book by social psychologists Carol Tavris and Elliot Aronson, first published in 2007. It deals with cognitive dissonance,
 confirmation bias and other cognitive biases, using these psychological theories to illustrate how the perpetrators (and victims) of hurtful acts justify and rationalize their behavior.", false);

 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Psychology", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/GamesPeoplePlay.jpg/220px-GamesPeoplePlay.jpg",
 "Eric Berne", "Games People","	Grove Press", 1964, 3, 216, "English", "Games People Play: The Psychology of Human Relationships is a bestselling 1964 book by psychiatrist Eric Berne.
 Since its publication it has sold more than five million copies. The book describes both functional and dysfunctional social interactions..", false);

 INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES ("Psychology", "https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/Thinking%2C_Fast_and_Slow.jpg/220px-Thinking%2C_Fast_and_Slow.jpg",
 "Daniel Kahneman", "Thinking, Fast and Slow","	Farrar", 2011, 4, 499, "English", " Thinking, Fast and Slow is a best-selling book published in 2011 by Nobel Memorial Prize in Economic Sciences laureate Daniel Kahneman.
 It was the 2012 winner of the National Academies Communication Award for best creative work that helps the public understanding of topics in behavioral science,
 engineering and medicine. The book summarizes research that Kahneman conducted over decades.", false);


INSERT INTO user(email, name, surname, Librarian, Admin, blocked, password) VALUES ("dekhtyarenko02@gmail.com", "Daniil", "Dekhtiarenko", false, true, false, "64Ohelos");
INSERT INTO subscription (penalty ,user_id) VALUES (0, 1);

INSERT INTO user(email, name, surname, Librarian, Admin, blocked, password) VALUES ("dekhtyarenko03@gmail.com", "Daniel", "Dekhtiarenko", true, false, false, "64Ohelos");
INSERT INTO subscription (penalty ,user_id) VALUES (0, 2);

