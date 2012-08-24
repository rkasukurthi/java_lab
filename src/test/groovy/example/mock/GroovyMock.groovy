package example.mock

/**
 * 
 * Currency class used to represent the currency of a particular country.
 * 
 * @author zluo
 *
 */

class Currency
{
	public static final Currency USD= new Currency("USD")
	public static final Currency EUR= new Currency("EUR")
	
	private String currencyCode
	
	private Currency(String currencyCode)
	{
	  this.currencyCode=currencyCode	
	}
	
	public String toString()
	{
		return currencyCode
	}
}

/**
 * exchange rate class which encapulate buying and selling rates for a currency
 */
class ExchangeRate {
	final double fromRate
	final double toRate
	
	public ExchangeRate(double fromRate, double toRate) {
		this.fromRate = fromRate
		this.toRate = toRate
	}
}

/**
 * exchange rate service collaborator
 * 
 * @author zluo
 *
 */
interface ExchangeRateService {
	ExchangeRate retrieveRate(Currency c)
}


/**
 * currency convertor
 */

class InvalidAmountException extends Exception {
	public InvalidAmountException(String message) {super(message);}
}

interface CurrencyConverter {
	double convertFromSterling(double amount, Currency toCurrency) throws InvalidAmountException
	double convertToSterling(double amount, Currency fromCurrency) throws InvalidAmountException
}


/**
 * Class under test
 */

class SterlingCurrencyConverter implements CurrencyConverter {
	private ExchangeRateService exchangeRateService

	public SterlingCurrencyConverter(ExchangeRateService exchangeRateService) {
		this.exchangeRateService = exchangeRateService;
	}

	private double convert(double amount, double rate) throws InvalidAmountException {
		if (amount < 0) {
			throw new InvalidAmountException("amount must be non-negative")
		}
		return amount * rate
	}

	public double convertFromSterling(double amount, example.mock.Currency toCurrency) throws InvalidAmountException {
		return convert(amount, exchangeRateService.retrieveRate(toCurrency).fromRate)
	}

	public double convertToSterling(double amount, example.mock.Currency fromCurrency) throws InvalidAmountException {
		return convert(amount, exchangeRateService.retrieveRate(fromCurrency).toRate)
	}

}

/**
 * Mock using Map coercion
 */

def service = [retrieveRate:{ new ExchangeRate(1.45, 0.57) }] as ExchangeRateService
sterlingConverter = new SterlingCurrencyConverter(service)
convertedAmount=sterlingConverter.convertFromSterling(10.0, Currency.USD)
assert convertedAmount ==15.50

convertedAmount=sterlingConverter.convertFromSterling(10.0, Currency.EUR)
assert convertedAmount ==15.50

/**
 * Mocking using CLosure coercion
 */
service = {new ExchangeRate(1.55, 0.56)} as ExchangeRateService
sterlingConverter = new SterlingCurrencyConverter(service)
convertedAmount=sterlingConverter.convertFromSterling(10.0, Currency.USD)
assert convertedAmount ==15.50

convertedAmount=sterlingConverter.convertFromSterling(10.0, Currency.EUR)
assert convertedAmount ==15.50


