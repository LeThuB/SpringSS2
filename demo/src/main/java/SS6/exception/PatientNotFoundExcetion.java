package SS6.exception;

public class PatientNotFoundExcetion extends RuntimeException{
    public PatientNotFoundExcetion(String message){
        super(message);
    }
}
