package Test;

import java.util.Objects;

public class EqualsAndHashCode {

    String text1 = "is text 1";
    String text2 = "is text 2";
    String text3 = "is text 33";


    @Override // переопределние метода equals
    public boolean equals(Object o) {
        if (this == o) return true; // если данный обьект класса равен принятому = тру
        if (o == null || getClass() != o.getClass()) return false; // если принятый обьект null или класс текущего обьекта не равен классу принятого обьекта = фолс
        EqualsAndHashCode that = (EqualsAndHashCode) o; // приведение типа входящего обьекта
        return Objects.equals(text1, that.text1) && Objects.equals(text2, that.text2) && Objects.equals(text3, that.text3); // в конце возвращает результат сравнения текущего и входящего обьектов , ну тут все понятно
    }

    @Override // переопределение hashcode
    public int hashCode() {
        int result = text1 != null ? text1.hashCode() : 0; // проверятеся поле 1 не равно ли null , если не равно то хэшкод этого поля присваивается переменной result , если равно 0 то присваивается 0
        result = 31 * result + (text2 != null ? text2.hashCode() : 0); // тут аналогично , если поле 2 не равно null , то хэшкод этого поля прибавляется к первоначальному result , ноумноженному на 31 (почему 31 потому что на джава часто используют это число , я могу использовать и 20 и 50 и 100 так что пофиг)
        result = 31 * result + (text3 != null ? text3.hashCode() : 0); // тут тоже самое
        return result;
    }
}


