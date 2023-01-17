package com.example.supercheap.DisplayComment;

public class DisplayCommentModel {
    private DisplayCommentController controller;
    private DisplayCommentView view;

    public DisplayCommentModel(DisplayCommentController controller, DisplayCommentView view) {
        this.controller = controller;
        this.view = view;
    }

    public DisplayCommentController getController() {
        return controller;
    }

    public void setController(DisplayCommentController controller) {
        this.controller = controller;
    }

    public DisplayCommentView getView() {
        return view;
    }

    public void setView(DisplayCommentView view) {
        this.view = view;
    }

    public boolean checkInfo(String super_name, String super_city){
        if(super_name.isEmpty() || super_city.isEmpty()){
            return false;
        }else
            return true;
    }

    public String lowerCase(String word){
        return word.toLowerCase();
    }
}
