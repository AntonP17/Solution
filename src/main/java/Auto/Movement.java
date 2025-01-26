package Auto;

public interface Movement {

    void on();
    void start();
    void move();
    void stop();
    void off();

    default void gas(){
        System.out.println("увеличение скорости");
    }
    default void brake(){
        System.out.println("уменьшение скорости");
    }

}
