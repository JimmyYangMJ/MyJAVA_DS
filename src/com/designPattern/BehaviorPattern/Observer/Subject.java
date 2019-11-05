package com.designPattern.BehaviorPattern.Observer;


/**
 * ����ӿڣ����е��������ʵ�ִ˽ӿ�
    @author ymj
 */
public interface Subject
{
    /**
     * ע��һ���۲���
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * �Ƴ�һ���۲���
     *
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * ֪ͨ���еĹ۲���
     */
    public void notifyObservers();

}
