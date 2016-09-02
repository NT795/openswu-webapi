package cn.swu.edu.opensource.openswu_webapi_jersey.library;

/**
 * Created by 西南大学开源协会 陈思定  on 2016/9/2.
 * <p>
 * Email : sidingchan@gmail.com
 */
public class History {
    // 书名
    private String name;
    // 作者
    private String author;
    // 出版社
    private String press;
    // 处理时间
    private String time;

    public History(String name, String author, String press, String time) {
        this.name = name;
        this.author = author;
        this.press = press;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
