import usecase1.MemPackage;

import java.util.ArrayList;


public class DisplayMemPacks {
//    MemPackage memPackage = new MemPackage () ; 
    public void Displaying (MemPackage memPackage) {
        // for the first displaying 
        
        System.out.println("Package name is : " + memPackage.getPackName() );
        
        System.out.println("Duration : " + memPackage.getDuration());
}
    public void Displayclasses (ArrayList<String> classes ){
//        ArrayList<String> classess = new  ArrayList<String> () ; 
System.out.println("The classes in the package is : ");  
//for (int i = 0; i < classes.size(); i++)
for (  String i   : classes ){
    System.out.println(i); 
}
        
    } 
        public void Displayfacilities  (ArrayList<String> facilities  ){

System.out.println("The facilities  in the package is : ");  

for (  String i   : facilities  ){
    System.out.println(i); 
}
        
    }
    
    }
