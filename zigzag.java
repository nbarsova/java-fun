public class HelloWorld
{
  public static void main(String[] args)
  {
  Matrix myMatrix = new Matrix (10);
  myMatrix.zigzag();
  }
}

public class Matrix
{
  private int dimension = 0;
  private int [][] matrix;

  public Matrix(int dim)
  {

  dimension = dim;
  matrix = new int[dimension][dimension];

  int counter=0;
  for (int i=0; i<dimension; i++)
  {
  for (int j = 0; j<dimension; j++)
  {
  matrix[i][j] = counter;
  counter++;
  }
  }
  }

  public void zigzag ()
  {
  if (matrix == null)

  {
  System.out.println("Not initialized!");
  }

  else {
  for (int i=0; i<dimension; i++)
  {
  if (i%2==0)
  {
  for (int j=0; j<dimension; j++)
  {
  System.out.print("Matrix["+i+"]["+j+"]="+matrix[i][j]+" ");
  }
  System.out.println("");

  }

  else

  {
  for (int j=dimension-1; j>=0; j--)
  {
  System.out.print("Matrix["+i+"]["+j+"]="+matrix[i][j]+" ");
  }
  System.out.println("");
  }
  }
  }
  }

}
