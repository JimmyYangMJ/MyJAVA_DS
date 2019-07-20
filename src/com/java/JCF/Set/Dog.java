package com.java.JCF.Set;

public class Dog {
    private int size;
 
    public Dog(int s) {
        size = s;
    }

    public int getSize() {
		return size;
	}

	/**
	 * �����ж�
	 * @return
	 */
	@Override
	public int hashCode() {
		System.out.println("Dog hashCode()~~~~~~~~~~~");
		return size;
	}

	/**
	 * ����ж�
	 * @param obj2
	 * @return
	 */
	@Override
	public boolean equals(Object obj2)   {
    	System.out.println("Dog equals()~~~~~~~~~~~");
    	if(0==size - ((Dog) obj2).getSize()) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
	@Override
    public String toString() {
    	System.out.print("Dog toString()~~~~~~~~~~~");
        return size + "";
    }
}
