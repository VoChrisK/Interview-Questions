/**
 * Cracking the Coding Interview - Chapter 3, #3-6 - An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat
 * (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this
 * system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
 * 
 * We can maintain a single list for both dogs and cats. DequeueAny will run in O(1) but dequeueDog and dequeueCat will run in O(n)
 * Maintaining a list for each animal will ensure O(1) time complexity for any Dequeue operations.
 */

 class AnimalShelter {
     constructor() {
         this.catsList = [];
         this.dogsList = [];
         this.label = 0;
     }

     enqueue(animal) {
         animal.order = this.label;
         if (animal.type === "cat") {
             this.catsList.push(animal);
         } else {
             this.dogsList.push(animal);
         }
         this.label++;
     }

     dequeueAny() {
         return this.catsList[0].order > this.dogsList[0].order ? this.dogsList.shift() : this.catsList.shift();
     }

     dequeueDog() {
         return this.dogsList.shift();
     }

     dequeueCat() {
         return this.catsList.shift();
     }
 }

 class Animal {
     constructor(type) {
         this.type = type;
         this.order;
     }
 }

 const animalShelter = new AnimalShelter();

animalShelter.enqueue(new Animal("cat"));
animalShelter.enqueue(new Animal("dog"));
animalShelter.enqueue(new Animal("cat"));
animalShelter.enqueue(new Animal("cat"));
animalShelter.enqueue(new Animal("dog"));

console.log(animalShelter);
console.log("------------------------------");

console.log(animalShelter.dequeueAny());
console.log(animalShelter.dequeueDog());
animalShelter.enqueue(new Animal("dog"));
animalShelter.enqueue(new Animal("dog"));
console.log(animalShelter.dequeueCat());

console.log(animalShelter);
console.log("------------------------------");

console.log(animalShelter.dequeueDog());
console.log(animalShelter.dequeueAny());

console.log(animalShelter);
console.log("------------------------------");

