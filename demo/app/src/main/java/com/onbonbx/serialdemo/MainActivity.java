package com.onbonbx.serialdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import j2a.awt.AwtEnv;
import onbon.bx05.Bx5GEnv;
import onbon.bx05.Bx5GScreenRS;
import onbon.bx06.Bx6GEnv;
import onbon.bx06.Bx6GScreen;
import onbon.bx06.Bx6GScreenRS;
import onbon.bx06.message.led.ReturnPingStatus;
import onbon.bx06.series.Bx6E;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            // @TODO: 注意，这部分初始化代码在整个工程中只能初始化一次，建议放到 application 的 onCreate 函数中

            // init java.awt
            AwtEnv.link(this.getApplication());

            // enable AntiAlias or not
            // 是否启用抗锯齿
            AwtEnv.configPaintAntiAliasFlag(false);

            // 初始化五代SDK
            // init bx05 sdk
            //Bx5GEnv.initial();

            // 初始化六代SDK
            // init bx06 sdk
            Bx6GEnv.initial();
        }
        catch (Exception ex) {
        }


        // Create screen object, we create a bx05 screen using serial port
        // 创建 screen 对象，这里创建的是一个五代控制器的串口控制器对象
        Bx6GScreenRS screen = new Bx6GScreenRS("Screen1", new Bx6E());

        //
        // connect to the screen
        // 连接控制器
        screen.connect("/dev/ttyS4", Bx6GScreenRS.BaudRate.RATE_57600);

        //
        // send command to screen
        // 发送命令到控制器
        Bx6GScreen.Result<ReturnPingStatus> status = screen.ping();
        if(status.isOK()) {
            System.out.println("It's ok");
        }
        else {
            System.out.println("error");
        }


        // disconnect
        // 断开连接
        screen.disconnect();



    }
}