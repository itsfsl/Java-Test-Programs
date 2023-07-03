package logsys;

import java.util.HashMap;

public class idandpasswords {
    
    HashMap<String, String> idpass = new HashMap<String, String>();
    
    idandpasswords() {
        idpass.put("faisal", "fsl22");
    }

    protected HashMap getLoginInfo() {
        return idpass;
    }
}
