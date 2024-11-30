package trie2;

interface PaymentStrategy {
	void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using Credit Card.");
	}
}

class PayPalPayment implements PaymentStrategy {
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using PayPal.");
	}
}

class PaymentContext {
	private PaymentStrategy strategy;

	public PaymentContext(PaymentStrategy strategy) {
		this.strategy = strategy;
	}

	public void executePayment(int amount) {
		strategy.pay(amount);
	}
}

public class StrategyExample {
	public static void main(String[] args) {
		PaymentContext context;

		context = new PaymentContext(new CreditCardPayment());
		context.executePayment(100);

		context = new PaymentContext(new PayPalPayment());
		context.executePayment(200);
	}
}
