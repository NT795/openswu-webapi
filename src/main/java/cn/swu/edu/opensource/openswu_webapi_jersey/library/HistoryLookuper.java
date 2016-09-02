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
public class HistoryLookuper extends AbsLibraryLookuper {

    private Client client;

    private List<History> historyList;

    public HistoryLookuper() {
        historyList = new ArrayList<>();
    }

    @Override
    public String lookup(Parameter parameter) {
        Client client = loginInLibrarySystem(parameter);

        String historyHtml = client.doGet(Constant.urlHistory);

        parse(historyHtml);
        if (historyHtml.contains("class=\"next\"")) {
            for (int i = 2; i < 30; i++) {
                historyHtml = client.doGet(Constant.urlHistory + "&page=" + i);
                parse(historyHtml);
                if (!historyHtml.contains("class=\"next\"")) break;
            }
        }

        return new Gson().toJson(historyList);
    }

    private void parse(String html) {


        Matcher name = Pattern.compile("<td>[\\s]*<a.*?>(.*)<\\/a>[\\s]*<\\/td>").matcher(html);
        Matcher author = Pattern.compile("<td>(.*)</td>").matcher(html);
        Matcher press = Pattern.compile("<td>(.*)</td>").matcher(html);
        Matcher time = Pattern.compile("<td>(.*)</td>").matcher(html);

        while (name.find()
                && author.find(name.end())
                && press.find(author.end())
                && time.find(press.end())) {

            historyList.add(new History(name.group(1), author.group(1), press.group(1), time.group(1)));
        }


    }


}
