import java.util.Date;

public class WebSocketMessage {

    /**
     * ������ID
     */
    private String senderId;

    /**
     * ������ID, ���Ϊ0, ���͸�������
     */
    private String receiverId;

    /**
     * �Ự����
     */
    private String messageContent;

    /**
     * ����ʱ��
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