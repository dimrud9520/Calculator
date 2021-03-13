/**
 * Класс перечисления разрешенных для ввода римских цифр
 */
public enum RimNumber {
    I(1 , -1,"I"),
    II(2,-2,"II"),
    III(3,-3,"III"),
    IV(4,-4,"IV"),
    V(5,-5,"V"),
    VI(6,-6,"VI"),
    VII(7,-7,"VII"),
    VIII(8,-8,"VIII"),
    IX(9,-9,"IX"),
    X(10,-10,"X");

    private int arab;
    private int minusArab;
    private String rim;

    RimNumber(int s,int ss, String ar) {
        this.arab = s;
        this.minusArab=ss;
        this.rim=ar;
    }

    public Integer getArab() {
        return arab;
    }

    public String getRim(){
        return rim;
    }

    public Integer getMinusArab(){ return minusArab; }


}
