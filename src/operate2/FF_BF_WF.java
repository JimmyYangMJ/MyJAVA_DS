package operate2;

import java.util.*;

/**
 * 实现 FF BF WF算法
 * @author ymj
 * @Date： 2019/12/24 13:04
 */
public class FF_BF_WF {

    static Scanner cin = new Scanner(System.in);

    /** 数据结构 空闲分区表*/
    static class Free {
        int id; // 分区号
        int start; // 起始地址
        int capacity; // 分区大小
        int status = 0; // 0 表示空闲
        Free (int id, int start, int capacity){
            this.id = id;
            this.start = start;
            this.capacity = capacity;
        }
    }

    static int zoneId = 1; // 分区号递增


    /** 空闲分区链 */
    static LinkedList<Free> LinkedFree = new LinkedList<>();

    static int size;

    /** 显示当前内存状态 */
    public static void showState(){
        System.out.println("---内存状态---");
        System.out.println("分区号  分区大小   分区始址  状态");
        for (Free free: LinkedFree) {
            if(free.status == 0) { // 空闲
                System.out.printf("%d\t\t  %d\t\t  %d\t 空闲\n",free.id, free.capacity, free.start);
            } else {
                System.out.printf("%d\t\t  %d\t\t  %d\t 占用\n",free.id,free.capacity, free.start);
            }

        }
        System.out.println("---end---");
    }

    /** 初始化内存状态 */
    public static void initMemory(){
        size = cin.nextInt();
        LinkedFree.add(new Free(zoneId++, 100, size));
        showState();
    }

    /** FF BF WF 算法 */
    public static void allocation(int choice) {
        System.out.println("输入申请空间大小： ");
        int applySize = cin.nextInt();
        Free temp = null; // 要分配的分区
        boolean flag = false;
        if (choice == 1){
            /**  按照 FF算法 地址从小到大排序*/
            Collections.sort(LinkedFree, (o1, o2) -> o1.start - o2.start);
        }else if (choice == 2) {
            /**  按照BF算法 空闲分区 按 容量递增 排序*/
            Collections.sort(LinkedFree, (o1, o2) -> o2.capacity - o1.capacity);
        }else if (choice == 3) {
            /**  按照WF算法 空闲分区 按 容量递减 排序*/
            Collections.sort(LinkedFree, (o1, o2) -> o1.capacity - o2.capacity);
        }
        Iterator<Free> iterator = LinkedFree.iterator();
        while (iterator.hasNext()) {
            Free p = iterator.next();
            /** 空闲 容量够*/
            if (p.capacity >= applySize && p.status == 0) {
                temp = new Free(zoneId++, p.start, applySize);
                temp.status = 1;
                p.capacity = p.capacity - applySize; // 剩余空闲
                if (p.capacity == 0) { // 空间全部分配
                    iterator.remove(); // 移除此分区
                }
                p.start = p.start + applySize; // 空闲分区地址
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("空间不足， 分配失败");
        }else {
            LinkedFree.add(temp);
            Collections.sort(LinkedFree, (o1, o2) -> o1.start - o2.start);
            showState();
        }

    }
    /** 释放内存*/
    public static void release() {
        Collections.sort(LinkedFree, (o1, o2) -> o1.start - o2.start);
        System.out.println("输入要释放的分区号");
        int id = cin.nextInt();

        // 这里判断 分区号是否合法的算法  省略······
        // 默认 合法
        Iterator<Free> iterator = LinkedFree.iterator();
        int index = 0; // 要移除的分区号 下标
        int index2 = -1; // 要合并的分区号
        while (iterator.hasNext()) {
            Free p = iterator.next();
            index = LinkedFree.indexOf(p);
            if(p.id == id){ // 找到此分区
                Free free1 = null, free3 = null;
                if(index - 1 >= 0){ //前面有分区
                    if (LinkedFree.get(index - 1).status == 0){ // 前 是空闲分区
                        free1 = LinkedFree.get(index - 1);
                    }
                }
                if(index + 1 < LinkedFree.size()) { // 后面有分区
                    if (LinkedFree.get(index + 1).status == 0){ // 后 是空闲分区
                        free3 = LinkedFree.get(index + 1);
                    }
                }
                if (free1 != null && free3 != null) { //合并前后分区
                    free1.capacity += p.capacity + free3.capacity;
                    index2 = index;
                    iterator.remove();
                }else if (free1 != null && free3 == null) { // 合并前面分区
                    free1.capacity += p.capacity;
                    iterator.remove();
                }else if (free1 == null && free3 != null) { // 合并后面分区
                    free3.capacity += p.capacity;
                    free3.start -= p.capacity;
                    iterator.remove();
                }else { // 不需要合并
                    p.status = 0; // 忙碌 变为空闲
                }

            }
        }
        if (index2 != -1) {
            LinkedFree.remove(index2); // 删除合并的内存块信息
        }


    }


    public static void main(String[] args) {
        System.out.println("首次适应算法");
        System.out.println("初始内存大小， 默认起始地址为100");
        initMemory();
        while(true) {
            System.out.println("****1.申请内存   2.释放内存   3.退出****");
            int choice = cin.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("*选择算法*1.FF   2.BF   3.wf****");
                    int c = cin.nextInt();
                    allocation(c);
                    break;
                case 2:
                    release();
                    showState();
                    break;
                case 3: showState();
                return;
            }
        }
    }
}
