/**
 * @author：周熹
 * @date：Created in 2020/11/20 10:48
 * @description：
 * @version :     $
 */

import java.io.Serializable;

/**
 * @author ：周熹
 * @date ：Created in 2020/11/20 10:48
 * @modified By：
 */
public  class CreditApply implements Serializable {
private String Serialno;
private String Name;
private String VouchType;
private double Sum;

    public CreditApply(String Serialno, String Name, String VouchType, double Sum) {
        this.Serialno = Serialno;
        this.Name = Name;
        this.VouchType = VouchType;
        this.Sum = Sum;
    }

    public String getSerialNo() {
        return Serialno;
    }

    public String getName() {
        return Name;
    }

    public String getVouchType() {
        return VouchType;
    }

    public double getSum() {
        return Sum;
    }


}

