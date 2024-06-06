import java.util.Scanner;

public class ThreeByThree {
  private String[] color;

  public ThreeByThree(String[] scramble){
    color = scramble;   
  }
  
  public String toString() {
    String colorString = "";
    for(int i = 0; i < 54; i++) {
      if(i % 4 == 0 && i < 52)
        colorString += " " + color[i] + " ";
      else
        colorString += color[i]+" ";
      if(i == 23 || i == 47)
        colorString += "\n";
    }
    return colorString;
  }

    public void solveCube() {
      //orient cube
      while(!color[53].equals("w")) {
        cubeRotate("x", 1);
        if(color[53].equals("w"))
          break;
        cubeRotate("z", 1);
      }
      while(!color[50].equals("b"))
        cubeRotate("y", 1);
      System.out.println("\nhold the cube so white is on the bottom and blue is on the front");

      //daisy
      int turns = 0;
      int rots = 0;
      System.out.println("daisy");
      while(!(color[44].equals("w") && color[45].equals("w") && color[46].equals("w") && color[47].equals("w")) && !(color[30].equals(color[49]) && color[34].equals(color[50]) && color[38].equals(color[51]) && color[42].equals(color[52]))) {
        for(int i = 0; i < 2; i++) {
          for(int j = 0; j < 4; j++) {
            while(color[33].equals("w") || color[43].equals("w") || color[45].equals("w")) {
              while(color[25].equals("w"))
                System.out.print(faceRotate("u", 1) + " ");
              if(color[33].equals("w"))
                System.out.println("\n" + faceRotate("r", 1));
              else if(color[43].equals("w"))
                System.out.println("\n" + faceRotate("r", 3));
              else if(color[45].equals("w"))
                System.out.println("\n" + faceRotate("r", 2)); 
            }
            if(!(color[24].equals("w") && color[25].equals("w") && color[26].equals("w") && color[27].equals("w")))
              System.out.print(cubeRotate("y", 3) + " ");
          }
          if(color[28].equals("w") || color[30].equals("w")){
            while(color[27].equals("w"))
              System.out.println(faceRotate("u", 1));
            System.out.println(faceRotate("l", 1));
          }
          if(color[36].equals("w") || color[38].equals("w")){
            while(color[25].equals("w"))
              System.out.println(faceRotate("u", 1));
            System.out.println(faceRotate("r", 1));
          }
          if(color[32].equals("w") || color[34].equals("w")){
            while(color[26].equals("w"))
              System.out.println(faceRotate("u", 1));
            System.out.println(faceRotate("f", 1));
          }
          if(color[40].equals("w") || color[42].equals("w")){
            while(color[24].equals("w"))
              System.out.println(faceRotate("u", 1));
            System.out.println(faceRotate("b", 1));
          }
        }
      
      //white cross
      System.out.println("\nwhite cross");
      for(int si = 0; si < 4; si++) {
        if(!color[24].equals("w") && !color[25].equals("w") && !color[26].equals("w") && !color[27].equals("w"))
          break;
        if(color[28].equals(color[49]) && color[27].equals("w"))
          System.out.println(faceRotate("l", 2));
        if(color[32].equals(color[50]) && color[26].equals("w"))
          System.out.println(faceRotate("f", 2));
        if(color[36].equals(color[51]) && color[25].equals("w"))
          System.out.println(faceRotate("r", 2));
        if(color[40].equals(color[52]) && color[24].equals("w"))
          System.out.println(faceRotate("b", 2));
        System.out.print(faceRotate("u", 1) + " ");
      }
      faceRotate("u", 3);
      }
      //white corners
      System.out.println("\b\b  \nwhite corners");
      turns = 0;
      while((!color[20].equals("w") || !color[21].equals("w") || !color[22].equals("w") || !color[23].equals("w")) || !(color[6].equals(color[49]) && color[10].equals(color[50]) && color[14].equals(color[51]) && color[18].equals(color[52]))) {
        turns = 0;
        while(!color[2].equals("w") && !color[9].equals("w") && !color[12].equals("w") && turns < 4){
          faceRotate("u", 3);
          turns++;
        }
        if(turns == 1)
          System.out.println("U'");
        else if(turns == 2)
          System.out.println("U2");
        else if(turns == 3)
          System.out.println("U");
        else if(turns == 4){
          while(color[21].equals("w") && color[10].equals(color[50]))
            System.out.println(cubeRotate("y", 1));
          System.out.print(faceRotate("r", 1) + " ");
          System.out.print(faceRotate("u", 1) + " ");
          System.out.print(faceRotate("r", 3) + " ");
          System.out.println(faceRotate("u", 3));
        }
        turns = 4;
        while(!(color[34].equals(color[2]) || color[34].equals(color[9]) || color[34].equals(color[12])) || !(color[38].equals(color[2]) || color[38].equals(color[9]) || color[38].equals(color[12]))) {
          System.out.print(faceRotate("d", 1) + " ");
          turns--;
        }
        System.out.println();
        if(color[2].equals("w") || color[12].equals("w")){
          while(!color[10].equals(color[34]) || !color[21].equals("w") || !color[15].equals(color[38])){
            System.out.print("(" + faceRotate("r", 1) + " ");
            System.out.print(faceRotate("u", 1) + " ");
            System.out.print(faceRotate("r", 3) + " ");
            System.out.println(faceRotate("u", 3) + ")");
          }
        }
        else if(color[9].equals("w")){
          while(!color[10].equals(color[34]) || !color[21].equals("w") || !color[15].equals(color[38])){
          System.out.print("(" + faceRotate("u", 1) + " ");
          System.out.print(faceRotate("r", 1) + " ");
          System.out.print(faceRotate("u", 3) + " ");
          System.out.println(faceRotate("r", 3) + ")");
          }
        }
        if(turns != 4)
          System.out.println(faceRotate("d", turns));
      }
      
      //2nd layer
      System.out.println("\n2nd layer");
      while(!(color[29].equals(color[49]) && color[31].equals(color[49]) && color[33].equals(color[50]) && color[35].equals(color[50]) && color[37].equals(color[51]) && color[39].equals(color[51]) && color[41].equals(color[52]) && color[43].equals(color[52]))) {
      
        while(!((color[24].equals("y") || color[40].equals("y")) && (color[25].equals("y") || color[36].equals("y")) &&                               (color[26].equals("y") || color[32].equals("y")) && (color[27].equals("y") || color[28].equals("y")))) {
          if(color[40].equals(color[52]) && !color[24].equals("y"))
            System.out.println(cubeRotate("y", 2));
          else if(color[36].equals(color[51]) && !color[25].equals("y"))
            System.out.println(cubeRotate("y", 1));
          else if(color[32].equals(color[50]) && !color[26].equals("y")) {}
          else if(color[28].equals(color[49]) && !color[27].equals("y"))
            System.out.print("\n" + cubeRotate("y", 3));
          else{
            System.out.print(faceRotate("u", 1) + " ");
            continue;
          }
          if(color[26].equals(color[49])) {
            System.out.print("\n" + faceRotate("u", 3) + " ");
            System.out.print(faceRotate("l", 3) + " ");
            System.out.print(faceRotate("u", 3) + " ");
            System.out.print(faceRotate("l", 1) + " ");
            System.out.print(faceRotate("u", 1) + " ");
            System.out.print(faceRotate("f", 1) + " ");
            System.out.print(faceRotate("u", 1) + " ");
            System.out.println(faceRotate("f", 3));
          }
          else {
            System.out.print("\n" + faceRotate("u", 1) + " ");
            System.out.print(faceRotate("r", 1) + " ");
            System.out.print(faceRotate("u", 1) + " ");
            System.out.print(faceRotate("r", 3) + " ");
            System.out.print(faceRotate("u", 3) + " ");
            System.out.print(faceRotate("f", 3) + " ");
            System.out.print(faceRotate("u", 3) + " ");
            System.out.println(faceRotate("f", 1));
          }
        }
        if(!(color[29].equals(color[49]) && color[31].equals(color[49]) && color[33].equals(color[50]) && color[35].equals(color[50]) && color[37].equals(color[51]) && color[39].equals(color[51]) && color[41].equals(color[52]) && color[43].equals(color[52]))){
          while(color[33].equals(color[50]))
            System.out.println(cubeRotate("y", 1));
          System.out.print(faceRotate("r", 1) + " ");
          System.out.print(faceRotate("u", 1) + " ");
          System.out.print(faceRotate("r", 3) + " ");
          System.out.print(faceRotate("u", 3) + " ");
          System.out.print(faceRotate("f", 3) + " ");
          System.out.print(faceRotate("u", 3) + " ");
          System.out.println(faceRotate("f", 1));
        }
      }

      //orient edges
      System.out.println("\norient edges");
      turns = 0;
      while(!(color[24].equals("y") && color[25].equals("y") && color[26].equals("y") && color[27].equals("y"))) {
      while((!color[27].equals("y") || color[26].equals("y")) && turns < 3){
        System.out.println(faceRotate("u", 1));
        turns++;
      }
      if(!color[25].equals("y")){
        System.out.print(faceRotate("f", 1) + " ");
        System.out.print(faceRotate("u", 1) + " ");
        System.out.print(faceRotate("r", 1) + " ");
        System.out.print(faceRotate("u", 3) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.println(faceRotate("f", 3));
      }
      if(!color[27].equals("y"))
        System.out.println(faceRotate("u", 1));
      if(!color[24].equals("y")){
        System.out.print(faceRotate("f", 1) + " ");
        System.out.print(faceRotate("r", 1) + " ");
        System.out.print(faceRotate("u", 1) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.print(faceRotate("u", 3) + " ");
        System.out.println(faceRotate("f", 3));
      }
      }
      //orient corners
      System.out.println("\norient corners");
      System.out.println(cubeRotate("x", 2));
      while(!color[20].equals("y") || !color[21].equals("y") ||
            !color[22].equals("y") || !color[23].equals("y")) {
        while(color[21].equals("y"))
          System.out.println(faceRotate("d", 1));
        if(color[15].equals("y")){
          while(!color[21].equals("y")){
            System.out.print("(" + faceRotate("r", 1) + " ");
            System.out.print(faceRotate("u", 1) + " ");
            System.out.print(faceRotate("r", 3) + " ");
            System.out.println(faceRotate("u", 3) + ")");
          }
        }
        else if(color[10].equals("y")){
          for(int times = 0; times < 2; times++){
            System.out.print("(" + faceRotate("u", 1) + " ");
            System.out.print(faceRotate("r", 1) + " ");
            System.out.print(faceRotate("u", 3) + " ");
            System.out.println(faceRotate("r", 3) + ")");
          }
        }
      }
      System.out.println(cubeRotate("x", 2));
      //permute corners
      System.out.println("\npermute corners");
      int bars = 0;
      if(color[4].equals(color[5]))
        bars++;
      if(color[8].equals(color[9]))
        bars++;
      if(color[12].equals(color[13]))
        bars++;
      if(color[16].equals(color[17]))
        bars++;
      if(bars == 0){
        System.out.print(faceRotate("f", 1) + " ");
        System.out.print(faceRotate("r", 1) + " ");
        System.out.print(faceRotate("u", 3) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.print(faceRotate("u", 3) + " ");
        System.out.print(faceRotate("r", 1) + " ");
        System.out.print(faceRotate("u", 1) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.print(faceRotate("f", 3) + " ");
        System.out.print(faceRotate("r", 1) + " ");
        System.out.print(faceRotate("u", 1) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.print(faceRotate("u", 3) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.print(faceRotate("f", 1) + " ");
        System.out.print(faceRotate("r", 1) + " ");
        System.out.println(faceRotate("f", 3) + " (y perm)");
      }
      if(bars == 1){
        turns = 0;
        while(!color[4].equals(color[5])){
          faceRotate("u", 3);
          turns++;
        }
        if(turns == 1)
          System.out.println("U'");
        else if(turns == 2)
          System.out.println("U2");
        else if(turns == 3)
          System.out.println("U");
        System.out.print(faceRotate("r", 1) + " ");
        System.out.print(faceRotate("u", 1) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.print(faceRotate("u", 3) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.print(faceRotate("f", 1) + " ");
        System.out.print(faceRotate("r", 2) + " ");
        System.out.print(faceRotate("u", 3) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.print(faceRotate("u", 3) + " ");
        System.out.print(faceRotate("r", 1) + " ");
        System.out.print(faceRotate("u", 1) + " ");
        System.out.print(faceRotate("r", 3) + " ");
        System.out.println(faceRotate("f", 3) + " (t perm)");
      }
      turns = 0;
      while(!color[4].equals(color[7])){
        faceRotate("u", 3);
        turns++;
      }
      if(turns == 1)
        System.out.println("U'");
      else if(turns == 2)
        System.out.println("U2");
      else if(turns == 3)
        System.out.println("U");

      //permute edges
      System.out.println("\npermute edges");
      while(!color[4].equals(color[49]))
        System.out.println(faceRotate("u", 1));
      while(!color[32].equals(color[8]) || !color[5].equals(color[28])) {
        turns = 0;
        while(!color[40].equals(color[16]) && turns < 3){
          System.out.print(cubeRotate("y", 1) + " ");
          turns++;
        }
        if(color[36].equals(color[49])){
          System.out.print("\n" + faceRotate("r", 1) + " ");
          System.out.print(faceRotate("u", 3) + " ");
          System.out.print(faceRotate("r", 1) + " ");
          System.out.print(faceRotate("u", 1) + " ");
          System.out.print(faceRotate("r", 1) + " ");
          System.out.print(faceRotate("u", 1) + " ");
          System.out.print(faceRotate("r", 1) + " ");
          System.out.print(faceRotate("u", 3) + " ");
          System.out.print(faceRotate("r", 3) + " ");
          System.out.print(faceRotate("u", 3) + " ");
          System.out.println(faceRotate("r", 2));
        }
        else{
          System.out.print("\n" + faceRotate("r", 2) + " ");
          System.out.print(faceRotate("u", 1) + " ");
          System.out.print(faceRotate("r", 1) + " ");
          System.out.print(faceRotate("u", 1) + " ");
          System.out.print(faceRotate("r", 3) + " ");
          System.out.print(faceRotate("u", 3) + " ");
          System.out.print(faceRotate("r", 3) + " ");
          System.out.print(faceRotate("u", 3) + " ");
          System.out.print(faceRotate("r", 3) + " ");
          System.out.print(faceRotate("u", 1) + " ");
          System.out.println(faceRotate("r", 3));
        }
      }
    }

    public String faceRotate(String face, int numTurns) {
      face = face.toLowerCase();
      String a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x;        
      String A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X;
      String uf,lf,ff,rf,bf,df;
      for(int turn = 1; turn <= numTurns; turn++) {
        a = color[0];
        b = color[1];
        c = color[2];
        d = color[3];
        e = color[4];
        f = color[5];
        g = color[6];
        h = color[7];
        i = color[8];
        j = color[9];
        k = color[10];
        l = color[11];
        m = color[12];
        n = color[13];
        o = color[14];
        p = color[15];
        q = color[16];
        r = color[17];
        s = color[18];
        t = color[19];
        u = color[20];
        v = color[21];
        w = color[22];
        x = color[23];
        A = color[24];
        B = color[25];
        C = color[26];
        D = color[27];
        E = color[28];
        F = color[29];
        G = color[30];
        H = color[31];
        I = color[32];
        J = color[33];
        K = color[34];
        L = color[35];
        M = color[36];
        N = color[37];
        O = color[38];
        P = color[39];
        Q = color[40];
        R = color[41];
        S = color[42];
        T = color[43];
        U = color[44];
        V = color[45];
        W = color[46];
        X = color[47];
        uf = color[48];
        lf = color[49];
        ff = color[50];
        rf = color[51];
        bf = color[52];
        df = color[53];
        

        if(face.equals("u")){
          color[0] = d;
          color[1] = a;
          color[2] = b;
          color[3] = c;
          color[4] = i;
          color[5] = j;
          color[8] = m;
          color[9] = n;
          color[12] = q;
          color[13] = r;
          color[16] = e;
          color[17] = f;
          color[24] = D;
          color[25] = A;
          color[26] = B;
          color[27] = C;
          color[28] = I;
          color[32] = M;
          color[36] = Q;
          color[40] = E;
        }
        if(face.equals("d")){
          color[6] = s;
          color[7] = t;
          color[10] = g;
          color[11] = h;
          color[14] = k;
          color[15] = l;
          color[18] = o;
          color[19] = p;
          color[20] = x;
          color[21] = u;
          color[22] = v;
          color[23] = w;
          color[30] = S;
          color[34] = G;
          color[38] = K;
          color[42] = O;
          color[44] = X;
          color[45] = U;
          color[46] = V;
          color[47] = W;
        }
        if(face.equals("r")){
          color[1] = j;
          color[2] = k;
          color[9] = v;
          color[10] = w;
          color[12] = p;
          color[13] = m;
          color[14] = n;
          color[15] = o;
          color[16] = c;
          color[19] = b;
          color[21] = t;
          color[22] = q;
          color[25] = J;
          color[33] = V;
          color[36] = P;
          color[37] = M;
          color[38] = N;
          color[39] = O;
          color[43] = B;
          color[45] = T;
        }
        if(face.equals("l")){
          cubeRotate("y", 2);
          faceRotate("r", 1);
          cubeRotate("y", 2);
        }
        if(face.equals("f")){
          cubeRotate("y", 3);
          faceRotate("r", 1);
          cubeRotate("y", 1);
        }
        if(face.equals("b")){
          cubeRotate("y", 1);
          faceRotate("r", 1);
          cubeRotate("y", 3);
        }
        if(face.equals("m")){
          color[24] = S;
          color[26] = Q;
          color[32] = A;
          color[34] = C;
          color[40] = W;
          color[42] = U;
          color[43] = T;
          color[44] = I;
          color[46] = K;
          color[48] = bf;
          color[50] = uf;
          color[52] = df;
          color[53] = ff;
        }
        if(face.equals("e")){
          color[29] = R;
          color[31] = T;
          color[33] = F;
          color[35] = H;
          color[37] = J;
          color[39] = L;
          color[41] = N;
          color[43] = P;
          color[49] = bf;
          color[50] = lf;
          color[51] = ff;
          color[52] = rf;
        }
        if(face.equals("s")){
          color[25] = E;
          color[27] = G;
          color[28] = X;
          color[30] = V;
          color[36] = D;
          color[38] = B;
          color[45] = M;
          color[47] = O;
          color[48] = lf;
          color[49] = df;
          color[51] = uf;
          color[53] = rf;
        }
      }
        face = face.toUpperCase();
        if(numTurns == 3) {
          return face + "'";
        }
        else if(numTurns == 2) {
          return face + "2";
        }
        else {
          return face;
        }
      }
    

    public String cubeRotate(String axis, int numRots){
      for(int itr = 0; itr < numRots; itr++){
        if(axis.equals("y")){
          faceRotate("u", 1);
          faceRotate("d", 3);
          faceRotate("e", 3);
        }
        if(axis.equals("x")){
          faceRotate("r", 1);
          faceRotate("l", 3);
          faceRotate("m", 3);
        }
        if(axis.equals("z")){
          faceRotate("f", 1);
          faceRotate("b", 3);
          faceRotate("s", 1);
        }
      }
      axis = axis.toUpperCase();
        if(numRots == 3){
          return axis + "'";
        }
        else if(numRots == 2) {
          return axis + "2";
        }
        else {
          return axis;
        }
      }

    public void setScramble(String moves, String orient) {
      while(!color[48].equals(orient.substring(0,1))) {
        cubeRotate("x", 1);
        if(color[48].equals(orient.substring(0,1)))
          break;
        cubeRotate("z", 1);
      }
        while(!color[50].equals(orient.substring(orient.indexOf(",") + 1, orient.indexOf(",") + 2)))
        cubeRotate("y", 1);
      moves += " ";
      for(int m = 0; m < moves.length(); m += 2) {
        String move = moves.substring(m,m+2).toLowerCase();
        if(move.indexOf("'") != -1){
          faceRotate(move.substring(0,1), 3);
          m++;
        }  
        else if(move.indexOf("2") != -1) {
          faceRotate(move.substring(0,1), 2);
          m++;
        }
        else
          faceRotate(move.trim(), 1);
      }
    }
    public String randomScramble(int numMoves) {
      String scramble = "";
      int lastCount = -1;
      for(int i = 0; i < numMoves; i++) {
        int count = (int) (Math.random() * 6);
        if(count == lastCount){
          i--;
          continue;
        }
        lastCount = count;
        String face = "";
        if(count == 0)
          face = "U";
        else if(count == 1)
          face = "D";
        else if(count == 2)
          face = "R";
        else if(count == 3)
          face = "L";
        else if(count == 4)
          face = "F";
        else if(count == 5)
          face = "B";
        count = (int) (Math.random() * 3) + 1;
        scramble += faceRotate(face, count) + " ";
      }
      return scramble;
    }
    public void setColors() {
    Scanner scan = new Scanner(System.in);
    System.out.println("type the colors");
    String scra = scan.nextLine();
    String scramble[] = new String[54];
    for(int i = 0; i < 54; i++)
      scramble[i] = scra.substring(i,i+1);
    color[0] = scramble[0];
    color[1] = scramble[2];
    color[2] = scramble[8];
    color[3] = scramble[6];
    color[4] = scramble[9];
    color[5] = scramble[11];
    color[6] = scramble[17];
    color[7] = scramble[15];
    color[8] = scramble[18];
    color[9] = scramble[20];
    color[10] = scramble[26];
    color[11] = scramble[24];
    color[12] = scramble[27];
    color[13] = scramble[29];
    color[14] = scramble[35];
    color[15] = scramble[33];
    color[16] = scramble[36];
    color[17] = scramble[38];
    color[18] = scramble[44];
    color[19] = scramble[42];
    color[20] = scramble[45];
    color[21] = scramble[47];
    color[22] = scramble[53];
    color[23] = scramble[51];
    color[24] = scramble[1];
    color[25] = scramble[5];
    color[26] = scramble[7];
    color[27] = scramble[3];
    color[28] = scramble[10];
    color[29] = scramble[14];
    color[30] = scramble[16];
    color[31] = scramble[12];
    color[32] = scramble[19];
    color[33] = scramble[23];
    color[34] = scramble[25];
    color[35] = scramble[21];
    color[36] = scramble[28];
    color[37] = scramble[32];
    color[38] = scramble[34];
    color[39] = scramble[30];
    color[40] = scramble[37];
    color[41] = scramble[41];
    color[42] = scramble[43];
    color[43] = scramble[39];
    color[44] = scramble[46];
    color[45] = scramble[50];
    color[46] = scramble[52];
    color[47] = scramble[48];
    color[48] = scramble[4];
    color[49] = scramble[13];
    color[50] = scramble[22];
    color[51] = scramble[31];
    color[52] = scramble[40];
    color[53] = scramble[49];    
  }
}