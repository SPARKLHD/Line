/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.view.menu;;

import org.example.model.FillBehavior;
import org.example.controller.state.State;

/**
 *
 * @author Netbeans
 */
public class SwitchFill implements Command{

    State state;
    FillBehavior fb;

    public SwitchFill(FillBehavior fb,State state) {
        this.state = state;
        this.fb = fb;
    }

    @Override
    public void execute() {
        state.setFb(fb);
    }
}
