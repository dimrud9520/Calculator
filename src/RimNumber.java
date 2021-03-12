/**
 * Класс перечисления разрешенных для ввода римских цифр
 */
public enum RimNumber {
    I(1 ,"I"),
    II(2,"II"),
    III(3,"III"),
    IV(4,"IV"),
    V(5,"V"),
    VI(6,"VI"),
    VII(7,"VII"),
    VIII(8,"VIII"),
    IX(9,"IX"),
    X(10,"X");

    private int arab;
    private String rim;

    RimNumber(int s, String ar) {
        this.arab = s;
        this.rim=ar;
    }

    public Integer getArab() {
        return arab;
    }

    public String getRim(){
        return rim;
    }


}
