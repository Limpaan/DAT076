package chl.hajo.library.core;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * An Address (part of Author)
 * 
 * Using Lombok
 * Core model class
 * @author hajo
 */
@NoArgsConstructor
public class Address implements Serializable {

    @Getter
    private String street;
    @Getter
    private int nbr;
    @Getter
    private String town;

    public Address(String street, int nbr, String town) {
        this.street = street;
        this.nbr = nbr;
        this.town = town;
    }

    @Override
    public String toString() {
        return street + " " + nbr + ", " + town;
        //return "Address{" + "street=" + street +
        //        ", nbr=" + nbr + ", town=" + town + '}';
    }
    
   
    
    
}
