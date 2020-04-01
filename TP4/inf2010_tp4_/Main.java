import java.util.*;


public class Main {
    /**
     * Fonction principale
     */
    public static void main(String[] args) {
        // Creer un monceau avec 22 éléments et un tableau équivalent
        int numItems = 22;
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);

        Integer[] items = new Integer[numItems];

        int i;
        int j;

        // En insérant les éléments un a un
        for (i = 11, j = 0; j != numItems; i = (i + 37), j++) {
            heap.offer(i);
            items[j] = i;

            i %= numItems;
        }

        // en construisant le monceau depuis le depart
        System.out.println("Monceau min contruit element par element:");
        System.out.println(heap.printFancyTree());

        heap = new BinaryHeap<Integer>(false);
        // en inserant les elements un a un
        for (Integer item : items)
            heap.offer(item);

        // en construisant le monceau depuis le depart
        System.out.println("Monceau max contruit element par element:");
        System.out.println(heap.printFancyTree());

        heap = new BinaryHeap<Integer>(items, false);
        System.out.println("Monceau max contruit a partir d'un tableau:");
        System.out.println(heap.printFancyTree());

        heap = new BinaryHeap<Integer>(items, true);
        System.out.println("Monceau min contruit a partir d'un tableau:");
        System.out.println(heap.printFancyTree());

        System.out.println();
        System.out.println("Affichage recursif:");
        System.out.println(heap.printFancyTree());

        System.out.println("Affichage non recursif:");
        System.out.println(heap.nonRecursivePrintFancyTree());

        System.out.println();
        System.out.println("Tableau d'origine:");
        System.out.println(printArray(items));

        BinaryHeap.heapSort(items);
        System.out.println("Tableau ordonne:");
        System.out.println(printArray(items));

        BinaryHeap.heapSortReverse(items);
        System.out.println("Tableau inversement ordonne:");
        System.out.println(printArray(items));


        /*
         * Ajouter appels pour repondre a la question
         **/

        /*Poll() min heap */
        heap = new BinaryHeap<Integer>(items, true);
        System.out.println("Monceau min avant poll() :");
        System.out.println(heap.printFancyTree());
        System.out.println("Poll d'un monceau min :");
        System.out.println(heap.poll());
        System.out.println("Monceau min après poll() :");
        System.out.println(heap.printFancyTree());

        /* Poll() max heap */
        heap = new BinaryHeap<Integer>(items, false);
        System.out.println("Monceau max avant poll() :");
        System.out.println(heap.printFancyTree());
        System.out.println("Poll d'un monceau max :");
        System.out.println(heap.poll());
        System.out.println("Monceau max après poll() :");
        System.out.println(heap.printFancyTree());


        /*Iterateur tests */
        heap = new BinaryHeap<Integer>(items, true);
        Iterator itr = heap.iterator();
        System.out.println("Tests de l'itérateur :");

        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        /*Iterateur dépasse index*/
        System.out.println();

        /*Test avec PriorityQueue*/
        System.out.println();
        System.out.println("Comparaison BinaryHeap et PriorityQueue :");
        System.out.println("   Heap et PriorityQueue après offer() :");
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        heap = new BinaryHeap<Integer>(true);
        for (i = 11, j = 0; j != numItems; i = (i + 37), j++) {
            heap.offer(i);
            queue.offer(i);
            items[j] = i;

            i %= numItems;
        }

        itr = heap.iterator();
        System.out.print("   ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + ",");
        }
        System.out.println();

        Iterator itr2 = queue.iterator();
        System.out.print("   ");
        while (itr2.hasNext()) {
            System.out.print(itr2.next() + ",");
        }
        System.out.print("\n" + "\n");


        System.out.println("   BinaryHeap et PriorityQueue après fonction poll() et valeur poll :");
        Integer hPoll = heap.poll();
        Integer qPoll = queue.poll();
        Iterator itr3 = queue.iterator();
        System.out.print("   ");
        while (itr3.hasNext()) {
            System.out.print(itr3.next() + ",");
        }
        System.out.println();
        System.out.println("   " + hPoll);

        Iterator itr4 = queue.iterator();
        System.out.print("   ");
        while (itr4.hasNext()) {
            System.out.print(itr4.next() + ",");
        }
        System.out.println();
        System.out.println("   " + qPoll);
        System.out.println();
    }

    private static <AnyType> String printArray(AnyType[] a) {
        String outputString = "";

        for (AnyType item : a) {
            outputString += item;
            outputString += ", ";
        }

        return outputString.substring(0, outputString.length() - 2);
    }
}
