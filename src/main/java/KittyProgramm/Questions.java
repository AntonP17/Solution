package KittyProgramm;

public interface
Questions {

    default String question1(){
        return "сколько вещей без ошибок?";
    }

    default String question2(){
        return  "Сколько брака?";
    }

    default String question3(){
        return "Сколько с проблемным каркасом?";
    }

    default String question4(){
        return "Сколько с проблемной этикеткой?";
    }

    default String question5(){
       return  "Сколько с проблемной упаковкой?";
    }

    default String question6(){
      return   "Сколько с пятнами,грязью?";
    }

    default String question7(){
      return   "Сколько с распущенными нитками?";
    }


}
