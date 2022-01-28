public class Inversa {

  public static void dividir(double[][] matriz, int renglon, double valor) {

    int tamColumna = matriz[0].length;

    for (int j = 0; j < tamColumna; j++) {
      matriz[renglon][j] /= valor;
    }
  }

  public static void restar(double[][] matriz, int renglonQueSeResta, int renglonDeLaResta, double multiplicacion) {
    int tamColumna = matriz[0].length;

    for (int j = 0; j < tamColumna; j++) {
      matriz[renglonQueSeResta][j] -= matriz[renglonDeLaResta][j] * multiplicacion;
    }
  }

  public static void imprimirMatriz(double[][] matriz) {
    int tamRenglon = matriz.length;
    int tamColumna = matriz[0].length;

    for (int i = 0; i < tamRenglon; i++) {
      for (int j = 0; j < tamColumna; j++) {
        System.out.print(matriz[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static double[][] invertirMatriz(double[][] matriz) {
    // Hay un problema cuando queremos dividir entre 0 (Significa que no hay
    // inversa)

    // Este algoritmo consiste en dividir cada valor de la diagonal por si misma,
    // para obtener 1, y luego restar todos los valores de arriba y abajo por ese
    // valor de 1, para que se vuelvan 0.

    // Vamos guardando la matrizIdentidad porque esa es la que queremos devolver

    double[][] matrizIdentidad = new double[matriz.length][matriz.length];
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[0].length; j++) {
        if (i == j) {
          matrizIdentidad[i][j] = 1;
        } else {
          matrizIdentidad[i][j] = 0;
        }
      }
    }

    // Dividir primer renglon
    for (int j = 0; j < matriz[0].length; j++) {

      // La matriz no tiene inversa
      if (matriz[j][j] == 0) {
        throw new RuntimeException("La matriz no tiene inversa");
      }

      dividir(matrizIdentidad, j, matriz[j][j]);
      dividir(matriz, j, matriz[j][j]);

      for (int i = 0; i < j; i++) {
        restar(matrizIdentidad, i, j, matriz[i][j]);
        restar(matriz, i, j, matriz[i][j]);
      }

      for (int i = j + 1; i < matriz.length; i++) {
        restar(matrizIdentidad, i, j, matriz[i][j]);
        restar(matriz, i, j, matriz[i][j]);
      }
    }

    // Restar el primer renglon
    return matrizIdentidad;
  }

  public static void main(String[] args) {

    double[][] matriz = new double[][] {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 1 }
    };

    double[][] matrizInversa = invertirMatriz(matriz);
    imprimirMatriz(matrizInversa);
  }

}