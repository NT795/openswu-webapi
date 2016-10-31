package cn.swu.edu.opensource.openswu_webapi_jersey.quitnet;

import cn.swu.edu.opensource.openswu_webapi_jersey.constant.Constant;
import cn.swu.edu.opensource.openswu_webapi_jersey.utils.Client;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 西南大学开源协会 陈思定  on 2016/5/29.
 * <p>
 * Email : sidingchan@gmail.com
 *
 * break the swu-net connection.
 */
public class Quit {

    private String response;

    private Client client;
//    public void doQuit(String username,String password){
//        List<NameValuePair> entries = new ArrayList<>();
//        entries.add(new BasicNameValuePair("username", username));
//        entries.add(new BasicNameValuePair("password", password));
//
//        this.response = new Client().doPost(Constant.urlQuitNet,entries);
//    }

    private static final String urlOnlineDevice = "http://service2.swu.edu.cn/selfservice/module/webcontent/web/onlinedevice_list.jsf";

    public Quit() {
        this.client = new Client();
    }

    // TODO 需要重构doQuit()方法，以应对退网系统的修改
    public void doQuit(String username,String password){
        List<NameValuePair> entries = new ArrayList<>();
        entries.add(new BasicNameValuePair("name", username));
        entries.add(new BasicNameValuePair("password", password));

        String res = client.doPost(Constant.urlSelfServiceNetwork, entries);

//        System.out.println("inself"+ res);
        client.doGet(urlOnlineDevice);
        List<NameValuePair> quitEntries = new ArrayList<>();
        quitEntries.add(new BasicNameValuePair("key", username + ":10.60.0.73"));

        this.response = this.client.doPost(Constant.urlNewQuitNet, quitEntries);


    }

    public String getResponse(){
        return this.response;
    }

}
