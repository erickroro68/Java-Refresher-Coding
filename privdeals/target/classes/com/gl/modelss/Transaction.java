
import java.math.BigDecimal;

public class Transaction {
    private BigDecimal itemPrice;
    private int quantity;
    private BigDecimal taxRate;
    private BigDecimal gasFee;
    private BigDecimal escrowFee;

    public Transaction (BigDecimal itemPrice, int quantity, BigDecimal taxRate, BigDecimal gasFee, BigDecimal escrowFee) {
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.taxRate = taxRate;
        this.gasFee = gasFee;
        this.escrowFee = escrowFee;
    }
    
    //getters
    public BigDecimal getItemPrice(){
        return itemPrice;
    }

    public int getQuantity(){
        return quantity;
    }
    
   public BigDecimal getTaxRate(){
        return taxRate;
   }
    
    public BigDecimal getGasFee(){
        return gasFee;
    }
    
    public BigDecimal getEscrowFee(){
        return escrowFee;
    }
}























    
}
