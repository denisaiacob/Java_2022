package lab2.model;

public class Event {

    private String name;
    private int size;
    private int start;
    private int end;

    public Event(){}

    /***
     *
     * @param name numele evenimentului
     * @param size nmarul maxim de persoane
     * @param start ora la care incepe evenimentul
     * @param end ora la care se termina evenimentul
     */
    public void addEvent(String name,int size,int start,int end){
       this.name=name;
       this.size=size;
       this.start=start;
       this.end=end;
    }

    public void setSize(int size) {
        this.size=size;
    }
    public void setInterval(int start,int end){
        this.start=start;
        this.end=end;
    }
    public void setName(String name){

        this.name=name;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (size != event.size) return false;
        if (start != event.start) return false;
        if (end != event.end) return false;
        return name != null ? name.equals(event.name) : event.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + size;
        result = 31 * result + start;
        result = 31 * result + end;
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
