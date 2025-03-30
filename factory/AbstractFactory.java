package designpatterns.factory;

public interface AbstractFactory {

     Coffee getCoffee(String coffeeType);

}

// This is created so that our Coffee Server does not depend on Concrete Factory class rather it depends on abstract Factory
