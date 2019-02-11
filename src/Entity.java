public class Entity{
    private int roomNumber;
    public void Move(){
        roomNumber++; //TODO, move correctly
    }
    public int GetRoom(){
        return roomNumber;
    }
}