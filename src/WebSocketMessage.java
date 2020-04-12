import java.util.Date;

public class WebSocketMessage {

    /**
     * 发送者ID
     */
    private String senderId;

    /**
     * 接受者ID, 如果为0, 则发送给所有人
     */
    private String receiverId;

    /**
     * 会话内容
     */
    private String messageContent;

    /**
     * 发送时间
     */
    private Date sendTime;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

}