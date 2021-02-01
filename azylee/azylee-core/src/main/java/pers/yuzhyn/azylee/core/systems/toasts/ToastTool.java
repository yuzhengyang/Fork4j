package pers.yuzhyn.azylee.core.systems.toasts;

import pers.yuzhyn.azylee.core.logs.Alog;

import java.awt.*;

public class ToastTool {

    public static void displayTray(String caption, String text) throws AWTException {
        if (SystemTray.isSupported()) {
            //Obtain only one instance of the SystemTray object
            SystemTray tray = SystemTray.getSystemTray();

            //If the icon is a file
            Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
            //Alternative (if the icon is on the classpath):
            //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            //Let the system resize the image if needed
            trayIcon.setImageAutoSize(true);
            //Set tooltip text for the tray icon
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);

            trayIcon.displayMessage(caption, text, TrayIcon.MessageType.INFO);
        } else {
            Alog.e("System tray not supported!");
        }
    }

    public static void main(String[] args) throws AWTException {
        System.out.println("***************************");
        Alog.i("***************************");
        System.out.println("***************************");
        Alog.e("***************************");
        System.out.println("***************************");
        Alog.v("***************************");
        System.out.println("***************************");
        Alog.w("***************************");
        System.out.println("***************************");

//        {
//            //swing 弹框
//            //不带图标
//            Toolkit.getDefaultToolkit().beep();
//            JOptionPane.showMessageDialog(null, "信息", "标题", JOptionPane.PLAIN_MESSAGE);
//            //带 ？图标
//            JOptionPane.showMessageDialog(null, "信息", "标题", JOptionPane.QUESTION_MESSAGE);
//            //带 警告 图标
//            JOptionPane.showMessageDialog(null, "信息", "标题", JOptionPane.WARNING_MESSAGE);
//            // 带 警告 图标
//            JOptionPane.showMessageDialog(null, "信息", "标题", JOptionPane.INFORMATION_MESSAGE);
//            //带 错误 图标
//            JOptionPane.showMessageDialog(null, "信息", "标题", JOptionPane.ERROR_MESSAGE);
//        }

//        {
//            ToastTool.displayTray("你好", "好好学习天天向上");
//            Alog.e("执行完成");
//        }
    }
}
