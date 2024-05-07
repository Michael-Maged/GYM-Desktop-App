
public class VisaPayment {
    private String cardNumber;
    private String cardHolderName;
    private int expiryMonth;
    private int expiryYear;
    private int cvv;

    public VisaPayment(String cardNumber, String cardHolderName, int expiryMonth,int expiryYear, int cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvv = cvv;
    }

    public static boolean payWithVisa(String cardNumber, String cardHolderName,int expiryMonth,int expiryYear, int cvv, double amount) {
        if (isValidCardNumber(cardNumber) && isValidCVV(cvv)) {
            boolean paymentSuccess = processPayment(amount);
            return paymentSuccess;
        } else {
            System.out.println("Invalid card details. Please check your input.");
            return false;
        }
    }
    

    private static boolean processPayment(double amount) {
        // Simulate payment processing (for demonstration purposes, assume payment is successful if amount > 0)
        return amount > 0;
    }
    
    private static boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.length() == 16 && cardNumber.matches("\\d+");
    }
    
    private static boolean isValidCVV(int cvv) {
        return cvv >= 100 && cvv <= 999;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

}
