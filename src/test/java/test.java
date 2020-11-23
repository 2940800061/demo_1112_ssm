import java.util.ArrayList;
import java.util.List;

/**
 * @author ：周熹
 * @date ：Created in 2020/11/20 10:28
 * @modified By：
 */
public class test {
    public static void main(String[] args) {
        CreditApply ca1=new CreditApply("1001", "张三", "抵押", 100000.5);
        CreditApply ca2=new CreditApply("1002", "李四", "质押", 50000);
        CreditApply ca3=new CreditApply("1003", "王五", "质押", 30000);
        CreditApply ca4=new CreditApply("1004", "赵六", "抵押", 60000.51);
        List<CreditApply>list=new ArrayList<CreditApply>(4);
        list.add(ca1);
        list.add(ca2);
        list.add(ca3);
        list.add(ca4);

        double sum=0;
        for(CreditApply c:list){
            System.out.println(c);
            if ("质押".equals(c.getVouchType()));{
                sum =c.getSum();
            }
            System.out.println(sum);
        }
        System.out.println(sum);

        System.out.println(ca1.getSum()+ca2.getSum()+ca3.getSum()+ca4.getSum());

    }
}
