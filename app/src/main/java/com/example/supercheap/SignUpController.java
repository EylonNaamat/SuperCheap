package com.example.supercheap;

public class SignUpController {
    private SignUpActivity view;
    private SignUpModel model;

    public SignUpController(SignUpActivity view) {
        this.view = view;
        this.model = new SignUpModel(this);
    }

    public void processingNewUser(String first_name, String last_name, String email, String username, String password, String city, String birth_date, boolean male, boolean female, boolean yes_manager, boolean no_manager, String super_id){
        boolean valid_user = true;
        String gender = "";
        boolean is_manager = true;
        String errors = model.dataValidation(first_name, last_name, email, username, password, city, birth_date, male, female, yes_manager, no_manager, super_id);
//        boolean user_exist =  model.isUserExist(username);

//        if(user_exist){
//            valid_user = false;
//            errors = "user already exists";
//        }

        if(!errors.equals("good")){
            valid_user = false;
        }
        if(male){
            gender = "Male";
        }else{
            gender = "Female";
        }
        is_manager = yes_manager;

        if(valid_user){
            model.insertUserToFb(first_name, last_name, email, username, password, city, birth_date, gender, is_manager, super_id);
        }else{
            view.promptError(errors);
        }
    }

    public void successCreation(String username){
        view.greet(username);
    }

    public void failCreation(String error){
        view.promptError(error);
    }

}
