package Dodatkowe.Nauka;

public class Pr_1 {
       
        public static int silnia(int n){
                if ( n < 2 ) return 1;
                return n*silnia(n-1);  
        }
       
        public static void main(String[] args) {
               
                int n;
               
                try{
                        n = Integer.parseInt(args[0]);
                } catch(Exception e) {
                        n = 1;
                }
               
                int wynikSilni = silnia(n);
                System.out.println(wynikSilni);
               
        }
 
}