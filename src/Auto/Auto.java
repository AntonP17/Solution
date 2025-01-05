package Auto;

public abstract class Auto implements Movement{

    private String model;
    private String engine;
    private int year;
    private String color;

    public void setModel(String model){

        this.model = model;
    }

    public String getModel(){

        return model;
    }

    public void setEngine(String engine){
        this.engine = engine;
    }

    public String getEngine(){
        return engine;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return year;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }




}