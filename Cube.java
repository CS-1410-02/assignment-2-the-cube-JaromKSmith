import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cube {
char r[][] =new char[3][3];
char b[][] =new char[3][3];
char o[][] =new char[3][3];
char g[][] =new char[3][3];
char y[][] =new char[3][3];
char w[][] =new char[3][3];

char temp[][] = new char[3][3];
char temp1[][] = new char[3][3];

public void initializeCube(){

  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      r[i][j] = 'r';
    }
  }

for(int i=0; i<3; i++){
for(int j=0; j<3; j++){
  b[i][j] = 'b';
}
}

for(int i=0; i<3; i++){
for(int j=0; j<3; j++){
  o[i][j] = 'o';
}
}

for(int i=0; i<3; i++){
for(int j=0; j<3; j++){
  g[i][j] = 'g';
}
}

for(int i=0; i<3; i++){
for(int j=0; j<3; j++){
  y[i][j] = 'y';
}
}

for(int i=0; i<3; i++){
for(int j=0; j<3; j++){
  w[i][j] = 'w';
}
}
}

  public void printCube(){
    //print out each of the faces on the cube in r|r|r \n r|r|r format

    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        System.out.print(r[i][j]);
        if(j<2){
          System.out.print("|");
        }
      }
      System.out.println();
    }
    System.out.println();

    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        System.out.print(b[i][j]);
        if(j<2){
          System.out.print("|");
        }
      }
      System.out.println();
    }
    System.out.println();

    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        System.out.print(o[i][j]);
        if(j<2){
          System.out.print("|");
        }
      }
      System.out.println();
    }
    System.out.println();

    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        System.out.print(g[i][j]);
        if(j<2){
          System.out.print("|");
        }
      }
      System.out.println();
    }
    System.out.println();

    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        System.out.print(y[i][j]);
        if(j<2){
          System.out.print("|");
        }
      }
      System.out.println();
    }
    System.out.println();

    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        System.out.print(w[i][j]);
        if(j<2){
          System.out.print("|");
        }
      }
      System.out.println();
    }
  }

  ArrayList<String> solution = new ArrayList<String>();


    // check to see if the cube is solved be comparing each peice to the center peice on the same side
  public boolean isSolved(){
    return isSolved(r) && isSolved(b) && isSolved(o) && isSolved(g) && isSolved(y);
  }
    public boolean isSolved(char[][] face){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
            if(face[i][j] != face[1][1]){
                return false;
            }
            }
        }
        return true;
    }
    // add the opposite move as the last one made to the beginning of the solution, this also clears the entire solutino if the cube is solved
    // or if two moves immediately cancel out it will remove the last move from the solution instead of adding a new one.
    public void addToSolution(String move){
        if(isSolved()){
            solution.clear();
        }else if(!solution.isEmpty() && solution.get(0).equals(move)){
            solution.remove(0);
        }else{
            if(move.length() == 1){
                solution.add(0,move+"'");
            }else{
                solution.add(0,move.substring(0,1));
            }
        }
    }
    public void printSolution(){
        System.out.print("Solution: ");
        if(isSolved()){
            System.out.print("Solved");
        }else{
            for(String s : solution){
                System.out.print(s + " ");
            }
            System.out.println("Moves to solve " + solution.size());
        }
      }

	public static void main(final String[] args) throws IOException{


    Cube cube = new Cube();
    //creating the cube and each of the sides.

    boolean proceed = true;
    //variable to keep program running until it is quit
    

cube.initializeCube();

boolean argsCheck = false;
if(args.length >0){
  argsCheck = true;
}
int argsRunIndex = 0;

if(!argsCheck)cube.printCube();

BufferedReader reader = new BufferedReader(
  new InputStreamReader(System.in));


String input;

//Double check the array values for the sides that are being rotated, some are opposite others

while(proceed){
  
  if(!argsCheck){
    input = reader.readLine();
  }else{
    if(argsRunIndex == args.length){
      argsCheck = false;
      cube.printCube();
      cube.printSolution();
      input = "q";
      proceed = false;
    }else{
      input = args[argsRunIndex];
      argsRunIndex++;
    }
  }
  boolean valid = true;
switch(input){
  case "u":
  //rotate the upper section of the cube clockwise, yellow facing up
  for(int i = 0; i<3; i++){
    cube.temp[0][i] = cube.b[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.b[0][i] = cube.r[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[0][i] = cube.o[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.o[0][i] = cube.temp[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp[0][i] = cube.g[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.g[0][i] = cube.temp1[0][i];
  }
  
  for(int i = 0; i<3; i++){
    cube.r[0][i] = cube.temp[0][i];
  }

  //rotate the positions of the yellow face
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      cube.temp[i][j] = cube.y[i][j];
    }
  }
  cube.y[0][0] = cube.temp[2][0];
  cube.y[0][1] = cube.temp[1][0];
  cube.y[0][2] = cube.temp[0][0];
  cube.y[1][0] = cube.temp[2][1];
  cube.y[1][2] = cube.temp[0][1];
  cube.y[2][0] = cube.temp[2][2];
  cube.y[2][1] = cube.temp[1][2];
  cube.y[2][2] = cube.temp[0][2];




  break;

//counterclockwise rotation for the upper side, yellow facing up
case "u'":
for(int i = 0; i<3; i++){
  cube.temp[0][i] = cube.b[0][i];
}
for(int i = 0; i<3; i++){
  cube.b[0][i] = cube.o[0][i];
}
for(int i = 0; i<3; i++){
  cube.temp1[0][i] = cube.r[0][i];
}
for(int i = 0; i<3; i++){
  cube.r[0][i] = cube.temp[0][i];
}
for(int i = 0; i<3; i++){
  cube.temp[0][i] = cube.g[0][i];
}
for(int i = 0; i<3; i++){
  cube.g[0][i] = cube.temp1[0][i];
}

for(int i = 0; i<3; i++){
  cube.o[0][i] = cube.temp[0][i];
}

//rotate the positions of the yellow face counterclockwise
for(int i=0; i<3; i++){
  for(int j=0; j<3; j++){
    cube.temp[i][j] = cube.y[i][j];
  }
}
cube.y[0][0] = cube.temp[0][2];
cube.y[0][1] = cube.temp[1][2];
cube.y[0][2] = cube.temp[2][2];
cube.y[1][0] = cube.temp[0][1];
cube.y[1][2] = cube.temp[2][1];
cube.y[2][0] = cube.temp[0][0];
cube.y[2][1] = cube.temp[1][0];
cube.y[2][2] = cube.temp[2][0];



break;


  case "d":
  //rotate the downward facing section clockwise, white facing down
  for(int i = 0; i<3; i++){
    cube.temp[2][i] = cube.b[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.b[2][i] = cube.o[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[2][i] = cube.r[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.r[2][i] = cube.temp[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp[2][i] = cube.g[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.g[2][i] = cube.temp1[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.o[2][i] = cube.temp[2][i];
  }

    //rotate the positions of the white face
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        cube.temp[i][j] = cube.w[i][j];
      }
    }
    cube.w[0][0] = cube.temp[2][0];
    cube.w[0][1] = cube.temp[1][0];
    cube.w[0][2] = cube.temp[0][0];
    cube.w[1][0] = cube.temp[2][1];
    cube.w[1][2] = cube.temp[0][1];
    cube.w[2][0] = cube.temp[2][2];
    cube.w[2][1] = cube.temp[1][2];
    cube.w[2][2] = cube.temp[0][2];
  


  break;

//rotates the downward facing side counterclockwise, white facing down.
case "d'":
  //rotate the downward facing section clockwise, white facing down
  for(int i = 0; i<3; i++){
    cube.temp[2][i] = cube.b[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.b[2][i] = cube.r[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[2][i] = cube.o[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.o[2][i] = cube.temp[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp[2][i] = cube.g[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.g[2][i] = cube.temp1[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.r[2][i] = cube.temp[2][i];
  }

//rotate the positions of the white face counterclockwise
for(int i=0; i<3; i++){
  for(int j=0; j<3; j++){
    cube.temp[i][j] = cube.w[i][j];
  }
}
cube.w[0][0] = cube.temp[0][2];
cube.w[0][1] = cube.temp[1][2];
cube.w[0][2] = cube.temp[2][2];
cube.w[1][0] = cube.temp[0][1];
cube.w[1][2] = cube.temp[2][1];
cube.w[2][0] = cube.temp[0][0];
cube.w[2][1] = cube.temp[1][0];
cube.w[2][2] = cube.temp[2][0];


break;

  case "r":
  //rotates the right facing section clockwise, red facing right
  for(int i = 0; i<3; i++){
    cube.temp[i][2] = cube.b[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.b[i][2] = cube.w[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[i][2] = cube.y[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.y[i][2] = cube.temp[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.temp[i][2] = cube.g[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.g[i][0] = cube.temp1[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.w[i][2] = cube.temp[i][2];
  }

    //rotate the positions of the red face
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        cube.temp[i][j] = cube.r[i][j];
      }
    }
    cube.r[0][0] = cube.temp[2][0];
    cube.r[0][1] = cube.temp[1][0];
    cube.r[0][2] = cube.temp[0][0];
    cube.r[1][0] = cube.temp[2][1];
    cube.r[1][2] = cube.temp[0][1];
    cube.r[2][0] = cube.temp[2][2];
    cube.r[2][1] = cube.temp[1][2];
    cube.r[2][2] = cube.temp[0][2];


  break;

//rotates the right facing side counterclockwise, red facing right
case "r'":

for(int i = 0; i<3; i++){
  cube.temp[i][2] = cube.b[i][2];
}
for(int i = 0; i<3; i++){
  cube.b[i][2] = cube.y[i][2];
}
for(int i = 0; i<3; i++){
  cube.temp1[i][2] = cube.w[i][2];
}
for(int i = 0; i<3; i++){
  cube.w[i][2] = cube.temp[i][2];
}
for(int i = 0; i<3; i++){
  cube.temp[i][2] = cube.g[i][0];
}
for(int i = 0; i<3; i++){
  cube.g[i][0] = cube.temp1[i][2];
}
for(int i = 0; i<3; i++){
  cube.y[i][2] = cube.temp[i][2];
}

  //rotate the positions of the red face counterclockwise
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      cube.temp[i][j] = cube.r[i][j];
    }
  }
  cube.r[0][0] = cube.temp[0][2];
  cube.r[0][1] = cube.temp[1][2];
  cube.r[0][2] = cube.temp[2][2];
  cube.r[1][0] = cube.temp[0][1];
  cube.r[1][2] = cube.temp[2][1];
  cube.r[2][0] = cube.temp[0][0];
  cube.r[2][1] = cube.temp[1][0];
  cube.r[2][2] = cube.temp[2][0];


break;


  case "l":
  //rotates the left facing side clockwise, orange facing left
  for(int i = 0; i<3; i++){
    cube.temp[i][0] = cube.b[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.b[i][0] = cube.y[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[i][0] = cube.w[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.w[i][0] = cube.temp[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.temp[i][0] = cube.g[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.g[i][2] = cube.temp1[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.y[i][0] = cube.temp[i][0];
  }

    //rotate the positions of the orange face
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        cube.temp[i][j] = cube.o[i][j];
      }
    }
    cube.o[0][0] = cube.temp[2][0];
    cube.o[0][1] = cube.temp[1][0];
    cube.o[0][2] = cube.temp[0][0];
    cube.o[1][0] = cube.temp[2][1];
    cube.o[1][2] = cube.temp[0][1];
    cube.o[2][0] = cube.temp[2][2];
    cube.o[2][1] = cube.temp[1][2];
    cube.o[2][2] = cube.temp[0][2];
  


  break;

  //rotates the left facing side counterclockwise, orange facing left
  case "l'":
  
  for(int i = 0; i<3; i++){
    cube.temp[i][0] = cube.b[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.b[i][0] = cube.w[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[i][0] = cube.y[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.y[i][0] = cube.temp[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.temp[i][0] = cube.g[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.g[i][2] = cube.temp1[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.w[i][0] = cube.temp[i][0];
  }

    //rotate the positions of the orange face counterclockwise
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        cube.temp[i][j] = cube.o[i][j];
      }
    }
    cube.o[0][0] = cube.temp[0][2];
    cube.o[0][1] = cube.temp[1][2];
    cube.o[0][2] = cube.temp[2][2];
    cube.o[1][0] = cube.temp[0][1];
    cube.o[1][2] = cube.temp[2][1];
    cube.o[2][0] = cube.temp[0][0];
    cube.o[2][1] = cube.temp[1][0];
    cube.o[2][2] = cube.temp[2][0];
  

  break;

  case "f":
  //rotates the front facing section clockwise, blue facing front
  for(int i = 0; i<3; i++){
    cube.temp[2][i] = cube.y[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.y[2][i] = cube.o[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[0][i] = cube.r[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.r[i][0] = cube.temp[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp[0][i] = cube.w[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.w[0][i] = cube.temp1[0][i];
  }
  
  for(int i = 0; i<3; i++){
    cube.o[i][2] = cube.temp[0][i];
  }

  //rotate the positions of the blue face
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      cube.temp[i][j] = cube.b[i][j];
    }
  }
  cube.b[0][0] = cube.temp[2][0];
  cube.b[0][1] = cube.temp[1][0];
  cube.b[0][2] = cube.temp[0][0];
  cube.b[1][0] = cube.temp[2][1];
  cube.b[1][2] = cube.temp[0][1];
  cube.b[2][0] = cube.temp[2][2];
  cube.b[2][1] = cube.temp[1][2];
  cube.b[2][2] = cube.temp[0][2];

  break;


  case "f'":
  //rotates the front facing section counterclockwise, blue facing front
  for(int i = 0; i<3; i++){
    cube.temp[2][i] = cube.y[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.y[2][i] = cube.r[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[0][i] = cube.o[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.o[i][2] = cube.temp[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp[0][i] = cube.w[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.w[0][i] = cube.temp1[0][i];
  }
  
  for(int i = 0; i<3; i++){
    cube.r[i][0] = cube.temp[0][i];
  }

  //rotate the positions of the blue face counterclockwise
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      cube.temp[i][j] = cube.b[i][j];
    }
  }
  cube.b[0][0] = cube.temp[0][2];
  cube.b[0][1] = cube.temp[1][2];
  cube.b[0][2] = cube.temp[2][2];
  cube.b[1][0] = cube.temp[0][1];
  cube.b[1][2] = cube.temp[2][1];
  cube.b[2][0] = cube.temp[0][0];
  cube.b[2][1] = cube.temp[1][0];
  cube.b[2][2] = cube.temp[2][0];


  break;

  case "b":
  //rotates the back facing section clockwise, green facing back
  for(int i = 0; i<3; i++){
    cube.temp[0][i] = cube.y[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.y[0][i] = cube.r[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[2][i] = cube.o[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.o[i][0] = cube.temp[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp[2][i] = cube.w[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.w[2][i] = cube.temp1[2][i];
  }
  
  for(int i = 0; i<3; i++){
    cube.r[i][2] = cube.temp[2][i];
  }

  //rotate the positions of the green face
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      cube.temp[i][j] = cube.g[i][j];
    }
  }
  cube.g[0][0] = cube.temp[2][0];
  cube.g[0][1] = cube.temp[1][0];
  cube.g[0][2] = cube.temp[0][0];
  cube.g[1][0] = cube.temp[2][1];
  cube.g[1][2] = cube.temp[0][1];
  cube.g[2][0] = cube.temp[2][2];
  cube.g[2][1] = cube.temp[1][2];
  cube.g[2][2] = cube.temp[0][2];

  break;

  case "b'":
  //rotates the back facing section counterclockwise, green facing back
  for(int i = 0; i<3; i++){
    cube.temp[0][i] = cube.y[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.y[0][i] = cube.o[i][0];
  }
  for(int i = 0; i<3; i++){
    cube.temp1[2][i] = cube.r[i][2];
  }
  for(int i = 0; i<3; i++){
    cube.r[i][2] = cube.temp[0][i];
  }
  for(int i = 0; i<3; i++){
    cube.temp[2][i] = cube.w[2][i];
  }
  for(int i = 0; i<3; i++){
    cube.w[2][i] = cube.temp1[2][i];
  }
  
  for(int i = 0; i<3; i++){
    cube.o[i][0] = cube.temp[2][i];
  }

  //rotate the positions of the green face
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      cube.temp[i][j] = cube.g[i][j];
    }
  }
  cube.g[0][0] = cube.temp[0][2];
  cube.g[0][1] = cube.temp[1][2];
  cube.g[0][2] = cube.temp[2][2];
  cube.g[1][0] = cube.temp[0][1];
  cube.g[1][2] = cube.temp[2][1];
  cube.g[2][0] = cube.temp[0][0];
  cube.g[2][1] = cube.temp[1][0];
  cube.g[2][2] = cube.temp[2][0];

  break;

  case "q":
  //quits the program
  proceed= false;
  valid = false;
  break;

  default:
  System.out.println("Please Enter a valid move");
  valid = false;
  break;
  }
  if(valid){
    cube.addToSolution(input);
    if(!argsCheck){
        cube.printCube();
        cube.printSolution();
    }
  }

}
}
}
