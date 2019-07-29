package com.java.base.impatient;

import java.util.ArrayList;

/**
 * 内部类实例,
 * <br>P 81<br/>
 */
public class Network {
    private ArrayList<Member> members = new ArrayList<>();
    public class Member { // Member is an inner class of Network
        private String name;
        private ArrayList<Member> friends = new ArrayList<>();

        public Member(String name) {
            this.name = name;
        }

        public void deactivate() {

            members.remove(Network.this);
        }

        public void addFriend(Member newFriend) {
            friends.add(newFriend);
        }

        public boolean belongsTo(Network n) {
            System.out.println("Network.this: " + Network.this);
            System.out.println("this: " + this);
            /** Network.this指的是Network类*/
            /** this指的是barney == Member类*/
            return Network.this == n;
        }

        public String toString() {
            StringBuilder result = new StringBuilder(name);
            result.append(" with friends ");
            for (Member friend : friends) {
                result.append(friend.name);
                result.append(", ");
            }
            return result.subSequence(0, result.length() - 2).toString();
        }
    }



    private ArrayList<Integer> s = new ArrayList<>();
    public Member enroll(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public String toString() {
        return members.toString();
    }

    public static void main(String[] args) {

        Network myFace = new Network();
        Network tooter = new Network();
        myFace.s.add(5);
        myFace.enroll("杨");
        myFace.enroll("李");
        System.out.println(myFace);
        System.out.println(myFace.toString());
        System.out.println(myFace.members.size());
        Network.Member fred = myFace.enroll("张");
        Network.Member wilma = myFace.new Member("王");

        //myFace.members.remove(fred);
        // An object, but not enrolled
        // Make the constructor private to avoid this
        fred.addFriend(wilma);

        Network.Member barney = tooter.enroll("本");

        System.out.println("1. " + myFace);

        fred.addFriend(barney);

        System.out.println("2. " +myFace);
        barney.deactivate();
        System.out.println("3. " +myFace);
        // If it shouldn't be possible to add a friend
        // from another network, call belongsTo
        System.out.println(fred.belongsTo(myFace));
        System.out.println(barney.belongsTo(tooter));
        System.out.println(barney.belongsTo(myFace));
    }


}