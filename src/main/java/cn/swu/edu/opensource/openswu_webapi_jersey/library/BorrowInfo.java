package cn.swu.edu.opensource.openswu_webapi_jersey.library;

/**
 * Created by 西南大学开源协会 陈思定  on 2016/9/2.
 * <p>
 * Email : sidingchan@gmail.com
 */

public class BorrowInfo {
    // 书名
    private String name;
    // 外借时间
    private String borrowTime;
    // 应归还时间
    private String returnTime;
    // 续借次数
    private String renewTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getRenewTime() {
        return renewTime;
    }

    public void setRenewTime(String renewTime) {
        this.renewTime = renewTime;
    }

    public BorrowInfo(String name, String borrowTime, String returnTime, String renewTime) {
        this.name = name;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.renewTime = renewTime;
    }
}
