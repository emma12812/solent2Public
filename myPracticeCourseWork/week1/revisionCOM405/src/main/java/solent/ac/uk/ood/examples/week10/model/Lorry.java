package solent.ac.uk.ood.examples.week10.model;

public class Lorry extends Vehicle {

    @Override
    public Double calculateFee() {
        double fee; 
        
        double weight = getWeight();
        if (weight <= 8000){
            fee = 10.00;
        }
        else{
            fee = 15.00;
        }
        return fee; 
    }
}
