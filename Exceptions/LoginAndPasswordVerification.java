public class LoginAndPasswordVerification {
private class WrongLoginException extends Exception{
    WrongLoginException(){}
    WrongLoginException(String exception) {
        super(exception);
    }
}
    private class WrongPasswordException extends Exception{

        WrongPasswordException(){}
        WrongPasswordException(String exception){
            super(exception);
        }


    }
    private boolean checkCharacter(Character ch){
        return ((ch >= 'a' && ch <= 'z')  || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || (ch == '_') || (ch == '-'));
    }

    public boolean check(String login, String password){
    boolean result=true;
    try {
        if(login.length()>21) throw new WrongLoginException("login length must be less than 20");
        if(password.length()>21) throw new WrongPasswordException("Password length must be less than 20");

        for (Character a : login.toCharArray()) {
            if (!checkCharacter(a))
                throw new WrongLoginException("Login should contain only latin letters, digits or underscores");
        }
        for (Character a : password.toCharArray()) {
            if (!checkCharacter(a))
                throw new WrongLoginException("Password should contain only latin letters, digits or underscores");
        }
    }catch (WrongLoginException | WrongPasswordException e){
        System.out.println(e.getMessage());
        result=false;
    }
    return result;
    }
}
