import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String solved[] = new String[] {"y","y","y","y","o","o","o","o","b","b","b","b","r","r","r","r","g","g","g","g","w","w","w","w","y","y","y","y","o","o","o","o","b","b","b","b","r","r","r","r","g","g","g","g","w","w","w","w","y","o","b","r","g","w"};
    ThreeByThree cube3 = new ThreeByThree(solved); 
    System.out.println("how would you like to enter the scramble? (moves, colors, or random?)");
    String ans = "";
    while(!ans.equals("moves") && !ans.equals("colors") && !ans.equals("solved") && !ans.equals("random")) {
      ans = scan.nextLine();
    }
    if(ans.equals("colors")){
        cube3.setColors();
    }
    if(ans.equals("moves")){
      System.out.println("type the scramble");
      String scra = scan.nextLine();
      System.out.println("type the orientation of the cube (top,front)");
      String ort = scan.nextLine();
        cube3.setScramble(scra, ort);
    }
    if(ans.equals("random")){
      System.out.println("how many moves would you like the scramble to be?");
      int num = scan.nextInt();
      System.out.println(cube3.randomScramble(num));
    }
    System.out.println(cube3);
    cube3.solveCube();
    System.out.println(cube3);
  }
}
