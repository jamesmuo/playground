public class Factorial {
  Interface IFactorial {
    public int factorial(int n);
  }
  
  class FactorialRecursion implements IFactorial {
    public int factorial(int n) {
      if (n <= 1) return 1;
      else return n * factorial(n - 1);
    }
  }
  
  class FactorialIteration implements IFactorial {
    public int factorial(int n) {
      int fact = 1;
      
      for (int i = n; i > 0; --i) {
        fact = fact * i;
      }
      return fact;
    }
  }  
  
  public static void main(String[] args) {
    Factorial fr = null, fi = null;
    int n = 5;
    
    fr = new FactorialRecursion();
    fi = new FactorialIteration();
    
    if (args.length == 1) {
      try {
        n = Integer.parseInt(args[0]);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }
        
    System.out.println("Factorial (Recursion) of " + n + " = " + fr.factorial(n));
    System.out.println("Factorial (Iteration) of " + n + " = " + fi.factorial(n));
  }
}
