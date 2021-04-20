import java.util.Hashtable;

public class Fibonacci {
  Interface IFibonacci {
    public int fibonacci(int n);
  }
  
  class FibonacciRecursion implements IFibonacci {
    public int fibonacci(int n) {
      if (n < 3) return 1;
      else return fibonacci(n-1) + fibonacci(n-2);
    }
  }
  
  class FibonacciIteration implements IFibonacci {
    public int fibonacci(int n) {
      int fib = 0, a = 0, b = 1;
      
      while (n-- > 0) {
        fib = a + b;
        a = b;
        b = fib;
      }
      return fib;
    }
  }
  
  class FibonacciRecursion2 implements IFibonacci {
    //recursion with dynamic programming
    Hashtable<Integer,Integer> hTable = null;
    
    {
      hTable = new Hashtable<Integer,Integer>();
    }
    
    public int fibonacci(int n) {
      int fib = 0;
      
      if (n < 3) return 1;
      else {
        if (hTable.get(n) != null) fib = hTable.get(n);
        else {
          fib = fibonacci(n-1) + fibonacci(n-2);
          hTable.put(n,fib);
        }
        return fib;
      }
    }
  }
  
  public static void main(String[] args) {
    Fibonacci fr = null, fi = null, fr2 = null;
    int n = 5;
    
    fr = new FibonacciRecursion();
    fi = new FibonacciIteration();
    fr2 = new FibonacciRecursion2();
    
    if (args.length == 1) {
      try {
        n = Integer.parseInt(args[0]);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }
    
    System.out.println("Fibonacci (Recursion) of " + n + " = " + fr.fibonacci(n));
    System.out.println("Fibonacci (Iteration) of " + n + " = " + fi.fibonacci(n));
    System.out.println("Fibonacci (Recursion2) of " + n + " = " + fr2.fibonacci(n));
  }
}
