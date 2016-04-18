/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyTray {

    TrayIcon trayIcon; // 托盘图标  
    SystemTray tray; // 本操作系统托盘的实例  

    public MyTray() {
        
        final MyToolBar toolbar = new MyToolBar();
        
        tray = SystemTray.getSystemTray(); // 获得本操作系统托盘的实例  
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/logo.png")); // 将要显示到托盘中的图标  

        PopupMenu pop = new PopupMenu(); // 构造一个右键弹出式菜单  
        final MenuItem show = new MenuItem("打开程序");
        final MenuItem exit = new MenuItem("退出程序");
        pop.add(show);
        pop.add(exit);
        trayIcon = new TrayIcon(icon.getImage(), "系统托盘", pop);//实例化托盘图标  
        trayIcon.setImageAutoSize(true);
        
        //为托盘图标监听点击事件  
        trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    if (toolbar.isVisible())
                        toolbar.setVisible(false);
                    else {
                        toolbar.setExtendedState(JFrame.NORMAL);
                        toolbar.setVisible(true);
                    }
                }
            }
        });

        //选项注册事件  
        ActionListener al2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //退出程序  
                if (e.getSource() == exit) {
                    System.exit(0);//退出程序  
                }
                //打开程序  
                if (e.getSource() == show) {
                    toolbar.setExtendedState(JFrame.NORMAL); 
                    toolbar.setVisible(true);
                }
            }
        };
        
        exit.addActionListener(al2);
        show.addActionListener(al2);

        try {
            tray.add(trayIcon); // 将托盘图标添加到系统的托盘实例中  
        } catch (AWTException ex) {
            ex.printStackTrace();
        }

        //为主窗体注册窗体事件  
        toolbar.addWindowListener(new WindowAdapter() {
            //窗体最小化事件  
            public void windowIconified(WindowEvent e) {
                toolbar.setVisible(false); 
                toolbar.dispose();  
            }
        });
        
        toolbar.setVisible(true);
    }

    public static void main(String[] args) {
        new MyTray();
    }
}
