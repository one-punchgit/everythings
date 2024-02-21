package com.zb.thing.basic.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TelnetPortTest {

    public static boolean pingIp(String ip) throws UnknownHostException, IOException {
        //能ping通放回true 反之 false 超时时间 3000毫秒
        return InetAddress.getByName(ip).isReachable(5000);
    }

    public static boolean checkConnectivity(String host, int port) {
        try (Socket socket = new Socket()) {
            InetSocketAddress socketAddress = new InetSocketAddress(host, port);
            socket.connect(socketAddress, 500);
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public static void main(String[] args) {
//        try {
//            boolean b = TelnetPortTest.pingIp("10.1.3.32");
//            System.out.println("ping ip result:"+ b);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

            boolean telnetport1 = TelnetPortTest.checkConnectivity("10.1.3.32", 18003);
            boolean telnetport2 = TelnetPortTest.checkConnectivity("10.1.3.32", 18002);
            boolean telnetport3 = TelnetPortTest.checkConnectivity("10.1.3.32", 18001);
            System.out.println("telnetport result:"+telnetport1);
            System.out.println("telnetport result:"+telnetport2);
            System.out.println("telnetport result:"+telnetport3);
    }


}
