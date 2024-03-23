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

            int uppCount=0;
            int lowCount=0;
            int intCount=0;
            int spChar=0;

            for(int i=0;i<newPassword.length();i++){
                char ch= newPassword.charAt(i);
                if(ch>='a' && ch<='z')
                    lowCount++;
                if(ch>='A' && ch<='Z')
                    uppCount++;
                if(ch>='0' && ch<='9')
                    intCount++;
                else
                    spChar++;
            }

            if(lowCount!=0 && uppCount!=0 && intCount!=0 && spChar!=0){
                setPassword(newPassword);
            }



        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
