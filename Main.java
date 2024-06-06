import java.util.Scanner;

class MyProgram {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("what type of cube? 2x2 or 3x3?");
    int type = 0;
    String res = "";
    while(type == 0) {
      res = scan.nextLine();
      if(res.equals("2x2"))
        type = 24;
      else if(res.equals("3x3"))
        type = 54;
    }
    String solved[] = new String[] {"y","y","y","y","o","o","o","o","b","b","b","b","r","r","r","r","g","g","g","g","w","w","w","w","y","y","y","y","o","o","o","o","b","b","b","b","r","r","r","r","g","g","g","g","w","w","w","w","y","o","b","r","g","w"};
    ThreeByThree cube3 = new ThreeByThree(solved);
    TwoByTwo cube2 = new TwoByTwo(solved);  
    System.out.println("how would you like to enter the scramble? (moves, colors, or random?)");
    String ans = "";
    while(!ans.equals("moves") && !ans.equals("colors") && !ans.equals("solved") && !ans.equals("random")) {
      ans = scan.nextLine();
    }
    if(ans.equals("colors")){
      if(type == 54)
        cube3.setColors();
    }
    if(ans.equals("moves")){
      System.out.println("type the scramble");
      String scra = scan.nextLine();
      System.out.println("type the orientation of the cube (top,front)");
      String ort = scan.nextLine();
      if(type == 54)
        cube3.setScramble(scra, ort);
      else
        cube2.scrambleCube(scra, ort);
    }
    if(ans.equals("random")){
      System.out.println("how many moves?");
      int num = scan.nextInt();
      System.out.println(cube3.randomScramble(num));
    }
    if(type == 54){
      System.out.println(cube3);
      cube3.solveCube();
      System.out.println(cube3);
    }
    else if(type == 24){
      System.out.println(cube2);
      cube2.solveCube();
      System.out.println(cube2);
    }
  }
}