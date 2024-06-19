package acodemy.lv.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

public class Config {

    private Credentials credentials;
    private InitWeb initWeb;
    private UserData userData;

    //-----------------------------------------------------
    public static class Credentials {

        private String login;
        private String passwd;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }
    }

    //---------------------------

    public static class InitWeb{
        private String webAddress;

        public String getWebAddress() {
            return webAddress;
        }

        public void setWebAddress(String webAddress) {
            this.webAddress = webAddress;
        }
    }
    //----------------------------

    public static class UserData{
        private String firstName;
        private String lastName;
        private String zipCode;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }

    //----------------------

    public void setInitWeb(InitWeb initWeb) {
        this.initWeb = initWeb;
    }

    public InitWeb getInitWeb() {
        return initWeb;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }


    public Credentials getCredentials() {
        return credentials;
    }

    public void setUserData(UserData userData){
        this.userData=userData;
    }

    public UserData getUserData(){
        return userData;
    }

    public static Config readConfig(){
        Yaml yaml = new Yaml();
        try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("config.yaml")) {
            if (inputStream == null) {
                throw new IOException("config.yaml not found");
            }
            return yaml.loadAs(inputStream, Config.class);
        } catch (IOException e) {
            var message = e.getMessage();
            System.out.println(message);
            return null;
        }


    }
}
