import cn.hutool.core.date.DateTime;


public class DemoPojo {
    private String cellIds;
    private DateTime effectTime;

    public DemoPojo(String cellIds, DateTime effectTime, DateTime expireTime) {
        this.cellIds = cellIds;
        this.effectTime = effectTime;
        this.expireTime = expireTime;
    }

    public String getCellIds() {
        return cellIds;
    }

    public void setCellIds(String cellIds) {
        this.cellIds = cellIds;
    }

    public DateTime getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(DateTime effectTime) {
        this.effectTime = effectTime;
    }

    public DateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(DateTime expireTime) {
        this.expireTime = expireTime;
    }

    private DateTime expireTime;
}
