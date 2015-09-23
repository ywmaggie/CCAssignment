import java.util.LinkedList;

/**
 * Created by zhangyuwei on 9/22/15.
 */

/*
    we hold a queue for cats and a queue for dogs, when dequeue cat and dog, we simply manipulate each queue.
    when enqueue, we check for the animal type and enqueue to the corresponding queue.
    when dequeue, we look at the head of both cat queue and dog queue, and dequeue the one with smaller timestamp.
 */
public class Solution06 {
    public class animal{
        int species; //0 for cat, 1 for dog
        int time;
        public animal(int i, int t){
            species = i;
            time = t;
        }
    }

    public class animalShelter{
        LinkedList<animal> cat;
        LinkedList<animal> dog;
        int timestamp;

        public animalShelter(){
            cat = new LinkedList<animal>();
            dog = new LinkedList<animal>();
            timestamp = 0;
        }

        public void enqueue(int a){
            if(a == 0){
                animal c = new animal(0, timestamp);
                cat.add(c);
            }
            else{
                animal d = new animal(0, timestamp);
                dog.add(d);
            }
            timestamp ++;
        }

        public animal dequeueCat(){
            if(cat.size() != 0)
                return cat.remove();
            else
                return null;
        }

        public animal dequeueDog(){
            if(dog.size() != 0)
                return dog.remove();
            else
                return null;
        }

        public animal dequeueAny(){
            if(cat.size() == 0 && dog.size() == 0)
                return null;
            if(cat.size() == 0)
                return dog.remove();
            if(dog.size() == 0)
                return cat.remove();

            // check the head of both queues, to find the animal entered earrlier
            animal c = cat.peekFirst();
            animal d = dog.peekFirst();
            if(c.time < d.time)
                return cat.remove();
            else
                return dog.remove();
        }
    }
}
