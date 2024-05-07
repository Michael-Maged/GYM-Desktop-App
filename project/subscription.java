
public class subscription {
    private String type ; 
    private double  price ; 
    private String method ;
    private boolean confirmation ; 
     
    public subscription(String type , double price  , String method ) {
        this.type = type ; 
        this.price =  price  ; 
        this.method = method ; 
        this.confirmation = false ; 
    }
    
    
    public void setType (String type){
        this.type = type ; 
    }
    public void setPrice (double  price) {
        this.price = price  ; 
        
    }
    public void setmethod(String method){
        this.method = method ; 
        
    }
    public String getType(){
        return type ; 
    }
    public double getprice(){
        return price ; 
        
    }
    public String getmethod(){
        return method ; 
        
    }
    
/*    public boolean isConfirmed (){
        return confirmation ; 
    } */
    
    

    

}
