public class Factorial {
  interface IFactorial {
    public long factorial(long n);
  }

  class FactorialRecursion implements IFactorial {
    public long factorial(long n) {
      if (n <= 1) return 1;
      else return n * factorial(n - 1);
    }
  }

  class FactorialIteration implements IFactorial {
    public long factorial(long n) {
      long fact = 1;

      for (long i = n; i > 0; --i) {
        fact = fact * i;
      }
      return fact;
    }
  }

  public void doIt(String[] args) {
    long n = 5;

    if (args.length == 1) {
      try {
        n = Long.parseLong(args[0]);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }
    System.out.println("Factorial (Recursion) of " + n + " = " + new FactorialRecursion().factorial(n));
    System.out.println("Factorial (Iteration) of " + n + " = " + new FactorialIteration().factorial(n));
  }

  public static void main(String[] args) {
    new Factorial().doIt(args);
  }
}
