package com.zb.thing.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class Test {


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode pre = node;
        while(list1 != null &&list2 != null  ){
            if(list1.val > list2.val){
                node.next = list1;
                list1 = list1.next;

            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;


        }
        while(list1 != null){
            node.next = list1;
            node = node.next;
        }
        while(list2 != null){
            node.next = list2;
            node = node.next;
        }
        return pre;

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) throws ExecutionException, InterruptedException {

        FutureTask task = new FutureTask(new Callable() {
            public Object call() throws Exception {
                System.out.println("通过Callable方式执行任务");
                Thread.sleep(3000);
                return "返回任务结果";
            }
        });
        new Thread(task).start();
        Object o = task.get();
        return null;

//
//        ListNode pre = new ListNode(0);
//        ListNode end = new ListNode(0);
//        pre.next = head;
//        end.next = head;
//
//        while (n > 0) {
//            n--;
//            pre = pre.next;
//        }
//
//        while (pre.next != null) {
//            pre = pre.next;
//            end = end.next;
//        }
//
//        end.next = end.next.next;
//
//
//        return head;


    }

    public static void main(String[] args) {
        Date afterOneMinute = new Date();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("执行~");
            }
        }, afterOneMinute);



//        float testFloat_01 = 456.12522f;
//
//        float v = Float.parseFloat(String.format("%.3f", testFloat_01));
//       float aaa =  ((float) (1673312701978l - 1673312700026l) / 1000);
//        float bb = 61 * 2048 / 2 / aaa;
//        System.out.println(aaa);
//
//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        long timeInMillis = calendar.getTimeInMillis();
//        System.out.println(timeInMillis);
//        User user1 = new User();
//        user1.setName("Alyssa");
//        user1.setFavoriteNumber(256);
//
//        User user2 = new User("Ben", 7, "red");
//
//        User user3 = User.newBuilder()
//                .setName("Charlie")
//                .setFavoriteColor("blue")
//                .setFavoriteNumber(null)
//                .build();
//
//
//// Serialize user1, user2 and user3 to disk
//        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
//        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
//        try {
//            dataFileWriter.create(user1.getSchema(), new FileTest("users1.avro"));
//            dataFileWriter.append(user1);
//            dataFileWriter.append(user2);
//            dataFileWriter.append(user3);
//            dataFileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Schema schema = null;
//        try {
//            schema = new Schema.Parser().parse(new FileTest("src/main/avro/user.avsc"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        GenericRecord user11 = new GenericData.Record(schema);
//        user11.put("name", "Alyssa");
//        user11.put("favorite_number", 256);
//// Leave favorite color null
//
//        GenericRecord user22 = new GenericData.Record(schema);
//        user22.put("name", "Ben");
//        user22.put("favorite_number", 7);
//        user22.put("favorite_color", "red");
//// Serialize user1 and user2 to disk
//        FileTest file = new FileTest("users1.avro");
//        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
//        DataFileWriter<GenericRecord> dataFileWriter1 = new DataFileWriter<GenericRecord>(datumWriter);
//        try {
//            dataFileWriter1.create(schema, file);
//            dataFileWriter1.append(user11);
//            dataFileWriter1.append(user22);
//            dataFileWriter1.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//
//        String day = new SimpleDateFormat("yyyy-MM-dd HH").format(new Date());
//        long startTime = 0;
//        try {
//            startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(day + ":05:00").getTime();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }




//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        calendar.add(Calendar.MINUTE,5);
//        long formatToTime = 0;
//        try {
//            formatToTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getTime();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(calendar.getTimeInMillis());
//        int[] arr = new int[]{2,3,6,7};
//        combinationSum(arr,7);
//        Deque<Integer> path = new ArrayDeque<>();
//        Stack<Integer> integers = new Stack<>();
//        System.out.println(Integer.MIN_VALUE);
//        ListNode list1 = new ListNode(1);
//        ListNode list11 = new ListNode(3);
//        ListNode list111 = new ListNode(5);
//        ListNode list2 = new ListNode(2);
//        ListNode list22 = new ListNode(4);
//        ListNode list222 = new ListNode(6);
//        list1.next = list11;
//        list11.next = list111;
//        list2.next = list22;
//        list22.next = list222;
//        ListNode listNode = reverseList(list1);
//        mergeTwoLists(list1,list2);
//        ListNode head = new ListNode(0);
//        removeNthFromEnd(head,1);
//        Stack<Integer> integers2 = new Stack<Integer>;
//        ArrayList<Integer> integers = new ArrayList<>();
//        ArrayList<Integer> integers1 = new ArrayList<>();
//        boolean b = integers.addAll(integers1);
//
//        int indexOf = SimpleSort11.getIndexOf("abcabcaaacccc", "aaac");
//        String ms = "abcexabciz";
//        int[] nextArray = SimpleSort11.getNextArray(ms.toCharArray());
//        System.out.println(nextArray);
//        int i = 1 << 2;//4
//        i = 1 << 4;//16

//        Node<Integer> node5 = new Node<>(5);
//        Node<Integer> node3 = new Node<>(3);
//        Node<Integer> node7 = new Node<>(7);
//        Node<Integer> node1 = new Node<>(1);
//        node5.left = node3;
//        node5.right = node7;
//        node3.left = node1;

//        SimpleSort5.preOrderRecur(node5);


//        for (int i = 0; i < 11; i++) {
//            double random = Math.random()  5;
//            System.out.println(random);
//            System.out.println((int)random);
//        }


//        Long startTime = TimeUtil.getTimestamp(1);
//
//        Long lastTimeByTime = TimeUtil.getLastTimeByTime(1669012471012l, 1);
//
//
//        System.out.println("ne");

//获取时间戳

//格式化


//        for (int i = 0; i < 11; i++) {
//            double random = Math.random()  5;
//            System.out.println(random);
//            System.out.println((int)random);
//        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 合并两个有序链表
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1 == null){
//            return list2;
//        }
//        if(list2 == null){
//            return list1;
//        }
//
//        if(list1.val<list2.val){
//            list1.next = mergeTwoLists(list1.next,list2);
//            return list1;
//
//        }else{
//
//        }
//
//    }

    //反转链表
    public static ListNode reverseList(ListNode head) {


        //双指针写法
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;

        }
        return pre;



//        Stack<ListNode> stack = new Stack<>();
//        ListNode listNode = new ListNode(0);
//        ListNode pre = listNode;
//        while(head != null){
////            stack.add(head);
//            stack.push(head);
//            head = head.next;
//        }
//        while (!stack.isEmpty()){
//            ListNode pop = stack.pop();
//            pop.next = null;
//            pre.next = pop;
//            pre = pre.next;
//        }
//        return listNode.next;
    }

    //39. 组合总和  [2,3,6,7] 7
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }
    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意 [2,3,6,7] 7
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            log.info("candidates:{},i:{},len:{},target - candidates[i]:{},path:{},res:{}",candidates,i,len,target - candidates[i],path,res);
            dfs(candidates, i, len, target - candidates[i], path, res);
            System.out.println(path);
            path.removeLast();// 状态重置
        }
    }

    static List<List<Integer>> res;
    //102. 二叉树的层序遍历
    public static List<List<Integer>> levelOrder(Node root) {










        return res;

    }

}
