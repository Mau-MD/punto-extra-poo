public class Queens {

  // Clasico algoritmo de backtracking.
  // Tenemos un tablero de 8x8, y ponemos la reina en cada posicion y voy
  // avanzado.

  static final int N = 8;

  static int posicionReina[] = new int[N]; // No necesitamos todo el tablero, solo la posicion donde estará
  static int solucionesEncontradas = 0;

  public static void imprimirTablero() {

    // for (int i = 0; i < N; i++) {
    // System.out.print(posicionReina[i] + " ");
    // }

    System.out.println();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (posicionReina[j] == i) {
          System.out.print("* ");
        } else {
          System.out.print("- ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  // Solo debemos que comprobar la nueva posicion
  public static boolean esValido(int columna) {
    // Como comprobamos si es valido ?
    for (int i = 0; i < columna; i++) {

      // Checar las filas
      if (posicionReina[i] == posicionReina[columna]) {
        return false;
      }

      // Checar las diagonales
      int x1 = i;
      int y1 = posicionReina[i];

      int x2 = columna;
      int y2 = posicionReina[columna];

      // Si la resta absoluta es igual, entonces estan en la misma diagonal
      int restaX = Math.abs(x1 - x2);
      int restaY = Math.abs(y1 - y2);

      if (restaX == restaY) {
        return false;
      }

    }

    // No es necesario checar la diagonal izquierda

    return true;
  }

  public static void resolver(int columna) {

    // Checamos si es valida la nueva posicion de la reina

    // imprimirTablero();
    // Si la columna es igual a N, es que ya hemos resuelto el problema
    if (columna == N) {
      solucionesEncontradas++;
      imprimirTablero();
      return;
    }

    for (int j = 0; j < N; j++) {
      // Ponemos la reina
      posicionReina[columna] = j;

      if (esValido(columna)) {
        resolver(columna + 1); // Avanzamos una columna
      }

      // Quitamos la reina
      posicionReina[columna] = -1; // Realmente no tenemos que hacer esto, pero funciona como referencia
    }

  }

  public static void main(String[] args) {
    // Inciiar posicion reina con -1
    for (int i = 0; i < N; i++) {
      posicionReina[i] = -1;
    }

    // Hacer la primera columna
    resolver(0);
    System.out.println("Soluciones encontradas: " + solucionesEncontradas);
  }
}
