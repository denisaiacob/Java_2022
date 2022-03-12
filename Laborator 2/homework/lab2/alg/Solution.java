package lab2.alg;

import lab2.model.Room;

public class Solution extends Algorithm{
    private Room[] assignment;
    private int count=0;

    public void incCount()
    {
        this.count+=1;
    }

    /***
     *
     * @param assignment ce sala primeste evenimentul cu indexul i
     */
    public void setAssignment(Room[] assignment) {
        for(int i=0;i<count;i++) assignment[i] = null;
    }

    /***
     *
     * @return salile ce nu au inca un eveniment atribuit
     */
    public int computeUsedRooms() {
        int k=0;
        int usedRooms[]=new int[count];
        for (int i = 0; i < count; i++) {
            if (assignment[i] != null) {
                k++;
                usedRooms[k]=i;
                return usedRooms[k];
            }
        }
      return 0;
    }

}