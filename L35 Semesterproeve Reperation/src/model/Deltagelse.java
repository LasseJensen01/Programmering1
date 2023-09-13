package model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;
    private Lektion lektion;
    private Studerende studerende;

    public Deltagelse(Studerende studerende, Lektion lektion){
        this.registreret = false;
        this.status = DeltagerStatus.TILSTEDE;
        this.lektion = lektion;
        this.studerende = studerende;
    }
    //S2 (3 Point)
    public boolean erRegistreretFraværende(){
        if (this.status == DeltagerStatus.FRAVÆR){
            return true;
        } else return false;
    }

    public Studerende getStuderende() {
        return studerende;
    }
    public boolean erSyg(){
        if (status == DeltagerStatus.SYG){
            return true;
        } else return false;
    }
}
