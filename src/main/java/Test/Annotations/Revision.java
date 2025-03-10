package Test.Annotations;


public @interface Revision {
    //напиши свой код
    int revision();
    String comment() default "";
    Date date();
    Author[] authors() default {};
}
