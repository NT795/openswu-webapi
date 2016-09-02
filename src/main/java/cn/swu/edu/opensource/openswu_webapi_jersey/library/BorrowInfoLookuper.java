package cn.swu.edu.opensource.openswu_webapi_jersey.library;

import cn.swu.edu.opensource.openswu_webapi_jersey.constant.Constant;
import cn.swu.edu.opensource.openswu_webapi_jersey.interfaces.Parameter;
import cn.swu.edu.opensource.openswu_webapi_jersey.utils.Client;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 西南大学开源协会 陈思定  on 2016/8/23.
 * <p>
 * Email : sidingchan@gmail.com
 */
public class BorrowInfoLookuper extends AbsLibraryLookuper {

    private Client client;

    private List<BorrowInfo> borrowInfoList;

    public BorrowInfoLookuper() {
        borrowInfoList = new ArrayList<>();
    }

    @Override
    public String lookup(Parameter parameter) {
        Client client = loginInLibrarySystem(parameter);

        String borrowInfoHtml = client.doGet(Constant.urlBorrowInfo);

        parse(borrowInfoHtml);

        return new Gson().toJson(borrowInfoList);
    }

    private void parse(String html) {
        Matcher name = Pattern.compile("<td>[\\s]*<a.*?>(.*)<\\/a>[\\s]*<\\/td>").matcher(html);
        Matcher borrowTime = Pattern.compile("<td>(.*)</td>").matcher(html);
        Matcher returnTime = Pattern.compile("<td>(.*)</td>").matcher(html);
        Matcher renewTime = Pattern.compile("<td align=\"center\">&nbsp;([\\S]*)&nbsp;</td>").matcher(html);

        while (name.find()
                && borrowTime.find(name.end())
                && returnTime.find(borrowTime.end())
                && renewTime.find(returnTime.end())) {

            borrowInfoList.add(new BorrowInfo(name.group(1), borrowTime.group(1), returnTime.group(1), renewTime.group(1)));
        }
    }
}
