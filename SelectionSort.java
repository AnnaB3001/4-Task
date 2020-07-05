public class SelectionSort {
    public static void sortSave(int[] array, MyLinkedList<SortState> sortStates) {
        for (int min = 0; min < array.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.length; j++) {
                if (array[j] < array[least]) {
                    least = j;
                }
            }
            int tmp = array[min];
            array[min] = array[least];
            array[least] = tmp;
            sortStates.addLast(new SortState(array,min,least));
        }
    }
}
