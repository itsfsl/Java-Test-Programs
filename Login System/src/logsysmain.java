package logsys;

public class logsysmain {
    
    public static void main(String[] args) {
        
        idandpasswords idpass = new idandpasswords();
        new loginsys(idpass.getLoginInfo());
    }
}
