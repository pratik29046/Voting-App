package com.app.voting;

public class UserInfo1 {


        public String username;
        public String email;

        public UserInfo1() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public UserInfo1(String username, String email) {
            this.username = username;
            this.email = email;
        }


}
