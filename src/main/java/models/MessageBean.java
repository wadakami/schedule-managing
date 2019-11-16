package models;

import java.util.Date;

public class MessageBean {
    /**
     * 宛先です。
     */
    private String toUser ;
    /**
     * サイニタイジング後の宛先です。
     */
    private String secureToUser ;
    /**
     * 送信時刻です。
     */
    private Date sendTime ;
    /**
     * 受信確認時刻です。
     */
    private Date receiveTime ;
    /**
     * メッセージ文字列です。
     */
    private String message ;
    /**
     * サイニタイジング後のメッセージ文字列です。
     */
    private String secureMessage ;
    /**
     * SIPレスポンスのステータスコードです。
     */
    private int status ;

//original from here
    //取得したに日時
    private Date date ;

    //何番目の授業か
    private int classTime ;

    //メインユーザーの名前
    private String main_user ;

    //メインは生徒or教師
    private String main ;

    public Date getDate() {
        return date;
    }

    public void setDate(Date then) {
        this.date = then;
    }


    public int getClassTime() {
        return classTime;
    }

    public void setClassTime(int num) {
        this.classTime = num;
    }

    public String getMain_user() {
        return main_user;
    }

    public void setMain_user(String name) {
        this.main_user = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String name) {
        this.main = name;
    }
//original until here


    /**
     * 受信確認時刻を取得します。
     * @return 受信確認時刻
     */
    public Date getReceiveTime() {
        return receiveTime ;
    }

    /**
     * 受信確認時刻を設定します。
     * @param arrivalTime 受信確認時刻
     */
    public void setReceiveTime( Date arrivalTime ) {
        this.receiveTime = arrivalTime ;
    }

    /**
     * メッセージ文字列を取得します。
     * @return メッセージ文字列
     */
    public String getMessage() {
        return message ;
    }

    /**
     * メッセージ文字列を設定します。
     * @param message メッセージ文字列
     */
    public void setMessage( String message ) {
        this.message = message ;
    }

    /**
     * サイニタイジング後のメッセージ文字列を取得します。
     * @return サイニタイジング後のメッセージ文字列
     */
    public String getSecureMessage() {
        return secureMessage;
    }

    /**
     * サイニタイジング後のメッセージ文字列を設定します。
     * @param message サイニタイジング後のメッセージ文字列
     */
    public void setSecureMessage(String secureMessage) {
        this.secureMessage = secureMessage;
    }

    /**
     * 送信時刻を取得します。
     * @return 送信時刻
     */
    public Date getSendTime() {
        return sendTime ;
    }

    /**
     * 送信時刻を設定します。
     * @param sendDate 送信時刻
     */
    public void setSendTime( Date sendDate ) {
        this.sendTime = sendDate ;
    }

    /**
     * 宛先を取得します。
     * @return 宛先
     */
    public String getToUser() {
        return toUser ;
    }

    /**
     * 宛先を設定します。
     * @param toUser 宛先
     */
    public void setToUser( String toUser ) {
        this.toUser = toUser ;
    }

    /**
     * サイニタイジング後の宛先を取得します。
     * @return サイニタイジング後の宛先
     */
    public String getSecureToUser() {
        return secureToUser;
    }

    /**
     * サイニタイジング後の宛先を設定します。
     * @param toUser サイニタイジング後の宛先
     */
    public void setSecureToUser(String secureToUser) {
        this.secureToUser = secureToUser;
    }

    /**
     * SIPレスポンスのステータスコードを取得します。
     * @return SIPレスポンスのステータスコード
     */
    public int getStatus() {
        return status ;
    }

    /**
     * SIPレスポンスのステータスコードを設定します。
     * @param status SIPレスポンスのステータスコード
     */
    public void setStatus( int status ) {
        this.status = status ;
    }

}
