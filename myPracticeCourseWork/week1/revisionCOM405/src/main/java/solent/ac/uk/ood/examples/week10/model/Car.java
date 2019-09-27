package solent.ac.uk.ood.examples.week10.model;

public class Car extends Vehicle {

    @Override
    public Double calculateFee() {
        double weight = getWeight();
        double fee = 5.00;
        double additionalWeight = Math.ceil((weight - 1590) / 100);
        if (additionalWeight > 0){
        fee = fee + (additionalWeight * .1);
        }
        return fee; 
        
    }

   
}
