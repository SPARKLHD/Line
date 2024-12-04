/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.view.menu;


import org.example.controller.action.ActionInterface;
import org.example.controller.state.State;

/**
 *
 * @author Netbeans
 */
public class SwitchAction implements Command{
    ActionInterface actionInterface;
    State state;

    public SwitchAction(ActionInterface actionInterface, State state) {
        this.actionInterface = actionInterface;
        this.state = state;
    }

   
    @Override
    public void execute() {
        state.setAction(actionInterface);
    }
    
}
