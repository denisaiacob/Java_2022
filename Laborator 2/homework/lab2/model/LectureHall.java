package lab2.model;

public class LectureHall extends Room {
 String projector;

 public void setProjector() {
  int n = (int) (Math.random() * 2);
  if(n==1) {
   this.projector = "DA";
  }
   else
  {
   this.projector="NU";
  }
 }

 /***
  *
  * @param name numele salii de curs
  * @param capacity salii de curs
  */
 public LectureHall(String name, int capacity ) {
  this.name=name;
  this.capacity=capacity;
  this.type="LectureHall";
  setProjector();
 }

 /***
  *
  * @return daca are videoproiector sau nu
  */
 public String getProjector()
 {
    return this.projector;
 }

 @Override
 public String toString() {
  return "LectureHall{" +
          "projector='" + projector + '\'' +
          '}';
 }
}


