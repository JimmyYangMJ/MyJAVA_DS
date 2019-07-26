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
     * 返回结果为0 那么在TreeSet中认为两个类是相同的类
     * @param o
     * @return
     */
	public int compareTo(Object o) {
    	System.out.println("Tiger compareTo()~~~~~~~~~~~");
        return size - ((Tiger) o).getSize();
    }
}
