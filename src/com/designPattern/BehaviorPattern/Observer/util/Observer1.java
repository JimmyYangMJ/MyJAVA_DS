package com.designPattern.BehaviorPattern.Observer.util;


import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer
{

    public void registerSubject(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if (o instanceof SubjectFor3d)
        {
            SubjectFor3d subjectFor3d = (SubjectFor3d) o;
            System.out.println("subjectFor3d's msg更新了 -- >" + subjectFor3d.getMsg());
        }

        if (o instanceof SubjectForSSQ)
        {
            SubjectForSSQ subjectForSSQ = (SubjectForSSQ) o;
            System.out.println("subjectForSSQ's msg更新了 -- >" + subjectForSSQ.getMsg());
        }
    }
}