package ps.simplystrategypatternusinglambda06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFillters {

	
	
	public static List<Stock> bySymbol(List<Stock> list,String symbol){
		List<Stock> filteredData=new ArrayList<>();
		for(Stock stock:list) {
			if(stock.getSymbol().equals(symbol))
				filteredData.add(stock);
		}
		return filteredData;
		
	}
	
	public static List<Stock> byPriceAbove(List<Stock> list,double price) {
		
		List<Stock> filteredData=new ArrayList<>();
		for( Stock stock:list) {
			if(stock.getPrice()>price) {
				filteredData.add(stock);
			}
		}
		return filteredData;
		
	}
	
	 public static List<Stock> filter(List<Stock> list, Predicate<Stock> predicate) {
	        List<Stock> filteredData = new ArrayList<>();
	        for (Stock stock : list) {
	            if (predicate.test(stock)) {
	                filteredData.add(stock);
	            }
	        }
	        return filteredData;
	    }

	    public static void main(String[] args) {
	        List<Stock> stocks = new ArrayList<>();
	        stocks.add(new Stock("AMPL", 318.65, 10));
	        stocks.add(new Stock("MSFT", 166.86, 45));
	        stocks.add(new Stock("Google", 99.0, 12));
	        stocks.add(new Stock("AMZ", 1866.74, 45));
	        stocks.add(new Stock("GOOGL", 1480.2, 3));
	        stocks.add(new Stock("AMPL", 318.65, 8));
	        stocks.add(new Stock("AMZ", 1866.74, 9));

	       
	        System.out.println("\n 1.Print all the Stock Details");
	        stocks.forEach(System.out::println);

	        
	        Predicate<Stock> symbolAMZPredicate = stock -> stock.getSymbol().equals("AMZ");
	        List<Stock> filteredBySymbolAMZ = filter(stocks, symbolAMZPredicate);
	        System.out.println("\n 2.Symbol is equals to AMZ--");
	        filteredBySymbolAMZ.forEach(System.out::println);

	        
	        Predicate<Stock> priceAbove300Predicate = stock -> stock.getPrice() > 300.0;
	        List<Stock> filteredByPriceAbove300 = filter(stocks, priceAbove300Predicate);
	        System.out.println("\n 3.Price is above 300");
	        filteredByPriceAbove300.forEach(System.out::println);
	    }

}
