package com.java.JCF.Set;

public class Tiger implements Comparable{
	private int size;
	 
    public Tiger(int s) {
        size = s;    
    }    
    
    public int getSize() {
		return size;
	}

    /**
     * ���ؽ��Ϊ0 ��ô��TreeSet����Ϊ����������ͬ����
     * @param o
     * @return
     */
	public int compareTo(Object o) {
    	System.out.println("Tiger compareTo()~~~~~~~~~~~");
        return size - ((Tiger) o).getSize();
    }
}
