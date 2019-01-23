import java.io.*;
import java.util.*;

public class problem3 {

  public static void main(String[] args) {
    // set up
    try {

      PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
      BufferedReader bReader = new BufferedReader(new FileReader(new File(args[0])));

      Integer i = Integer.parseInt(bReader.readLine());
      List<Integer> list = new ArrayList<Integer>();

      String[] sArr = bReader.readLine().split("\\s");

      Integer[] iArr = new Integer[sArr.length];

      for (int q = 0; q < sArr.length; q++) {
        iArr[q] = Integer.parseInt(sArr[q]);
      }

      Integer ans = findSmall(iArr, 0, iArr.length-1, i);
      writer.print(ans);

      bReader.close();
      writer.close();
    } catch(IOException e) {
      System.err.println(e.getMessage());
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("index out of bounds");
      System.err.println(e.getMessage());
    }
  }


  public static Integer findSmall(Integer[] arr, Integer left, Integer right, Integer key) {
    if (key > 0 && key <= right - left + 1) {
      Integer POSITION = partition(arr, left, right);
      if (POSITION-left == key-1) { return arr[POSITION]; }
      if (POSITION-left > key-1) { return findSmall(arr, left, POSITION-1, key); }
      else { return findSmall(arr, POSITION+1, right, key-POSITION+left-1); }
    }
    return -1;
  }

   private static Integer partition(Integer[] a, Integer LOW, Integer HIGH) {
      Integer pivot = a[LOW];
      Integer i = LOW;
      Integer j = HIGH;

      while (true) {

        while (a[i] < pivot) i++;

        while (a[j] > pivot) j--;

        if (i >= j) {
          return j;
        }
        swap(a, i, j);
        i++;
        j--;

      }
    }

  public static void swap (Integer A[], Integer x, Integer y) {
      int temp = A[x];
      A[x] = A[y];
      A[y] = temp;
   }
}
