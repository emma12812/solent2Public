/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.week10.model.test;

import org.junit.Test;
import static org.junit.Assert.*;
import solent.ac.uk.ood.examples.week10.model.Car;
import solent.ac.uk.ood.examples.week10.model.Lorry;
import solent.ac.uk.ood.examples.week10.model.Motorbike;
import solent.ac.uk.ood.examples.week10.model.Vehicle;

/**
 *
 * @author gallenc
 */
public class TestVehicles {

    @Test
    public void bike() {
       Vehicle motorbike = new Motorbike();
       double fee = motorbike.calculateFee();
       System.out.println(fee);
       assertEquals(3.00, fee, 0); 
    }
    @Test
    public void lorry(){
        Vehicle lorry = new Lorry();
        lorry.setWeight(9000.00);
             System.out.println(lorry);
        double fee = lorry.calculateFee();
        System.out.println(fee); 
        assertEquals(15.00, fee, 0);
    }
    @Test
    public void lorry2(){
        Vehicle lorry = new Lorry();
        lorry.setWeight(6000.00);
        double fee = lorry.calculateFee();
        System.out.println(fee); 
        assertEquals(10.00, fee, 0);
    }
 
}
