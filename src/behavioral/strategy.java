// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using credit card " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal with email " + email);
    }
}

class BankTransferPayment implements PaymentStrategy {
    private String accountNumber;

    public BankTransferPayment(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via bank transfer to account " + accountNumber);
    }
}

// Context (Contexte)
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Choose Credit Card payment
        cart.setPaymentStrategy(new CreditCardPayment("1234 5678 9012 3456", "12/25"));
        cart.checkout(100); // Output: Paid 100 using credit card 1234 5678 9012 3456

        // Choose PayPal payment
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(50); // Output: Paid 50 using PayPal with email user@example.com

        // Choose Bank Transfer payment
        cart.setPaymentStrategy(new BankTransferPayment("12345678"));
        cart.checkout(200); // Output: Paid 200 via bank transfer to account 12345678
    }
}
