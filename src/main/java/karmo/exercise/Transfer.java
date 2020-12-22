package karmo.exercise;

import java.math.BigDecimal;

public class Transfer {

    private String fromName;
    private String toName;
    private BigDecimal tAmount;

    public String getFromName() {
        return fromName;
    }

    public Transfer setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public String getToName() {
        return toName;
    }

    public Transfer setToName(String toName) {
        this.toName = toName;
        return this;
    }

    public BigDecimal gettAmount() {
        return tAmount;
    }

    public Transfer settAmount(BigDecimal tAmount) {
        this.tAmount = tAmount;
        return this;
    }
}
