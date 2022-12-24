package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
    public boolean doesUpper(String str){
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean doesLower(String str){
        for(int i=0;i<str.length();i++){
            if(Character.isLowerCase(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean doesDigit(String str){
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean doesSpecial(String str){
        for(int i=0;i<str.length();i++){
            if(!Character.isAlphabetic(str.charAt(i)) && !Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public void changePassword(String oldPassword, String newPassword){
        if(oldPassword.equals(this.password) && newPassword.length()>7 && doesUpper(newPassword) && doesLower(newPassword) && doesDigit(newPassword) && doesSpecial(newPassword)){
            this.password=newPassword;
        }
    }
}
