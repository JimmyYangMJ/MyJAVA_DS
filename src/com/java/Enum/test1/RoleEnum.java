package com.java.Enum.test1;

/**
 * @author ymj
 * @Date£º 2020/4/25 12:58
 */
public enum RoleEnum implements RoleOperation{
    SUCCEED(1,"SUCCEED_S",3){
        public String op(){
            System.out.println(RoleEnum.SUCCEED.id);
            return RoleEnum.SUCCEED.toString();
        }
    };

    private final int id;

    RoleEnum(int id, String type, int c){
        this.id = id;
    }
}
class as{

    public static void main(String[] args) {
        System.out.println(RoleEnum.valueOf(""));
        System.out.println(RoleEnum.SUCCEED.op() + " " +RoleEnum.SUCCEED.ordinal());

    }
}
