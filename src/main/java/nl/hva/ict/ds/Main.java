package nl.hva.ict.ds;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Program Start");
LinkedList listie = new LinkedList();
listie.add(4);
listie.add(3);
listie.add(2);
listie.add(1);
listie.add(0);
        listie.add(1);
        listie.add(1);
        listie.add(5);
        listie.add(1);
        listie.add(1);
        listie.add(1);
        listie.add(1);
        listie.add(1);
        listie.add(1);






        System.out.println("");
        System.out.println("the list is "+ listie.size()+ " long.");
        System.out.println("");
        System.out.println(listie.printFromHeadToTail());
        listie.size();
        System.out.println( listie.get(7));
            System.out.println(""+ args);
        listie.delete(2);
        System.out.println( listie.get(2));


    }

}
