package lab2.model;

public class ComputerLab extends Room {
 String system;

    public void setSystem() {
        int n = (int) (Math.random() * 2);
        if (n == 1) {
            this.system = "Windows";
        } else {
            this.system = "Linux";
        }
    }

    /***
     *
     * @param name numele salii
     * @param capacity capacitatea salii
     */
    public ComputerLab(String name, int capacity) {
        this.name=name;
        this.capacity=capacity;
        this.type="ComputerLab";
         setSystem();
    }

    /***
     *
     * @return system - sistemul de operare al salii
     */
  public String getSystem()
  {
      return this.system;
  }

    @Override
    public String toString() {
        return "ComputerLab{" +
                "system='" + system + '\'' +
                '}';
    }
}
