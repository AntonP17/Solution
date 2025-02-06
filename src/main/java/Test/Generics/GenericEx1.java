package Test.Generics;

public class GenericEx1 <T extends ClassForGenerics & InterfaceForGenerics> { //тут множественное перечисление ,
    // 1 параметр идет всегда класс потом через амперсанду идут интерфейсы
    public static void main(String[] args) {

GenericEx1<TestClassGood> testClassSolution = new GenericEx1<>();
testClassSolution.check();

//!!! Следующие оба варианта не должны работать, закомментируй их:
//GenericEx1<TestClassWrong1> wrong1Solution = new GenericEx1();
//wrong1Solution.check();
//
//GenericEx1<TestClassWrong2> wrong2Solution = new GenericEx1<>();
//wrong2Solution.check();
}

        public void check() {

      System.out.println("Works!");
        }

       public static class TestClassGood extends ClassForGenerics implements InterfaceForGenerics {

       }

       public static class TestClassWrong1 extends ClassForGenerics {

        }

       public static class TestClassWrong2 implements InterfaceForGenerics {

        }

}


interface InterfaceForGenerics {
}

class ClassForGenerics {
}

