import java.util.Hashtable;

public class Fibonacci {
  interface IFibonacci {
    public long fibonacci(long n);
  }

  class FibonacciRecursion implements IFibonacci {
    public long fibonacci(long n) {
      if (n <= 0) return 0;
      else if (n < 3) return 1;
      else return fibonacci(n-1) + fibonacci(n-2);
    }
  }

  class FibonacciIteration implements IFibonacci {
    public long fibonacci(long n) {
      long a = 0, fib = 0, b = 1;

      while (n-- > 0) {
        a = fib + b;
        fib = b;
        b = a;
      }
      return fib;
    }
  }

  class FibonacciRecursion2 implements IFibonacci {
    //uses dynamic programming
    Hashtable<Long,Long> hTable = null;

    {
      hTable = new Hashtable<Long,Long>();
    }

    public long fibonacci(long n) {
      long fib = 0;

      if (n <= 0) return 0;
      else if (n < 3) return 1;
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

  public void doIt(String[] args) {
    IFibonacci fibImpl[] = new IFibonacci[3];
    fibImpl[0] = new FibonacciRecursion();
    fibImpl[1] = new FibonacciIteration();
    fibImpl[2] = new FibonacciRecursion2();
    StringBuilder sb = new StringBuilder();
    long n = 5;

    if (args.length == 1) {
      try {
        n = Long.parseLong(args[0]);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }

    for (int i = 0; i < fibImpl.length; ++i) {
      sb.append("Fibonacci (");
      sb.append(fibImpl[i].getClass().getName());
      sb.append(") of ").append(n).append(" = ");
      sb.append(fibImpl[i].fibonacci(n));

      System.out.println(sb.toString());
      sb.delete(0, sb.length());
    }
  }

  public static void main(String[] args) {
    new Fibonacci().doIt(args);
  }
}
