package pers.yuzhyn.azylee.study.stta;

/**
 * <p>Title: HiUnit</p>
 * <p>Description: junit demo2
 * <P>Program: javatraining
 * <P>Copyright:histone.com
 *
 * @author Ma Yinghui
 * @date 2019-11-26 22:59
 */
public final class HiUnit implements Comparable<HiUnit> {
    private static int count;
    private final int id;
    private int value;

    public HiUnit() {
        id = count++;
    }

    public int getId() {
        return this.id;
    }

    @Deprecated
    public void setId(int id) throws IllegalAccessException {
        throw new IllegalAccessException("id不允许修改");
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        System.out.println("id:" + id);
        return id;
    }

    @Override
    public String toString() {
        System.out.println("id:" + id);
        return Integer.toString(id);
    }


    @Override
    public int compareTo(HiUnit o) {
        return (Integer.valueOf(o.getValue()).compareTo(Integer.valueOf(this.value)));
    }
}
