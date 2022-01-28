import java.util.Arrays;

public class QuickSort {

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static int particion(int[] array, int inicio, int fin) {

    if (fin - inicio == 1) {
      if (array[inicio] > array[fin]) {
        swap(array, inicio, fin);
      }
      return inicio;
    }

    int pivote = array[inicio];

    int i = inicio;
    int j = fin;

    while (i < j) {
      do {
        i++;
      } while (array[i] <= pivote && i < fin);
      do {
        j--;
      } while (array[j] > pivote);
      if (i < j) {
        swap(array, i, j);
      }
    }
    // no estoy cambiando el pivote:p
    swap(array, inicio, j);
    return j;
  }

  public static void quickSort(int[] array, int inicio, int fin) {
    // quiero elementos menores que el pivote
    if (inicio < fin) {
      int pivote = particion(array, inicio, fin);
      quickSort(array, inicio, pivote);
      quickSort(array, pivote + 1, fin);
    }

  }

  public static void quickSort(int[] array) {
    // Tiene que haber un elemento dummy que es infinito

    int[] newArray = new int[array.length + 1];

    // Copiamos todos los elementos del array al nuevo
    for (int i = 0; i < array.length; i++) {
      newArray[i] = array[i];
    }

    // Le agregamos el elemento dummy
    newArray[array.length] = Integer.MAX_VALUE;

    quickSort(newArray, 0, array.length);

    // Finalmente igualamos el array (para no tener que retornar nada)
    for (int i = 0; i < array.length; i++) {
      array[i] = newArray[i];
    }
  }

  // 5 4 3 2 1
  // *
  //
  // 1 2 3 5 7 7

  // 1 2 3
  // *
  // 1 2

  // 2 3 2 5 8 8 6
  // *
  // * *

  // 2 2 3

  public static void main(String[] args) {
    int array[] = { 4, 3, 6, 4 };
    // int array[] = { 4, 3, 6, 21, 6, 2, 4 };
    quickSort(array);
    System.out.println(Arrays.toString(array));

  }
}
