package nl.hva.ict.ds;

/**
 * A linked list that adds elements to the end of the list and that retrieves elements from the end of the list as fast
 * as from the head of the list.
 * For example if a list contains 1000 elements the time needed to retrieve element at index 999 should be (almost) the
 * same as is needed for retrieving element at index 0. Retrieving element at index 800 should take (almost) the same
 * time as retrieving element at index 199.
 * When deleting an element all elements with the same value are deleted. So when deleting "don't" from a list that
 * contains<br/>
 * {"I", "don't", "like", "Datastructures", "as", "much", "as", "I", "don't", "like", "Sorting", "and", "Searching"}
 * this should result in a list containing:<br/>
 * {"I", "like", "Datastructures", "as", "much", "as", "I", "like", "Sorting", "and", "Searching"}
 *
 * @param <T> defines the type (class) that is stored in this list.
 */
public class LinkedList<T> {
    String returnError = "Index out of bounds";
    /**
     * Deletes the element (if it exists) from the list. In case of multiple occurrences all the occurrences are
     * deleted.
     *
     * @param element the element to delete.
     */

    private Node head = null;
    private Node tail = null;
    private int size = 0;
//    public void printFromHeadToTail(){
//        if
//    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String printFromHeadToTail() {
        String numberHolder = "" + head.value;
        Node looper = head;

        while (looper.hasNext()) {
            looper = looper.next;
            numberHolder = numberHolder + ", " + looper.value;


        }
        return numberHolder;
    }

    /**
     * Adds a new element to the end of this list. The performance of this method is guaranteed to be constant, in other
     * words, the number of elements already stored in the list should have no influence on the time needed to add a new
     * element.
     *
     * @param element the element that is added to the list.
     */
    /*Voegt element toe aan het einde van de linked list
      De linked list is veranderd in een doubly linked list voor deze methode
      Per toevoeging wordt de totale van de array vergroot.
    */
    public void add(T element) {
        if (isEmpty()) {
            tail = new Node(element, null, null);
            head = tail;
        } else {
            //Bewaart huidge tail in node
            Node temp = tail;
            //De node na de huidige tail wordt gevuld
            tail.next = new Node(element, null, tail);
            //De volgende node wordt als tail gezet
            tail = tail.next;
            //De node voor de nieuwe tail wordt terug veranderd
            tail.previous = temp;
        }
        size++;
    }

    /**
     * Returns an element from the list. If the index is negative or the element does not exists
     * an IllegalArgumentException is throw containing the reason in the message.
     *
     * @param index the index, counted from the first element, of the element that must be returned.
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(returnError);
        }
        /*Kijkt of  de opgevraagde index groter is dan de helft van de array.
        Zo ja trekt hij de index van de totale size af en loopt vervolgens het overgebleven aantal terug*/
        if (index <= (size / 2)) {
            return getFromHead(index);
        }
        return getFromTail(size - index);
    }
    /*Loopt vanaf de head*/
    public T getFromHead(int index) {
        Node node = head;
        while (index-- > 0) {
            node = node.next;
        }
        return node.value;
    }
    /*Loopt vanaf de tail*/
    public T getFromTail(int index) {
        Node node = tail;
        while (index-- > 0) {
            node = node.previous;
        }
        return node.value;
    }

    public void delete(T element) {
//set first element to head
        Node looper = head;
        //delete recursively
        deleteRecursively(element, looper);
    }

    private void deleteRecursively(T element, Node temp) {
/*Als het gegeven element gelijk staat aan het element in de node verwijdert hij deze node
* De if statements checken of de node een voor en na node heeft voor het wisselen
* Bij removal wordt de size van de array verminderd*/

        if (temp.value == element) {

            if (temp.hasNext() && temp.previous != null) {
                temp.next.previous = temp.previous;
                temp.previous.next = temp.next;
                --size;
            } else if (temp.hasNext() && temp.previous == null) {

                head = temp.next;
                deleteRecursively(element, temp.next);
                --size;
                temp = null;

                return;

            } else if (temp.hasNext() && temp.previous != null) {
                --size;
                tail = temp.previous;
                temp.previous.next = null;
            } else {
                --size;
                return;
            }

        }

        if (temp.next != null) {
            deleteRecursively(element, temp.next);
        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in the list.
     */
    public int size() {
//Geeft de integer size welke het aantal elementen bijhoud
        return this.size;
    }

    private class Node {
        private T value;
        private Node next;
        private Node previous;

        private Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Boolean hasNext() {
            return (this.next != null);
        }
    }


}
