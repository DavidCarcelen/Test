package test.hackathonTest.exceptions;

public class RegisteredEmailException extends RuntimeException{
    public RegisteredEmailException(String message){
        super(message);
    }
}
