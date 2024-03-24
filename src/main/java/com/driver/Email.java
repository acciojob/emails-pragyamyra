package com.driver;


public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId= emailId;
        this.password = "Accio@123";
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        if(newPassword.length()<8 || !oldPassword.equals(getPassword())){
            return;
        }

            boolean uppCount= false;
            boolean  lowCount= false;
            boolean intCount= false;
            boolean spChar= false;

            for(int i=0;i<newPassword.length();i++){
                char ch= newPassword.charAt(i);
                if(ch>='a' && ch<='z')
                    lowCount=true;
                if(ch>='A' && ch<='Z')
                    uppCount=true;
                if(ch>='0' && ch<='9')
                    intCount=true;
                else
                    spChar=true;
            }

            if(lowCount && uppCount && intCount && spChar){
                setPassword(newPassword);
            }



        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
