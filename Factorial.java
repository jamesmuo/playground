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
    IFactorial factImpl[] = new IFactorial[2];
    factImpl[0] = new FactorialRecursion();
    factImpl[1] = new FactorialIteration();
    StringBuilder sb = new StringBuilder();
    long n = 5;

    if (args.length == 1) {
      try {
        n = Long.parseLong(args[0]);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }
    for (int i = 0; i < factImpl.length; ++i) {
      sb.append("Factorial (");
      sb.append(factImpl[i].getClass().getName());
      sb.append(") of ").append(n).append(" = ");
      sb.append(factImpl[i].factorial(n));

      System.out.println(sb.toString());
      sb.delete(0, sb.length());
    }
  }

  public static void main(String[] args) {
    new Factorial().doIt(args);
  }
}
