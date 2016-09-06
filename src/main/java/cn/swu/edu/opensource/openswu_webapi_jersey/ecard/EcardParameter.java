package cn.swu.edu.opensource.openswu_webapi_jersey.ecard;

import cn.swu.edu.opensource.openswu_webapi_jersey.interfaces.Parameter;

/**
 * Created by 西南大学开源协会 陈思定  on 2016/8/23.
 * <p>
 * Email : sidingchan@gmail.com
 */
public class EcardParameter implements Parameter {

    private String cardno;
    private String password;

    // 默认不查询个人信息
    private Boolean personal = false;
    // 默认查询校园卡信息方式为全部页查询
    private Boolean firstPage = false;

    public Boolean getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Boolean firstPage) {
        this.firstPage = firstPage;
    }

    public Boolean getPersonal() {

        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }


    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String getSwuID() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "cardno : " + cardno +
                " password : " + password +
                " personal : " + personal;
    }
}
