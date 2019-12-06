package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:郝世龙
 *@Date: 2019-12-04
 *@Time:8:50
 *@Description:${DESCRIPTION}
2、	使用GreenDao自动生成bean对象（20分）
 **/
@Entity
public class Automation {
    private int commodityId;
    private String commodityName;
    private String masterPic;
    private int price;
    private int saleNum;
    @Generated(hash = 326056927)
    public Automation(int commodityId, String commodityName, String masterPic,
            int price, int saleNum) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.masterPic = masterPic;
        this.price = price;
        this.saleNum = saleNum;
    }
    @Generated(hash = 24974036)
    public Automation() {
    }
    public int getCommodityId() {
        return this.commodityId;
    }
    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }
    public String getCommodityName() {
        return this.commodityName;
    }
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    public String getMasterPic() {
        return this.masterPic;
    }
    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getSaleNum() {
        return this.saleNum;
    }
    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }
}
