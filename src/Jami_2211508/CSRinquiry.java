
package Jami_2211508;


public class CSRinquiry {
    protected String inquiry;
    protected int id;
    protected String details;  

    public CSRinquiry() {
    }

    public CSRinquiry(String inquiry, int id, String details) {
        this.inquiry = inquiry;
        this.id = id;
        this.details = details;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "CSRinquiry{" + "inquiry=" + inquiry + ", id=" + id + ", details=" + details + '}';
    }
    
    
}
