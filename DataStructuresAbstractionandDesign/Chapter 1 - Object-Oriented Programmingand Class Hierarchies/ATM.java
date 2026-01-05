public interface ATM {
        /* Verifies a user's PIN.
        * @Param pin The user's PIN
        * @Return Wheter or not the User's PIN is verified
        */
     boolean verifyPIN(String pin);

        /* Allow the user to select an account. 
        * @return a String representing the account select
        */
        String selectAccount();

        /* Withdraws a specified amount of money
         * @Param account The account from which the money comes
         * @Param amount The amount of money to withdraw
         * @Return Wheter or not the operation was successful
         */
        boolean withdraw(String account, double amount);

        /* Displays the result of an operation 
         *@param pin The user's PIN
          @param account The account selected 
        */
        void display(String pin, boolean success);

         void showBalance(String account);
}
