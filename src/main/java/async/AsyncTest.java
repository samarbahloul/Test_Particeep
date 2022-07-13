package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
	  CompletableFuture<Option<Ceo>> completableFuture = new CompletableFuture<>();
    for(int i=0;i<ceos.size();i++) {
    	if(ceos.get(i).id == ceo_id) {
    		completableFuture.complete(Option.of(ceos.get(i)));
    	}
    }
	  return completableFuture;
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
	  CompletableFuture<Option<Enterprise>> completableFuture = new CompletableFuture<>();
	    for(int i=0;i<enterprises.size();i++) {
	    	if(enterprises.get(i).ceo_id == ceo_id) {
	    		completableFuture.complete(Option.of(enterprises.get(i)));
	    	}
	    }
		  return completableFuture;
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
	  CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> completableFuture = new CompletableFuture<>();
	  completableFuture.complete(Tuple.of(getCeoById(ceo_id), getEnterpriseByCeoId(ceo_id)));
	  return completableFuture;
  }
  public static void main(String[] args) throws InterruptedException, ExecutionException {
	  CompletableFuture<Option<Ceo>> completableFuture = getCeoById("ceo_1");	  
	  System.out.println(completableFuture.get());
	  
	  CompletableFuture<Option<Enterprise>> completableFuture2 = getEnterpriseByCeoId("ceo_2");	  
	  System.out.println(completableFuture2.get());
	  
	  CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> completableFuture3 = getCEOAndEnterprise("ceo_2");
	  System.out.println(completableFuture3.get());


	  
  }

}
