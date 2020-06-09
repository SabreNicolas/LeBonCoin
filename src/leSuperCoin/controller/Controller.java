package leSuperCoin.controller;

import leSuperCoin.model.Model;
import leSuperCoin.view.View;


public class Controller {
    private Model model;
    private View view;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);
    }

    public Model getModel(){
        return this.model;
    }
    public View getView(){
        return this.view;
    }
}
